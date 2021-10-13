package set;

import java.util.TreeSet;

public class ExampleTreeSet {

    public static void main(String[] args){

        TreeSet<String> treeCapitais = new TreeSet<>();

        treeCapitais.add("Porto Alegre");
        treeCapitais.add("Florianópolis");
        treeCapitais.add("Curitiba");
        treeCapitais.add("São Paulo");
        treeCapitais.add("Rio de janeiro");

        System.out.println(treeCapitais);
    }
}
