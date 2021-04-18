package model;

import controller.RegistroController;

import java.time.Duration;
import java.time.LocalTime;

public class Registro{

    private String atividade;
    private LocalTime inicio;
    private LocalTime fim;

    public Registro(String atividade, LocalTime inicio, LocalTime fim) {
        this.atividade = atividade;
        this.inicio = inicio;
        this.fim = fim;
    }

    public String getAtividade() {
        return atividade;
    }

    public void setAtividade(String atividade) {
        this.atividade = atividade;
    }

    public LocalTime getInicio() {
        return inicio;
    }

    public void setInicio(LocalTime inicio) {
        this.inicio = inicio;
    }

    public LocalTime getFim() {
        return fim;
    }

    public void setFim(LocalTime fim) {
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
