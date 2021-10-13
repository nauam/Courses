package poo3.heranca.exemplo004;

public class Atendente extends Funcionarios{
    public double calculaImposto() {
        return this.getValorVenal() * 0.001;
    }
}
