package view;

import controller.ExceptionController;
import model.Registro;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class PomodoroView extends JFrame {

    private List<Registro> registros = new ArrayList<>();

    private String atividade = "Atividade";
    private Integer horas = 0;
    private Integer minutos = 0;
    private Integer segundos = 30;

    private static JButton registrosButton;
    private static JButton novoButton;

    private final JFrame panels = new JFrame("Pomodoro - Nauam");

    public PomodoroView() {
        View();
    }

    public PomodoroView(String atividade, Integer horas, Integer minutos, Integer segundos, List<Registro> registros) {
        this.atividade = atividade;
        this.horas = horas;
        this.minutos = minutos;
        this.segundos = segundos;
        this.registros = registros;
        View();
    }

    private void View() {
        ExceptionController.getException();
        panels.setLayout(new BorderLayout());
        panels.add(PanelView());
        panels.setSize(280, 250);
        panels.setVisible(true);
        panels.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        registrosButton.addActionListener((ActionEvent e) -> {
            SwingUtilities.invokeLater(() -> new RegistrosView(atividade, horas, minutos, segundos, registros));
            panels.dispose();
        });
        novoButton.addActionListener((ActionEvent e) -> {
            SwingUtilities.invokeLater(() -> new AtividadeEditView(atividade, horas, minutos, segundos, registros));
            panels.dispose();
        });
    }

    private JPanel PanelView() {
        JPanel panel = new JPanel(new MigLayout("insets 50 30 10 10"));
        panel.setBackground(Color.darkGray);

        JLabel pomodoroLabel = new JLabel("Pomodoro");
        pomodoroLabel.setForeground(Color.white);
        pomodoroLabel.setFont(new Font("MonoAlphabet", Font.BOLD, 38));

        Icon registrosIcon = new ImageIcon("src/icon/registros.png");
        registrosButton = new JButton(registrosIcon);
        registrosButton.setContentAreaFilled(false);

        Icon novoIcon = new ImageIcon("src/icon/plus.png");
        novoButton = new JButton(novoIcon);
        novoButton.setContentAreaFilled(false);

        panel.add(pomodoroLabel, "cell 0 0 3 0, alignX center");
        panel.add(registrosButton, "cell 1 1, alignX center");
        panel.add(novoButton, "cell 2 1, alignX center");
        return panel;
    }

}