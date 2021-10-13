package comparators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorsExampleList {

    public static void main(String[] args) {

        List<Estudante> estudantes = new ArrayList<>();

        estudantes.add(new Estudante("Matheus",22));
        estudantes.add(new Estudante("Carla",65));
        estudantes.add(new Estudante("Joice",15));
        estudantes.add(new Estudante("Talison",19));

        System.out.println("--- ordem de inserção ---");
        System.out.println(estudantes);

        estudantes.sort((first,second) -> first.getIdade() - second.getIdade());

        System.out.println("--- ordem natural dos numeros - idade ---");
        System.out.println(estudantes);

        estudantes.sort((first,second) -> second.getIdade() - first.getIdade());

        System.out.println("--- ordem reversa dos numeros - idade ---");
        System.out.println(estudantes);

        estudantes.sort(Comparator.comparingInt(Estudante::getIdade));

        System.out.println("--- ordem natural dos numeros - idade --- (method reference)");
        System.out.println(estudantes);

        estudantes.sort(Estudante::compareTo);

        System.out.println("--- oooooordem natural dos numeros - idade --- (method reference)");
        System.out.println(estudantes);

        estudantes.sort(Comparator.comparingInt(Estudante::getIdade).reversed());

        System.out.println("--- ordem reversa dos numeros - idade --- (method reference)");
        System.out.println(estudantes);

        Collections.sort(estudantes);

        System.out.println("--- ordem natural dos numeros - idade --- (interface Comparable)");
        System.out.println(estudantes);

        Collections.sort(estudantes, new EstudanteOrdemIdadeReversaComparator());

        System.out.println("--- ordem reversa dos numeros - idade --- (interface Comparable)");
        System.out.println(estudantes);
    }
}
