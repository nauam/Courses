package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

import controller.Exception;
import net.miginfocom.swing.*;

public class AtividadeView extends JFrame {

    private final String atividade;
    private final Integer horas;
    private final Integer minutos;
    private final Integer segundos;

    private final JFrame panels = new JFrame("Pomodoro - Nauam");
    private static JButton iniciarButton;
    private static JButton editarButton;
    private JLabel duracaoLabel;
    private Icon iniciarIcon;
    private Icon pausarIcon;

    public AtividadeView(String atividade, Integer horas, Integer minutos, Integer segundos) {
        this.atividade = atividade;
        this.horas = horas;
        this.minutos = minutos;
        this.segundos = segundos;
        View();
    }

    public void View() {
        Exception.getException();
        panels.setLayout(new BorderLayout());
        panels.add(PanelView());
        panels.setSize(550, 300);
        panels.setVisible(true);
        panels.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        iniciarButton.addActionListener((ActionEvent e) -> {
            switch (e.getActionCommand()) {
                case "Iniciar":
                    duracaoLabel.setVisible(true);
                    iniciarButton.setIcon(pausarIcon);
                    iniciarButton.setActionCommand("Pausar");
                    //iniciarController();
                    break;
                case "Pausar":
                    duracaoLabel.setVisible(false);
                    iniciarButton.setIcon(iniciarIcon);
                    iniciarButton.setActionCommand("Iniciar");
                    //pauseController();
                    break;
                default:
                    break;
            }
        });

        editarButton.addActionListener((ActionEvent e) -> {
            //editarController();
        });
    }

    public JPanel PanelView() {
        MigLayout layout = new MigLayout("insets 50 30 10 10");

        JPanel panel = new JPanel(layout);
        panel.setBackground(Color.darkGray);

        JLabel atividadeLabel = new JLabel(atividade);
        atividadeLabel.setForeground(Color.white);
        atividadeLabel.setFont(new Font("MonoAlphabet", Font.BOLD, 38));

        duracaoLabel = new JLabel(String.format("%02d : %02d : %02d", horas, minutos, segundos));
        duracaoLabel.setForeground(Color.white);
        duracaoLabel.setFont(new Font("MonoAlphabet", Font.BOLD, 38));
        duracaoLabel.setVisible(false);

        JLabel alvoLabel = new JLabel(String.format("%02d : %02d : %02d", horas, minutos, segundos));
        alvoLabel.setForeground(Color.white);
        alvoLabel.setFont(new Font("MonoAlphabet", Font.BOLD, 10));

        JLabel faltaLabel = new JLabel(String.format("%02d : %02d : %02d", horas, minutos, segundos));
        faltaLabel.setForeground(Color.white);
        faltaLabel.setFont(new Font("MonoAlphabet", Font.BOLD, 10));

        iniciarIcon = new ImageIcon("src/icon/play.png");
        pausarIcon = new ImageIcon("src/icon/pause.png");
        iniciarButton = new JButton(iniciarIcon);
        iniciarButton.setContentAreaFilled(false);
        iniciarButton.setActionCommand("Iniciar");

        Icon editarIcon = new ImageIcon("src/icon/editar.png");
        editarButton = new JButton(editarIcon);
        editarButton.setContentAreaFilled(false);

        panel.add(atividadeLabel, "cell 0 0 1 0, alignX left");
        panel.add(editarButton, "cell 2 0, alignX right");
        panel.add(iniciarButton, "cell 0 1, alignX left");
        panel.add(duracaoLabel, "cell 1 1 2 1, alignX right");
        panel.add(alvoLabel, "cell 2 2, alignX right");
        panel.add(faltaLabel, "cell 2 3, alignX right");

        return panel;
    }
}
