package view;

import javax.swing.*;

public class PomodoroApplication {

    public static void GUI() {
        String atividade = "Atividade";
        int horas = 0;
        int minutos = 0;
        int segundos = 0;

        AtividadeView atividadeView = new AtividadeView(atividade, horas, minutos, segundos);

        atividadeView.pack();
        atividadeView.setVisible(true);
        atividadeView.setResizable(false);
        atividadeView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(PomodoroApplication::GUI);
    }
}
