package view;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class AtividadeEditView extends JFrame {

    public AtividadeEditView() {
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
        panels.setPreferredSize(new Dimension(310, 250));
        panels.setLayout(new BorderLayout());
        getContentPane().add(panels, BorderLayout.CENTER);

        MigLayout layout = new MigLayout("insets 50 30 10 10");

        JPanel panel = new JPanel(layout);
        panel.setBackground(Color.darkGray);

        JLabel alvoEditLabel = new JLabel("Editar Alvo");
        alvoEditLabel.setForeground(Color.white);
        alvoEditLabel.setFont(new Font("MonoAlphabet", Font.BOLD, 38));

        JLabel alvoLabel = new JLabel("Alvo: ");
        alvoLabel.setForeground(Color.white);
        alvoLabel.setFont(new Font("MonoAlphabet", Font.BOLD, 16));

        JLabel atividadeLabel = new JLabel("Atividade: ");
        atividadeLabel.setForeground(Color.white);
        atividadeLabel.setFont(new Font("MonoAlphabet", Font.BOLD, 16));

        JLabel pontoPrimeiroLabel = new JLabel(":");
        pontoPrimeiroLabel.setForeground(Color.white);
        pontoPrimeiroLabel.setFont(new Font("MonoAlphabet", Font.BOLD, 12));

        JLabel pontoSegundoLabel = new JLabel(":");
        pontoSegundoLabel.setForeground(Color.white);
        pontoSegundoLabel.setFont(new Font("MonoAlphabet", Font.BOLD, 12));

        JTextField atividadeField = new JTextField("Atividade", 11);
        JTextField horasField = new JTextField("02", 2);
        JTextField minutosField = new JTextField("45", 2);
        JTextField segundosField = new JTextField("00", 2);

        Icon gravarIcon = new ImageIcon("src/icon/play.png");
        JButton gravarButton = new JButton(gravarIcon);
        gravarButton.setContentAreaFilled(false);

        Icon excluirIcon = new ImageIcon("src/icon/remove.png");
        JButton excluirButton = new JButton(excluirIcon);
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

        gravarButton.addActionListener((ActionEvent e) -> {
            JOptionPane.showMessageDialog(null,"Gravado\n", null,JOptionPane.INFORMATION_MESSAGE);
            //gravarController();
        });
        excluirButton.addActionListener((ActionEvent e) -> {
            JOptionPane.showMessageDialog(null,"Excluido\n", null,JOptionPane.INFORMATION_MESSAGE);
            //excluirController();
        });

        //atividadeController();
        panels.add(panel);
    }
}
