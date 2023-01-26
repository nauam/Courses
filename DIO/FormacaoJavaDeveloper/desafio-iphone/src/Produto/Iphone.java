package Produto;

public class Iphone implements Musica, Navegador, Telefone{

	@Override
	public void ligar() {
		System.out.println("Ligar para alguém");
	}

	@Override
	public void atender() {
		System.out.println("Atender alguém");
	}

	@Override
	public void correioDeVoz() {
		System.out.println("Abrir o correio de voz");
	}

	@Override
	public void exibirPagina() {
		System.out.println("Exibir pagina do navegador");
	}

	@Override
	public void adicionarAba() {
		System.out.println("Adicionar nova aba no navegador");
	}

	@Override
	public void atualizarPagina() {
		System.out.println("Atualizar a pagina do navegador");
	}

	@Override
	public void tocar() {
		System.out.println("Tocar musica");
	}

	@Override
	public void pausar() {
		System.out.println("Pausar musica");
	}

	@Override
	public void selecionarMusica() {
		System.out.println("Selecionar musica");
	}

}
