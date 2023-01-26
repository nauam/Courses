package Cliente;

import Produto.Iphone;

public class Cliente {
	public static void main(String[] args) {
		Iphone iphone = new Iphone();

		iphone.ligar();
		iphone.exibirPagina();
		iphone.tocar();
	}
}
