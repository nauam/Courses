package candidatura;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
	public static void main(String[] args) {
		ligarParaSelecionados();
	}
	
	static void ligarParaSelecionados() {
		String [] candidatos = {"C0", "C1", "C2", "C3", "C4", "C5", "C6", "C7", "C8", "C9"};
		
		for(String candidato: candidatos) {
			entandoEmContato(candidato);
		}
			
	}
	
	static void entandoEmContato(String candidato) {
		int tentativasRealizadas = 1;
		boolean continuarTentando = true;
		boolean atendeu = false;
		
		do {
			atendeu = atander();
			continuarTentando = !atendeu;
			if (continuarTentando)
				tentativasRealizadas++;
			else
				System.out.println("Contato realizado");
		} while(continuarTentando && tentativasRealizadas < 3);

		if (atendeu)
			System.out.println("Conseguimos contatos com o " + candidato + " na " + tentativasRealizadas);
		else
			System.out.println("Não onseguimos contatos com o " + candidato + ", foram feitas " + tentativasRealizadas + " tentativas de licações");
	}
	
	static boolean atander() {
		return new Random().nextInt(3)==1;
	}
	
	static void imprimirSelecionados() {
		String [] candidatos = {"C0", "C1", "C2", "C3", "C4", "C5", "C6", "C7", "C8", "C9"};
		System.out.println("Imprimindo a lista de camdidatos selecionados");
		
		for(String candidato: candidatos) {
			System.out.println("O candidato selecionando é " + candidato);
		}
			
	}
	
	static void selecaoCandidatos() {
		String [] candidatos = {"C0", "C1", "C2", "C3", "C4", "C5", "C6", "C7", "C8", "C9"};
		
		int candidatosSelecionados = 0;
		int candidatoAtual = 0;
		double salarioBase = 2000;
		
		while(candidatosSelecionados < 5 && candidatoAtual < candidatos.length) {
			String candidato = candidatos[candidatoAtual];
			double salarioPretendido = valorPretendido();
			
			System.out.println("O candidato " + candidato + " solicitou o salário " + salarioPretendido);
			if(salarioBase >= salarioPretendido) {
				System.out.println("O candidato " + candidato + " foi selecionado");
				candidatosSelecionados++;
			}
			candidatoAtual++;
		}
	}
	
	static double valorPretendido() {
		return ThreadLocalRandom.current().nextDouble(1800, 2200);
	}
	
	static void analisarCandidato(double salarioPretendido) {
		double salarioBase = 2000;
		if (salarioBase > salarioPretendido) {
			System.out.println("LIGAR PARA O CANDIDATO");
		} else if (salarioBase == salarioPretendido) {
			System.out.println("LIGAR PARA O CANDIDATO COM UMA CONTRA PROPOSTA");
		} else {
			System.out.println("AGUARDANDO O RESULTADO DOS DEMAIS CANDIDATOS");
		}

	}
}
