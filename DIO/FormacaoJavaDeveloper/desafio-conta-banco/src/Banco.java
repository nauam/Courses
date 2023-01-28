import java.util.List;

public class Banco {

	private String nome;
	private List<Conta> contas;

	public Banco(String nome, List<Conta> contas) {
		super();
		this.nome = nome;
		this.contas = contas;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Conta> getContas() {
		return contas;
	}

	public void setContas(List<Conta> contas) {
		this.contas = contas;
	}
	
	public void listarContas() {
		this.getContas().stream().map(conta -> conta.getCliente().getNome()).forEach(System.out::println);
	}
	
}
