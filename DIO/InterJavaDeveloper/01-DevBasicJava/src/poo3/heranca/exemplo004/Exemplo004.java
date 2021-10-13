package poo3.heranca.exemplo004;

public class Exemplo004 {
    public static void main(String[] args) {

        Funcionarios gerente = new Gerente();
        gerente.setValorVenal(1000.0);
        System.out.println(gerente.calculaImposto()); //10.0

        Funcionarios supervisor = new Supervisor();
        supervisor.setValorVenal(1000.0);
        System.out.println(supervisor.calculaImposto()); //70.0

        Funcionarios atendente = new Atendente();
        atendente.setValorVenal(1000.0);
        System.out.println(atendente.calculaImposto()); //30.0

    }
}
