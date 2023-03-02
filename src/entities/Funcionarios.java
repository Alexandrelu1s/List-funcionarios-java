package entities;

public class Funcionarios {
	private int id;
	private String nome;
	private Double salario;
	
	public Funcionarios(int id, String nome, Double salario) {
		this.id = id;
		this.nome = nome;
		this.salario = salario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getSalario() {
		return salario;
	}
	
	public void aumento(Double porcentagem) {
		Double valor = salario * (porcentagem / 100.0);
		this.salario += valor;
	}
	
	public String toString() {
		return id + ", " + nome + ", " + salario;
	}
}
