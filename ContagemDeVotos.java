
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ContagemDeVotos extends JFrame implements ActionListener {
    private Map<String, Integer> votos;
    private JComboBox<String> participantes;
    private JButton btnVotar;
    private JButton btnMostrarResultados;

    public ContagemDeVotos() {
        setTitle("Contagem de Votos - BBB");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        votos = new HashMap<>();

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 2));

        JLabel lblParticipantes = new JLabel("Participantes:");
        panel.add(lblParticipantes);

        participantes = new JComboBox<>();
        participantes.addItem("Ana");
        participantes.addItem("Bruno");
        participantes.addItem("Carla");
        panel.add(participantes);

        btnVotar = new JButton("Votar");
        btnVotar.addActionListener(this);
        panel.add(btnVotar);

        btnMostrarResultados = new JButton("Mostrar Resultados");
        btnMostrarResultados.addActionListener(this);
        panel.add(btnMostrarResultados);

        add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnVotar) {
            String participanteSelecionado = (String) participantes.getSelectedItem();
            votar(participanteSelecionado);
        } else if (e.getSource() == btnMostrarResultados) {
            mostrarResultados();
        }
    }

    private void votar(String participante) {
        if (votos.containsKey(participante)) {
            votos.put(participante, votos.get(participante) + 1);
        } else {
            votos.put(participante, 1);
        }
        JOptionPane.showMessageDialog(this, "Voto registrado para " + participante + "!");
    }

    private void mostrarResultados() {
        StringBuilder resultados = new StringBuilder();
        resultados.append("Resultados da votação:\n");
        for (String participante : votos.keySet()) {
            resultados.append(participante).append(": ").append(votos.get(participante)).append(" votos\n");
        }
        JOptionPane.showMessageDialog(this, resultados.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ContagemDeVotos contagemDeVotos = new ContagemDeVotos();
                contagemDeVotos.setVisible(true);
            }
        });
    }
}