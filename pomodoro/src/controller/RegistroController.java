package controller;

import model.Registro;
import model.Registros;

import java.time.LocalTime;
import java.util.List;

public class RegistroController {
    private static final Registros registros = new Registros();

    public static void create(String atividade, LocalTime inicio, LocalTime fim){
        Registro registro = new Registro(atividade, inicio, fim);
        registros.inserir(registro);
    }

    public static List<Registro> read(){
        return registros.getRegistros();
    }

    public static String toString(int timerSegundos){
        return String.format("%02d : %02d : %02d"
                , timerSegundos / (60 * 60)
                , (timerSegundos % (60 * 60)) / 60
                , (timerSegundos % (60 * 60)) % 60);
    }

}
