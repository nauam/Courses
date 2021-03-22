package model;

import java.util.Date;
import java.util.Objects;

public class Registro {

    private Integer id;
    private Atividade atividade;
    private Date inicio;
    private Date fim;
    private Date duracao;

    public Registro(Atividade atividade, Date inicio, Date fim, Date duracao) {
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
