package Set;

import java.util.HashSet;
import java.util.Set;

public class ExampleHashSet {

    public static void main(String[] args){

        Set<Integer> notasAlunos = new HashSet<>();

        notasAlunos.add(4);
        notasAlunos.add(2);
        notasAlunos.add(23);
        notasAlunos.add(14);
        notasAlunos.add(55);

        System.out.println(notasAlunos);

        System.out.println(notasAlunos);

        System.out.println(notasAlunos.size());

    }
}
