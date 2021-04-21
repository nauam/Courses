package queue;

import java.util.LinkedList;
import java.util.Queue;

public class ExampleQueue {

    public static void main(String[] args){

        Queue<String> filaBanco = new LinkedList<>();

        filaBanco.add("Pamela");
        filaBanco.add("Patricia");
        filaBanco.add("Roberta");
        filaBanco.add("Flávio");
        filaBanco.add("Anderson");
        filaBanco.clear();
        System.out.println(filaBanco);

        String clienteASerAtendido = filaBanco.poll();

        System.out.println(clienteASerAtendido);

        System.out.println(filaBanco);


    }
}
