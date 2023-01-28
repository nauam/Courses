
public abstract class Conta implements IConta{

	private static int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;
	
	protected int agencia;
	protected int numero;
	protected double saldo;
	protected Cliente cliente;

	public Conta(Cliente cliente) {
		this.agencia = AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
		
	}
	
	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public void sacar(double value) {
		this.saldo -= value;
	}

	@Override
	public void depositar(double value) {
		this.saldo += value;
	}

	@Override
	public void transferir(double value, Conta contaDestino) {
		this.sacar(value);
		contaDestino.depositar(value);
	}

	protected void imprimirInformacoesConta() {
		System.out.printf("Titular: %s\nAgencia: %d\nNumero: %d\nSaldo: %.2f\n", this.cliente.getNome(), this.agencia, this.numero, this.saldo);
	}

}
