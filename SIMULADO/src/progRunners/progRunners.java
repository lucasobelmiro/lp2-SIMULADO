package progRunners;

import java.util.HashMap;

public class progRunners {
	private HashMap<String, Corredor> corredores;

	public progRunners(HashMap<String, Corredor> corredores) {
		this.corredores = new HashMap<String, Corredor>();
	}
	
	public void cadastrarCorredor(String nome, String cpf, int anoNascimento) {
		Corredor corredor = new Corredor(nome, cpf, anoNascimento);
		corredores.put(cpf, corredor);
	}

	public String listarCorredores() {
		String lista = "";
		
		for (Corredor corredor : corredores.values()) {
			lista += corredor.toString() + "\n";
		}
		
		return lista;
	}
	
	public String exibirCategoriaCorredor(String cpf) {
		return corredores.get(cpf).defineCategoria();
	}
	
	public void cadastrarTreinoCorredor(String cpf, double distancia, int tempoEsperado, String descricao) {
		corredores.get(cpf).cadastraTreino(distancia, tempoEsperado, descricao);
	}
	
	public void finalizarTreino (String cpf, int indice, int tempoGasto) {
		corredores.get(cpf).finalizarTreino(indice, tempoGasto);
	}
	
	public int contarTreinosFinalizadosCorredor(String cpf) {
		return corredores.get(cpf).contarTreinosFinalizados();
	}
	
	public double resistenciaCorredor(String cpf) {
		return corredores.get(cpf).calculaResistencia();
	}
}
