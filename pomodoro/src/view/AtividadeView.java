package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import controller.ExceptionController;
import controller.RegistroController;

import model.Registro;
import net.miginfocom.swing.*;

public class AtividadeView extends JFrame {

    private List<Registro> registros;

    private final String atividade;
    private final Integer horas;
    private final Integer minutos;
    private final Integer segundos;

    private static JButton iniciarButton;
    private static JButton voltarButton;
    private static JButton editarButton;
    private JLabel duracaoLabel;
    private JLabel faltaLabel;
    private Icon iniciarIcon;
    private Icon pausarIcon;

    private LocalTime inicio;
    private Timer cont;

    private final JFrame panels = new JFrame("Pomodoro - Nauam");

    public AtividadeView(String atividade, Integer horas, Integer minutos, Integer segundos, java.util.List<Registro> registros) {
        this.atividade = atividade;
        this.horas = horas;
        this.minutos = minutos;
        this.segundos = segundos;
        this.registros = registros;
        RegistroController.carregar(registros);
        View();
    }

    private void View() {
        ExceptionController.getException();
        panels.setLayout(new BorderLayout());
        panels.add(PanelView());
        panels.setSize(470, 280);
        panels.setVisible(true);
        panels.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        iniciarButton.addActionListener((ActionEvent e) -> iniciarController(e.getActionCommand()));
        voltarButton.addActionListener((ActionEvent e) -> {
            registros = RegistroController.read();
            SwingUtilities.invokeLater(() -> new PomodoroView(atividade, horas, minutos, segundos, registros));
            cont.stop();
            panels.dispose();
        });
        editarButton.addActionListener((ActionEvent e) -> {
            SwingUtilities.invokeLater(() -> new AtividadeEditView(atividade, horas, minutos, segundos, registros));
            cont.stop();
            panels.dispose();
        });
    }

    private void iniciarController(String action) {
        int segundosAlvo = horas * 60 * 60 + minutos * 60 + segundos;
        switch (action) {
            case "Iniciar":
                inicio = LocalTime.now();
                iniciarButton.setIcon(pausarIcon);
                iniciarButton.setActionCommand("Pausar");
                cont = new Timer(1000, (ActionEvent event) -> {
                    LocalTime agora = LocalTime.now();
                    Duration duracao = Duration.between(inicio, agora);
                    int segundosCont = Math.toIntExact(duracao.getSeconds());
                    duracaoLabel.setText(RegistroController.toString(segundosCont));
                    int segundosFalta = segundosAlvo - segundosCont;
                    if (segundosFalta >= 0)
                        faltaLabel.setText(RegistroController.toString(segundosFalta));
                    if (segundosFalta == 0)
                        JOptionPane.showMessageDialog(null, "Alvo Alcançado!", "Pomodoro - Nauam", JOptionPane.INFORMATION_MESSAGE);
                });
                cont.start();
                break;
            case "Pausar":
                LocalTime fim = LocalTime.now();
                iniciarButton.setIcon(iniciarIcon);
                iniciarButton.setActionCommand("Iniciar");
                duracaoLabel.setText(RegistroController.toString(0));
                faltaLabel.setText(RegistroController.toString(segundosAlvo));
                cont.stop();
                RegistroController.create(atividade, inicio, fim);
                break;
            default:
                break;
        }
    }

    private JPanel PanelView() {
        JPanel panel = new JPanel(new MigLayout("insets 10 30 10 10"));
        panel.setBackground(Color.darkGray);

        JLabel atividadeLabel = new JLabel(atividade);
        atividadeLabel.setForeground(Color.white);
        atividadeLabel.setFont(new Font("MonoAlphabet", Font.BOLD, 38));

        duracaoLabel = new JLabel(String.format("%02d : %02d : %02d", 0, 0, 0));
        duracaoLabel.setForeground(Color.white);
        duracaoLabel.setFont(new Font("MonoAlphabet", Font.BOLD, 38));

        JLabel alvoLabel = new JLabel(String.format("%02d : %02d : %02d", horas, minutos, segundos));
        alvoLabel.setForeground(Color.white);
        alvoLabel.setFont(new Font("MonoAlphabet", Font.BOLD, 10));

        faltaLabel = new JLabel(String.format("%02d : %02d : %02d", horas, minutos, segundos));
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

        Icon voltarIcon = new ImageIcon("src/icon/seta-esquerda.png");
        voltarButton = new JButton(voltarIcon);
        voltarButton.setContentAreaFilled(false);

        panel.add(voltarButton, "cell 0 0, alignX left");
        panel.add(atividadeLabel, "cell 1 1, alignX center");
        panel.add(editarButton, "cell 3 0, alignX right");
        panel.add(iniciarButton, "cell 0 2 0 5 , alignX left");
        panel.add(duracaoLabel, "cell 1 2 2 2, alignX right");
        panel.add(alvoLabel, "cell 2 4, alignX right");
        panel.add(faltaLabel, "cell 2 5, alignX right");

        return panel;
    }

}