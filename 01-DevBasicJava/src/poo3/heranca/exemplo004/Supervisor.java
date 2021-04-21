package poo3.heranca.exemplo004;

public class Supervisor extends Funcionarios{
    public double calculaImposto() {
        return this.getValorVenal() * 0.0005;
    }
}
