package progRunners;

public class Treinos {
	private double distancia;
	private int tempoEsperado;
	private String descricao;
	private String status;
	private int tempoGasto;
	
	public Treinos(double distancia, int tempoEsperado, String descricao) {
		this.distancia = distancia;
		this.tempoEsperado = tempoEsperado;
		this.descricao = descricao;
		this.status = "não iniciado";
		this.tempoGasto = 0;
	}
	
	@Override
	public String toString() {
		return this.distancia + "km - " + this.tempoEsperado + "min - " + this.descricao;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setTempoGasto(int tempoGasto) {
		this.tempoGasto = tempoGasto;
	}
	
	public String getStatus() {
		return this.status;
	}
	
	public int calculaResistencia() {
		int resistencia = tempoEsperado - tempoGasto;
		if(this.status == "não iniciado") {
			return 0;
		}
		else if (resistencia > 0) {
			return 1;
		}
		else if (resistencia < 0) {
			return -1;
		}
		else {
			return 0;
		}
	}
}
