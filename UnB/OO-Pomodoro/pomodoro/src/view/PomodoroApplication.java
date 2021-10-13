package view;

import javax.swing.*;

public class PomodoroApplication {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(PomodoroView::new);
    }
}
