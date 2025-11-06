package model;

public class Cliente {

	private String idCliente;
	private String nome;
	private String idade;
	private String CPF;
	private String turma;
	private String telefone;
	
	// construtor carregado
	public Cliente(String idCliente, String nome, String idade, String CPF, String turma, String telefone) {
		super();
		this.idCliente = idCliente;
		this.nome = nome;
		this.idade = idade;
		this.CPF = CPF;
		this.turma = turma;
		this.telefone = telefone;
	}

	//construtor vazio
	public Cliente() {
		super();
	}
	
	//getters & setters

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIdade() {
		return idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public String getTurma() {
		return turma;
	}

	public void setTurma(String turma) {
		this.turma = turma;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}
}
