package view;

import controller.ExceptionController;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class AtividadeEditView extends JFrame {

    private String atividade = "Atividade";
    private Integer horas = 0;
    private Integer minutos = 30;
    private Integer segundos = 0;

    private JButton gravarButton;
    private JButton excluirButton;
    private JTextField atividadeField;
    private JTextField horasField;
    private JTextField minutosField;
    private JTextField segundosField;

    private final JFrame panels = new JFrame("Pomodoro - Nauam");

    public AtividadeEditView() {
        View();
    }

    public AtividadeEditView(String atividade, Integer horas, Integer minutos, Integer segundos) {
        this.atividade = atividade;
        this.horas = horas;
        this.minutos = minutos;
        this.segundos = segundos;
        View();
    }

    private void View() {
        ExceptionController.getException();
        panels.setLayout(new BorderLayout());
        panels.add(PanelView());
        panels.setSize(310, 300);
        panels.setVisible(true);
        panels.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        gravarButton.addActionListener((ActionEvent e) -> {
            atividade = String.valueOf(atividadeField.getText());
            horas = Integer.valueOf(horasField.getText());
            minutos = Integer.valueOf(minutosField.getText());
            segundos = Integer.valueOf(segundosField.getText());
            new AtividadeView(atividade, horas, minutos, segundos);
            panels.dispose();
        });
        excluirButton.addActionListener((ActionEvent e) -> panels.dispose());
    }

    private JPanel PanelView() {
        MigLayout layout = new MigLayout("insets 50 30 10 10");

        JPanel panel = new JPanel(layout);
        panel.setBackground(Color.darkGray);

        JLabel alvoEditLabel = new JLabel("Editar Alvo");
        alvoEditLabel.setForeground(Color.white);
        alvoEditLabel.setFont(new Font("MonoAlphabet", Font.BOLD, 38));

        JLabel atividadeLabel = new JLabel("Atividade: ");
        atividadeLabel.setForeground(Color.white);
        atividadeLabel.setFont(new Font("MonoAlphabet", Font.BOLD, 16));

        JLabel alvoLabel = new JLabel("Alvo: ");
        alvoLabel.setForeground(Color.white);
        alvoLabel.setFont(new Font("MonoAlphabet", Font.BOLD, 16));

        JLabel pontoPrimeiroLabel = new JLabel(":");
        pontoPrimeiroLabel.setForeground(Color.white);
        pontoPrimeiroLabel.setFont(new Font("MonoAlphabet", Font.BOLD, 12));

        JLabel pontoSegundoLabel = new JLabel(":");
        pontoSegundoLabel.setForeground(Color.white);
        pontoSegundoLabel.setFont(new Font("MonoAlphabet", Font.BOLD, 12));

        atividadeField = new JTextField(atividade, 11);
        horasField = new JTextField(String.format("%02d", horas), 2);
        minutosField = new JTextField(String.format("%02d", minutos), 2);
        segundosField = new JTextField(String.format("%02d", segundos), 2);

        Icon gravarIcon = new ImageIcon("src/icon/play.png");
        gravarButton = new JButton(gravarIcon);
        gravarButton.setContentAreaFilled(false);

        Icon excluirIcon = new ImageIcon("src/icon/remove.png");
        excluirButton = new JButton(excluirIcon);
        excluirButton.setContentAreaFilled(false);

        panel.add(alvoEditLabel, "cell 0 0 7 0, alignX left");
        panel.add(atividadeLabel, "cell 0 1, alignX right");
        panel.add(atividadeField, "cell 2 1 6 1, alignX center");
        panel.add(alvoLabel, "cell 0 2, alignX right");
        panel.add(horasField, "cell 2 2, alignX center");
        panel.add(pontoPrimeiroLabel, "cell 3 2, alignX center");
        panel.add(minutosField, "cell 4 2, alignX center");
        panel.add(pontoSegundoLabel, "cell 5 2, alignX center");
        panel.add(segundosField, "cell 6 2, alignX center");

        panel.add(gravarButton, "cell 0 3 1 3 2 3, alignX center");
        panel.add(excluirButton, "cell 3 3 4 3 5 3, alignX center");

        return panel;
    }
}
