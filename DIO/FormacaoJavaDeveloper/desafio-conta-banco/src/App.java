import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {
	public static void main(String[] args) {
		
		Cliente nauam = new Cliente("nauam");
		Conta contaCorrente = new ContaCorrente(nauam);
		Conta contaPoupanca = new ContaPoupanca(nauam);
		
		List<Conta> contas = new ArrayList<>();
		contas.addAll(Arrays.asList(contaCorrente, contaPoupanca));
		
		Banco BancoOliver = new Banco("Banco Oliver", contas);
		
		BancoOliver.listarContas();

		
		contaCorrente.depositar(100);
		contaCorrente.transferir(10, contaPoupanca);
		
		contaCorrente.imprimirExtrato();
		contaPoupanca.imprimirExtrato();
	}
}
