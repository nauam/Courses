package model;

public class Atividade extends Classe {
    private Categoria categoria;

    public Atividade(Integer id, String nome, Categoria categoria) {
        super(id, nome);
        this.categoria = categoria;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
