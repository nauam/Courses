package model;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Date;
import java.util.Objects;

public class Registro {

    private Integer id;
    private String atividade;
    private LocalTime inicio;
    private LocalTime fim;
    private Duration duracao;

    public Registro(String atividade, LocalTime inicio, LocalTime fim, Duration duracao) {
        this.atividade = atividade;
        this.inicio = inicio;
        this.fim = fim;
        this.duracao = duracao;
    }

    public Atividade getAtividade() {
        return atividade;
    }

    public void setAtividade(Atividade atividade) {
        this.atividade = atividade;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFim() {
        return fim;
    }

    public void setFim(Date fim) {
        this.fim = fim;
    }

    public Date getDuracao() {
        return duracao;
    }

    public void setDuracao(Date duracao) {
        this.duracao = duracao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Registro)) return false;
        Registro registro = (Registro) o;
        return Objects.equals(id, registro.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
