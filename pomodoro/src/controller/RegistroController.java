package controller;

import model.Registro;

public class RegistroController {
    private Registro[] registros;

    public RegistroController(Registro[] registros) {
        this.registros = registros;
    }

    public Registro[] getRegistros() {
        return registros;
    }

    public void setRegistros(Registro[] registros) {
        this.registros = registros;
    }

}
