package model;

public class ClienteLivro {

	private String idClienteLivro;
	private String tituloLivro;
	private String nomeCliente;
	private String dataEmprestimo;
	private String dataDevolucao;
	private boolean devolvido;
	private String turmaAluno; // NOVO ATRIBUTO
	private String FK_idCliente;
	private String FK_idLivro;
	
	
	// Construtor supercarregado
	public ClienteLivro(String idClienteLivro, String tituloLivro, String nomeCliente, String dataEmprestimo,
			String dataDevolucao, boolean devolvido, String turmaAluno, String FK_idCliente, String FK_idLivro) {
		super();
		this.idClienteLivro = idClienteLivro;
		this.tituloLivro = tituloLivro;
		this.nomeCliente = nomeCliente;
		this.dataEmprestimo = dataEmprestimo;
		this.dataDevolucao = dataDevolucao;
		this.devolvido = devolvido;
		this.turmaAluno = turmaAluno;
		this.FK_idCliente = FK_idCliente;
		this.FK_idLivro = FK_idLivro;
	}

	// Construtor carregado sem data de devolucao
	public ClienteLivro(String tituloLivro, String nomeCliente, String dataEmprestimo, boolean devolvido,
			String turmaAluno, String FK_idCliente, String FK_idLivro) {
		super();
		this.tituloLivro = tituloLivro;
		this.nomeCliente = nomeCliente;
		this.dataEmprestimo = dataEmprestimo;
		this.devolvido = devolvido;
		this.turmaAluno = turmaAluno;
		this.FK_idCliente = FK_idCliente;
		this.FK_idLivro = FK_idLivro;
	}

	// Construtor vazio
	public ClienteLivro() {
		super();
	}

	// Getters e Setters

	public String getTituloLivro() {
		return tituloLivro;
	}

	public void setTituloLivro(String tituloLivro) {
		this.tituloLivro = tituloLivro;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getDataEmprestimo() {
		return dataEmprestimo;
	}

	public void setDataEmprestimo(String dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	public String getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(String dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	public boolean isDevolvido() {
		return devolvido;
	}

	public void setDevolvido(boolean devolvido) {
		this.devolvido = devolvido;
	}

	public String getIdClienteLivro() {
		return idClienteLivro;
	}

	public void setIdClienteLivro(String idClienteLivro) {
		this.idClienteLivro = idClienteLivro;
	}

	public String getTurmaAluno() {
		return turmaAluno;
	}

	public void setTurmaAluno(String turmaAluno) {
		this.turmaAluno = turmaAluno;
	}

	public String getFK_idCliente() {
		return FK_idCliente;
	}

	public void setFK_idCliente(String fK_idCliente) {
		FK_idCliente = fK_idCliente;
	}

	public String getFK_idLivro() {
		return FK_idLivro;
	}

	public void setFK_idLivro(String fK_idLivro) {
		FK_idLivro = fK_idLivro;
	}
}
