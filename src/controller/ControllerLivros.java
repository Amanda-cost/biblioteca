package controller;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import alertas.Alerts;
import application.Main;
import dao.ClienteDAO;
import dao.ClienteLivroDAO;
import dao.LivroDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import model.Cliente;
import model.ClienteLivro;
import model.Livro;

public class ControllerLivros implements Initializable{

    public static Livro livroEditar = new Livro();
    @FXML
    private TableView<Livro> bookTable;

    @FXML
    private Label btSearch;
    
    @FXML
    private Label btEmprestimos;

    @FXML
    private Label btUsuario;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnEdit;

    @FXML
    private TableColumn<Livro, Integer> colId;

    @FXML
    private TableColumn<Livro, String> colTitulo;

    @FXML
    private TableColumn<Livro, String> colGenero;

    @FXML
    private TableColumn<Livro, String> colAutor;

    @FXML
    private TableColumn<Livro, String> colEditora;

    @FXML
    private TableColumn<Livro, String> colAno;

    @FXML
    private TableColumn<Livro, Integer> colQuantDisponivel;

    @FXML
    private TextField searchField;

    @FXML
    private VBox sidebar;

    @FXML
    private Region topSpacer;
    
    @FXML
    private Label txtNome;


    @FXML
    void ActionSearch(MouseEvent event) {
    	  String pesquisa = searchField.getText();
          LivroDAO lDAO = new LivroDAO();
          ObservableList<Livro> lista = FXCollections.observableArrayList(lDAO.search(pesquisa));
          bookTable.setItems(lista);
    }
    
    @FXML
    void ActionTelaUsuario(MouseEvent event) throws IOException {
    	Main.TelaCliente();
    }
    
    @FXML
    void ActionTelaEmprestimos(MouseEvent event) throws IOException {
    	Main.TelaEmprestimo();
    }

    @FXML
    void actionAdd(ActionEvent event) throws IOException {
Main.TelaregLivro();
carregarTableLivros();
    }

    
    @FXML
    void actionEdit(ActionEvent event) throws IOException {
    	int linha = bookTable.getSelectionModel().getSelectedIndex();
    	if(linha == -1) {
    		Alerts.alerterro("ERRO", "SELEÇÃO NULA.", "SELECIONE UMA COLUNA PARA EDITAR");
    	} else {
    	livroEditar = bookTable.getItems().get(linha);
    	Main.TelaEditarLivro();
    }
    	carregarTableLivros();
    	}
    

    
    
    
    
    
    @FXML
    void actionExcluir(ActionEvent event) {
    	int linha = bookTable.getSelectionModel().getSelectedIndex();
    	if(linha == -1) {
    		Alerts.alerterro("ERRO", "SELEÇÃO NULA", "SELECIONE UMA COLUNA PARA EXCLUIR.");
    		
    	} else {
    		Alert msg = new Alert(AlertType.CONFIRMATION);
    		msg.setTitle("EXCLUIR");
    		msg.setContentText("VOCÊ REALMENTE DESEJA APAGAR O LIVRO?");
    		
    		Optional<ButtonType> confirmacao = msg.showAndWait();
    		if(confirmacao.isPresent() && confirmacao.get() == ButtonType.OK) {
    			
    			Livro livro = new Livro();
    			LivroDAO livroDAO = new LivroDAO();
    			livro = bookTable.getItems().get(linha);
    		try {	livroDAO.delete(livro.getIdLivro()); Alerts.alertinfo("SUCESSO.", "OPERAÇÃO SUCEDIDA.", "O LIVRO FOI EXLUÍDO.");}catch(RuntimeException e) {
    			
    		}
    		
    			carregarTableLivros();
    		}
    	}
    }

    
    
    

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		txtNome.setText(controllerLogin.adm.getNome());
		carregarTableLivros();
	}
	
	ObservableList<Livro> listaLivros;
	public void carregarTableLivros() {
		LivroDAO livroDAO = new LivroDAO();
		listaLivros = FXCollections.observableArrayList(livroDAO.read());
		
		colId.setCellValueFactory(new PropertyValueFactory<>("idLivro"));
		colTitulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));
		colGenero.setCellValueFactory(new PropertyValueFactory<>("genero"));
		colAutor.setCellValueFactory(new PropertyValueFactory<>("autor"));
		colEditora.setCellValueFactory(new PropertyValueFactory<>("editora"));
		colAno.setCellValueFactory(new PropertyValueFactory<>("ano"));
		colQuantDisponivel.setCellValueFactory(new PropertyValueFactory<>("quantDisponivel"));
		
		bookTable.setItems(listaLivros);
		
	}
	
}
