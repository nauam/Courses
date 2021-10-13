package poo3.construtores.exemplo004;

public class ExemploInstanciaObjeto {

    public static void main(String[] args) {

        Carro carro = new Carro("Fiat", "Uno", 2010);

        System.out.println(carro.getMarca());
        System.out.println(carro.getModelo());
        System.out.println(carro.getAno());

    }

}
