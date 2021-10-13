package java11;

import java.util.Collection;
import java.util.Set;

public class CollectionExemplo {

    public static void main(String[] args) {
        Collection<String> nomes = Set.of("Joao", "Paulo", "Oliveira", "Santos");

        System.out.println(nomes);
    }
}
