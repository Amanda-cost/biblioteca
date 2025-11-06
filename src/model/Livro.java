package model;

public class Livro {
	


	private String idLivro;
	private String titulo;
	private String genero;
	private String autor;
	private String editora;
	private String ano;
	private int quantDisponivel;
	
	// construtor carregado
	public Livro(String idLivro, String titulo, String genero, String autor, String editora, String ano, int quantDisponivel) {
		super();
		this.idLivro = idLivro;
		this.titulo = titulo;
		this.genero = genero;
		this.autor = autor;
		this.editora = editora;
		this.ano = ano;
		this.quantDisponivel = quantDisponivel;
	}


	
	// construtor vazio
	public Livro() {
		super();
	}



	public String getTitulo() {
		return titulo;
	}



	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}



	public String getGenero() {
		return genero;
	}



	public void setGenero(String genero) {
		this.genero = genero;
	}



	public String getAutor() {
		return autor;
	}



	public void setAutor(String autor) {
		this.autor = autor;
	}



	public String getEditora() {
		return editora;
	}



	public void setEditora(String editora) {
		this.editora = editora;
	}



	public String getAno() {
		return ano;
	}



	public void setAno(String ano) {
		this.ano = ano;
	}



	public int getQuantDisponivel() {
		return quantDisponivel;
	}



	public void setQuantDisponivel(int quantDisponivel) {
		this.quantDisponivel = quantDisponivel;
	}
	
	public String getIdLivro() {
		return idLivro;
	}



	public void setIdLivro(String idLivro) {
		this.idLivro = idLivro;
	}
}
