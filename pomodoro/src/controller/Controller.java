package controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.time.Duration;
import java.time.LocalTime;

public class Controller {
    private final int horas;
    private final int minutos;
    private final int segundos;

    private JLabel duracaoLabel;
    private JLabel faltaLabel;

    public Controller(int horas, int minutos, int segundos) {
        this.horas = horas;
        this.minutos = minutos;
        this.segundos = segundos;
        iniciarController();
    }

    private void iniciarController() {
        int segundosAlvo = horas * 60 * 60 + minutos * 60 + segundos;
        LocalTime inicio = LocalTime.now();
        Timer cont = new Timer(1000, (ActionEvent event) -> {
            LocalTime agora = LocalTime.now();
            Duration duration = Duration.between(inicio, agora);
            int segundosCont = Math.toIntExact(duration.getSeconds());
            duracaoLabel.setText(String.format("%02d : %02d : %02d"
                    , segundosCont / (60 * 60)
                    , (segundosCont % (60 * 60)) / 60
                    , (segundosCont % (60 * 60)) % 60));

            int segundosFalta = segundosAlvo - segundosCont;
            if (segundosFalta >= 0) {
                faltaLabel.setText(String.format("%02d : %02d : %02d"
                        , segundosFalta / (60 * 60)
                        , (segundosFalta % (60 * 60)) / 60
                        , (segundosFalta % (60 * 60)) % 60));
            }
            if (segundosFalta == 0) {
                JOptionPane.showMessageDialog(null, "Alvo Alcançado!", "Pomodoro - Nauam", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        cont.start();
    }
}
