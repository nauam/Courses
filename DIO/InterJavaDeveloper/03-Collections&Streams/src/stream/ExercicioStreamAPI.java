package stream;

import java.util.*;
import java.util.stream.Collectors;

public class ExercicioStreamAPI {
//    {
//        Scanner sc = new Scanner(System.in);
//        int quantidadeListas = sc.nextInt();
//
//        while (sc.hasNextLine()) {
//            String linha = sc.nextLine();
//            List<String> lista = Arrays.asList(linha.split(" "));
//            System.out.println(lista);
//        }
//    }

    public static void main(String[] args) {
        List<String> frutas = new ArrayList<>();

        frutas.add("Maçã");
        frutas.add("Laranja");
        frutas.add("Banana");
        frutas.add("Limão");

        System.out.println(frutas
                .stream()
                .collect(Collectors
                        .groupingBy(fruta -> fruta.substring(0, 1))
                )
        );

        System.out.println(frutas
                .stream()
                .max(Comparator.comparingInt(String::length))
        );

        System.out.println(frutas
                .stream()
                .filter(fruta -> fruta.length() > 5)
                .collect(Collectors.toList())
        );

        System.out.println(frutas
                .stream()
                .anyMatch(fruta -> fruta.contains("X") )
        );
    }
//        System.out.println(frutas
//                .stream()
//                .collect(Collectors.groupingBy(fruta -> fruta.substring(0,1))));
//
//        System.out.println(frutas
//                .stream()
//                .map(fruta -> fruta +"-"+(fruta.length()*2))
//                .collect(Collectors.toList()));
//
///*
//        System.out.println("Contagem: " + (long) frutas.size());
//
//        System.out.println("Maior numero de letras: " + frutas
//                .stream()
//                .max(Comparator.comparingInt(String::length)));
//
//        System.out.println("Menor numero de letras: " + frutas
//                .stream()
//                .min(Comparator.comparingInt(String::length)));
//
//        System.out.println("Com a letra r no nome: " +  frutas
//                .stream()
//                .filter(estudante -> estudante.toLowerCase().contains("r"))
//                .collect(Collectors.toList()));
//
//        System.out.println("Retorna uma nova coleção com a quantidade de letras: " + frutas
//                .stream()
//                .map(estudante -> estudante.concat(" - ").concat(String.valueOf(estudante.length())))
//                .collect(Collectors.toList()));
//
//        System.out.println("Retorna os 3 primeiros elementos: " + frutas
//                .stream()
//                .limit(3)
//                .collect(Collectors.toList()));
//
//        System.out.println("Retorna os elementos: " + frutas
//                .stream()
//                .peek(System.out::println)
//                .collect(Collectors.toList()));
//
//        System.out.println("Retorna os elementos novamente: ");
//        frutas.forEach(System.out::println);
//
//        System.out.println("Todos elementos tem W no mome: " + frutas
//                .stream()
//                .allMatch(estudante -> estudante.contains("W")));
//
//        System.out.println("Tem algum elemento com a no mome: " + frutas
//                .stream()
//                .anyMatch(estudante -> estudante.contains("a")));
//
//        System.out.println("Não tem nenhum elemento com a no mome: " + frutas
//                .stream()
//                .noneMatch(estudante -> estudante.contains("a")));
//
//        System.out.println("Retorna o primeiro elemento: ");
//        frutas.stream().findFirst().ifPresent(System.out::println);
//
//        System.out.println("Operação em cadeado: " + frutas
//                .stream()
//                .peek(System.out::println)
//                .map(estudante -> estudante.concat(" - ").concat(String.valueOf(estudante.length())))
//                .peek(System.out::println)
//                .filter(estudante -> estudante.toLowerCase().contains("r"))
//                .collect(Collectors
////                        .toList()
////                        .joining(", ")
////                        .toSet()
//                        .groupingBy(estudante -> estudante.substring(estudante.indexOf("-") + 1))
//                ));*/
//
//    }
}
