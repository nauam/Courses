package list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExampleList {
    public static void main(String[] args){

        List<String> names = new ArrayList<>();

        names.add("Carlos");
        names.add("Pedro");
        names.add("Anderson");
        names.add("João");

        System.out.println(names);

        names.set(2, "Larissa");

        System.out.println(names);

        Collections.sort(names);

        System.out.println(names);

        names.set(2, "Nauam");

        System.out.println(names);

        names.remove(4);

        System.out.println(names);

        names.remove("Nauam");

        System.out.println(names);

        for (String nomeDoItem: names){
            System.out.println("--->" + nomeDoItem);
        }

        for (String nome : names) {
            System.out.println(nome);
        }


    }
}
