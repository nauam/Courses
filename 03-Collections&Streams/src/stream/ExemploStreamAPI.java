package stream;

import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ExemploStreamAPI {

    public static void main(String[] args) {

        Set<Integer> entradas = new HashSet<>();
        entradas.add(1);
        entradas.add(4);
        entradas.add(3);
        entradas.add(2);

        entradas.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);


        List<String> estudantes = new ArrayList<>();

        estudantes.add("Pedro");
        estudantes.add("Thayse");
        estudantes.add("Marcelo");
        estudantes.add("Carla");
        estudantes.add("Juliana");
        estudantes.add("Thiago");
        estudantes.add("Rafael");
        estudantes.add("Marcelo");

        System.out.println("Contagem: " + (long) estudantes.size());

        System.out.println("Maior numero de letras: " + estudantes
                .stream()
                .max(Comparator.comparingInt(String::length)));

        System.out.println("Menor numero de letras: " + estudantes
                .stream()
                .min(Comparator.comparingInt(String::length)));

        System.out.println("Com a letra r no nome: " +  estudantes
                .stream()
                .filter(estudante -> estudante.toLowerCase().contains("r"))
                .collect(Collectors.toList()));

        System.out.println("Retorna uma nova coleção com a quantidade de letras: " + estudantes
                .stream()
                .map(estudante -> estudante.concat(" - ").concat(String.valueOf(estudante.length())))
                .collect(Collectors.toList()));

        System.out.println("Retorna os 3 primeiros elementos: " + estudantes
                .stream()
                .limit(3)
                .collect(Collectors.toList()));

        System.out.println("Retorna os elementos: " + estudantes
                .stream()
                .peek(System.out::println)
                .collect(Collectors.toList()));

        System.out.println("Retorna os elementos novamente: ");
        estudantes.forEach(System.out::println);

        System.out.println("Todos elementos tem W no mome: " + estudantes
                .stream()
                .allMatch(estudante -> estudante.contains("W")));

        System.out.println("Tem algum elemento com a no mome: " + estudantes
                .stream()
                .anyMatch(estudante -> estudante.contains("a")));

        System.out.println("Não tem nenhum elemento com a no mome: " + estudantes
                .stream()
                .noneMatch(estudante -> estudante.contains("a")));

        System.out.println("Retorna o primeiro elemento: ");
        estudantes.stream().findFirst().ifPresent(System.out::println);

        System.out.println("Operação em cadeado: " + estudantes
                .stream()
                .peek(System.out::println)
                .map(estudante -> estudante.concat(" - ").concat(String.valueOf(estudante.length())))
                .peek(System.out::println)
                .filter(estudante -> estudante.toLowerCase().contains("r"))
                .collect(Collectors
//                        .toList()
//                        .joining(", ")
//                        .toSet()
                                .groupingBy(estudante -> estudante.substring(estudante.indexOf("-") + 1))
                ));

        System.out.println("Operação em cadeado: " + estudantes
                .stream()
                .distinct()
                .collect(Collectors.joining(" ")
                ));

        List<String> numbers = Arrays.asList("1", "2", "1", "3", "4", "4");
        System.out.println(numbers
                .stream()
                .filter(n -> numbers
                        .stream()
                        .filter(x -> x == n)
                        .count() > 0)
                .collect(Collectors.joining(" ")));


    }
}
