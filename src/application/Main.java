package application;

import connectionFactory.ConnectionDatabase;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;



public class Main extends Application {
	
	// public static String tela = "/view/ViewLogin.fxml";
	private static Stage stage;
	private static Scene main;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			stage = primaryStage;
			
			Parent fxmlLogin = FXMLLoader.load(getClass().getResource("/views/TelaLogin.fxml"));
			main = new Scene(fxmlLogin);
			
			//stage.getIcons().add(new Image(getClass().getResourceAsStream("/media/Icone.png")));
			
			stage.setTitle("LOG IN");
			stage.setScene(main);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	

	public static void TelaLivro() throws IOException{
		FXMLLoader fxmlLivro = new FXMLLoader();
		fxmlLivro.setLocation(Main.class.getResource("/views/TelaLivros.fxml"));
		Parent TelaLivro = fxmlLivro.load();
		main = new Scene(TelaLivro);
		stage.setTitle("TELA LIVROS");
		stage.setScene(main);
		stage.setResizable(false);
		stage.centerOnScreen();
		stage.show();
	}
	
	

	public static void TelaEmprestimo() throws IOException{
		FXMLLoader fxmlLivro = new FXMLLoader();
		fxmlLivro.setLocation(Main.class.getResource("/views/TelaEmprestimos.fxml"));
		Parent TelaLivro = fxmlLivro.load();
		main = new Scene(TelaLivro);
		stage.setTitle("TELA EMPRESTIMOS");
		stage.setScene(main);
		stage.setResizable(false);
		stage.centerOnScreen();
		stage.show();
	}
	
	
	public static void TelaCliente() throws IOException{
		FXMLLoader fxmlLivro = new FXMLLoader();
		fxmlLivro.setLocation(Main.class.getResource("/views/telaCliente.fxml"));
		Parent TelaLivro = fxmlLivro.load();
		main = new Scene(TelaLivro);
		stage.setTitle("TELA CLIENTES");
		stage.setScene(main);
		stage.setResizable(false);
		stage.centerOnScreen();
		stage.show();
	}
	
	public static Stage cadLivro;
	public static void TelaregLivro() throws IOException {
		FXMLLoader LivroCadastro = new FXMLLoader();
		LivroCadastro.setLocation(Main.class.getResource("/views/TelaCadLivros.fxml"));
		Parent cadastroLivro = LivroCadastro.load();
		Scene scene2 = new Scene(cadastroLivro);
		cadLivro = new Stage();
		cadLivro.setTitle("CADASTRAR LIVRO");
		cadLivro.initModality(Modality.WINDOW_MODAL);
		cadLivro.setScene(scene2);
		cadLivro.setResizable(false);
		cadLivro.centerOnScreen();
		cadLivro.showAndWait();
	}
	
	
	
	
	public static Stage edLivro;
	public static void TelaEditarLivro() throws IOException {
		FXMLLoader LivroEdit = new FXMLLoader();
		LivroEdit.setLocation(Main.class.getResource("/views/TelaEditLivro.fxml"));
		Parent editLivro = LivroEdit.load();
		Scene scene2 = new Scene(editLivro);
		edLivro = new Stage();
		edLivro.setTitle("EDITAR LIVRO");
		edLivro.initModality(Modality.WINDOW_MODAL);
		edLivro.setScene(scene2);
		edLivro.setResizable(false);
		edLivro.centerOnScreen();
		edLivro.showAndWait();
	}
	
	public static Stage cadEm;
	public static void TelaCadEmprestimos() throws IOException {
		FXMLLoader LivroCadastro = new FXMLLoader();
		LivroCadastro.setLocation(Main.class.getResource("/views/TelaCadEmprestimo.fxml"));
		Parent cadastroLivro = LivroCadastro.load();
		Scene scene2 = new Scene(cadastroLivro);
		cadEm = new Stage();
		cadEm.setTitle("CADASTRAR EMPRESTIMO");
		cadEm.initModality(Modality.WINDOW_MODAL);
		cadEm.setScene(scene2);
		cadEm.setResizable(false);
		cadEm.centerOnScreen();
		cadEm.showAndWait();
	}
	
	public static Stage edEm;
	public static void TelaEditEmprestimo() throws IOException {
		FXMLLoader LivroCadastro = new FXMLLoader();
		LivroCadastro.setLocation(Main.class.getResource("/views/TelaEditEmprestimo.fxml"));
		Parent cadastroLivro = LivroCadastro.load();
		Scene scene2 = new Scene(cadastroLivro);
		edEm = new Stage();
		edEm.setTitle("EDITAR EMPRESTIMO");
		edEm.initModality(Modality.WINDOW_MODAL);
		edEm.setScene(scene2);
		edEm.setResizable(false);
		edEm.centerOnScreen();
		edEm.showAndWait();
	}

	
	public static Stage cadCl;
	public static void TelaCadCliente() throws IOException {
		FXMLLoader LivroCadastro = new FXMLLoader();
		LivroCadastro.setLocation(Main.class.getResource("/views/TelaCadCliente.fxml"));
		Parent cadastroLivro = LivroCadastro.load();
		Scene scene2 = new Scene(cadastroLivro);
		cadCl = new Stage();
		cadCl.setTitle("CADASTRAR EMPRESTIMO");
		cadCl.initModality(Modality.WINDOW_MODAL);
		cadCl.setScene(scene2);
		cadCl.setResizable(false);
		cadCl.centerOnScreen();
		cadCl.showAndWait();
	}
	
	
	public static Stage edCl;
	public static void TelaEditarCliente() throws IOException {
		FXMLLoader LivroCadastro = new FXMLLoader();
		LivroCadastro.setLocation(Main.class.getResource("/views/TelaEditCliente.fxml"));
		Parent cadastroLivro = LivroCadastro.load();
		Scene scene2 = new Scene(cadastroLivro);
		edCl = new Stage();
		edCl.setTitle("CADASTRAR EMPRESTIMO");
		edCl.initModality(Modality.WINDOW_MODAL);
		edCl.setScene(scene2);
		edCl.setResizable(false);
		edCl.centerOnScreen();
		edCl.showAndWait();
	}
	
	
	public static Stage cadAdm;
	public static void TelaCadAdm() throws IOException {
		FXMLLoader LivroCadastro = new FXMLLoader();
		LivroCadastro.setLocation(Main.class.getResource("/views/TelaCadAdmin.fxml"));
		Parent cadastroLivro = LivroCadastro.load();
		Scene scene2 = new Scene(cadastroLivro);
		cadAdm = new Stage();
		cadAdm.setTitle("CADASTRAR EMPRESTIMO");
		cadAdm.initModality(Modality.WINDOW_MODAL);
		cadAdm.setScene(scene2);
		cadAdm.setResizable(false);
		cadAdm.centerOnScreen();
		cadAdm.showAndWait();
	}
	
	
	
	public static void main(String[] args) {
		
		launch(args);
		
	}
}
