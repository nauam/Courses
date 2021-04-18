package controller;

import model.Registro;


public class RegistroController {

    public Registro insert (Registro registro) {
        registro.setId(null);
        return repository.save(registro);
    }

}
