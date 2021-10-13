package model;

import java.util.ArrayList;
import java.util.List;

public class Registros {
    private List<Registro> registros = new ArrayList<>();

    public void inserir(Registro registro) {
        this.registros.add(registro);
    }

    public void setRegistros(List<Registro> registros) {
        this.registros = registros;
    }

    public List<Registro> getRegistros() {
        return this.registros;
    }


}
