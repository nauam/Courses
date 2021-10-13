package view;

import controller.RegistroController;
import model.Registro;

import java.util.ArrayList;
import java.util.List;

public class RegistrosView {
    private final List<Registro> registros;

    private final String atividade;
    private final Integer horas;
    private final Integer minutos;
    private final Integer segundos;

    public RegistrosView(String atividade, Integer horas, Integer minutos, Integer segundos, List<Registro> registros) {
        this.atividade = atividade;
        this.horas = horas;
        this.minutos = minutos;
        this.segundos = segundos;
        this.registros = registros;
        System.out.println(new ArrayList<>(registros));
    }

}