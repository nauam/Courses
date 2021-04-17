package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import net.miginfocom.swing.*;

public class AtividadeView extends JFrame{

    private static JButton iniciarButton;
    private final JLabel duracaoLabel;
    private final Icon iniciarIcon;
    private final Icon pausarIcon;

    public AtividadeView(String atividade, int horas, int minutos, int segundos) {
        setTitle("Pomodoro - Nauam");
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ignored) {

        }
        JPanel panels = new JPanel();
        panels.setPreferredSize(new Dimension(500, 250));
        panels.setLayout(new BorderLayout());
        getContentPane().add(panels, BorderLayout.CENTER);

        MigLayout layout = new MigLayout("insets 50 30 10 10");

        JPanel panel = new JPanel(layout);
        panel.setBackground(Color.darkGray);

        JLabel atividadeLabel = new JLabel(atividade);
        atividadeLabel.setForeground(Color.white);
        atividadeLabel.setFont(new Font("MonoAlphabet",Font.BOLD, 38));

        duracaoLabel = new JLabel(String.format("%02d : %02d : %02d", horas, minutos, segundos));
        duracaoLabel.setForeground(Color.white);
        duracaoLabel.setFont(new Font("MonoAlphabet",Font.BOLD, 38));
        duracaoLabel.setVisible(false);

        iniciarIcon = new ImageIcon("src/icon/play.png");
        pausarIcon = new ImageIcon("src/icon/pause.png");
        iniciarButton = new JButton(iniciarIcon);
        iniciarButton.setContentAreaFilled(false);
        iniciarButton.setActionCommand("Iniciar");

        Icon editarIcon = new ImageIcon("src/icon/editar.png");
        JButton editarButton = new JButton(editarIcon);
        editarButton.setContentAreaFilled(false);

        panel.add(atividadeLabel,"cell 0 0 1 0, alignX left");
        panel.add(editarButton,"cell 2 0, alignX right");
        panel.add(iniciarButton,"cell 0 1, alignX left");
        panel.add(duracaoLabel,"cell 1 1 2 1, alignX right");

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

        //atividadeController();
        panels.add(panel);
    }
}
