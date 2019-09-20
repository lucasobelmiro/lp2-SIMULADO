package progRunners;

import java.util.HashMap;
import java.util.Iterator;

public class Corredor {
	private String nome;
	private String cpf;
	private int anoNascimento;
	private HashMap<Integer, Treinos> treinos;
	
	
	public Corredor(String nome, String cpf, int anoNascimento) {
		this.nome = nome;
		this.cpf = cpf;
		this.anoNascimento = anoNascimento;
		this.treinos = new HashMap<Integer, Treinos>();
	}

	public String defineCategoria() {
		int idade = 2019 - anoNascimento;
		
		if (idade >= 15 && idade <= 24) {
			return "JOVEM";
		}
		else if (idade >= 25 && idade <= 40) {
			return "ADULTO";
		}
		else if (idade >= 41 && idade <= 64) {
			return "SUPER_ADULTO";
		}
		else {
			return "MELHOR_IDADE";
		}
	}
	
	public void cadastraTreino(double distancia, int tempoEsperado, String descricao) {
		Treinos treino = new Treinos(distancia, tempoEsperado, descricao);
		int indice = treinos.size() + 1;
		treinos.put(indice, treino);
	}
	
	public void finalizarTreino(int indice, int tempoGasto) {
		treinos.get(indice).setStatus("terminado");
		treinos.get(indice).setTempoGasto(tempoGasto);
	}
	
	public int contarTreinosFinalizados() {
		int cont = 0;
		for (Treinos treino : treinos.values()) {
			if (treino.getStatus().equals("terminado")) {
				cont += 1;
			}
		}
		return cont;
	}
	
	@Override
	public String toString() {
		defineCategoria();
		return this.nome + " - " + this.cpf + " - " + this.defineCategoria();
	}
	
	public double calculaResistencia() {
		double soma = 0;
		double cont = 0;
		
		for (Treinos treino : treinos.values()) {
			if (treino.getStatus().equals("terminado")) {
				soma += treino.calculaResistencia();
				cont += 1;
			}
		}
		
		return soma/cont;
	}
}
