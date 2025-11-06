package model;

public class Administrador {
	
	private String idAdmin;
	private String nome;
	private String CPF;
	private String senha;
	private String telefone;
	
	//construtor carregado
	public Administrador(String idAdmin, String nome, String CPF, String senha, String telefone) {
		super();
		this.idAdmin = idAdmin;
		this.nome = nome;
		this.CPF = CPF;
		this.senha = senha;
		this.telefone = telefone;
	}
	
	//construtor vazio
	public Administrador() {
		super();
	}

	// getters & setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getIdAdmin() {
		return idAdmin;
	}

	public void setIdAdmin(String idAdmin) {
		this.idAdmin = idAdmin;
	}
}
