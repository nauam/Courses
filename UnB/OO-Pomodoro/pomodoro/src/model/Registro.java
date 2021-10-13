package model;

import controller.RegistroController;

import java.time.Duration;
import java.time.LocalTime;

public class Registro {

    private final String atividade;
    private final LocalTime inicio;
    private final LocalTime fim;

    public Registro(String atividade, LocalTime inicio, LocalTime fim) {
        this.atividade = atividade;
        this.inicio = inicio;
        this.fim = fim;
    }

    public Duration getDuracao(LocalTime inicio, LocalTime fim) {
        return Duration.between(inicio, fim);
    }

    @Override
    public String toString() {
        return "Registro{" +
                "atividade = '" + atividade + '\'' +
                ", inicio = " + inicio +
                ", fim = " + fim +
                ", duração = " + RegistroController.toString(Math.toIntExact(getDuracao(inicio, fim).getSeconds())) +
                '}';
    }
}
