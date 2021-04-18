package model;

import java.util.ArrayList;
import java.util.List;

public class Registros {
    private final List<Registro> registros = new ArrayList<>();

    public void inserir(Registro registro) {
        this.registros.add(registro);
    }

    public List<Registro> getRegistros() {
        return registros;
    }
}
