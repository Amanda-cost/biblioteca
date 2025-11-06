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

public class ControllerEmprestimos implements Initializable{

    public static ClienteLivro emprestimoEditar = new ClienteLivro();

    @FXML
    private Label txtNome;

    @FXML
    private Label BtLivro;

    @FXML
    private Label BtUsuario;

    @FXML
    private Label btPesquisar;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnEdit;

    @FXML
    private TableColumn<ClienteLivro, String> colCliente;

    @FXML
    private TableColumn<ClienteLivro, String> colDevolucao;

    @FXML
    private TableColumn<ClienteLivro, String> colDevolvido;

    @FXML
    private TableColumn<ClienteLivro, String> colEmprestimo;

    @FXML
    private TableColumn<ClienteLivro, Integer> colId;

    @FXML
    private TableColumn<ClienteLivro, String> colTitulo;

    @FXML
    private TableColumn<ClienteLivro, String> colTurma;

    @FXML
    private TextField searchField;

    @FXML
    private VBox sidebar;

    @FXML
    private TableView<ClienteLivro> tabelaEmprestimos;

    @FXML
    private Region topSpacer;

    @FXML
    void ActionAdd(ActionEvent event) throws IOException {
    	Main.TelaCadEmprestimos();
    	carregarTableEmprestimos();
    }

    @FXML
    void ActionEdit(ActionEvent event) throws IOException {
    	int linha = tabelaEmprestimos.getSelectionModel().getSelectedIndex();
    	if(linha == -1) {
    		Alerts.alerterro("ERRO", "SELEÇÃO NULA.", "SELECIONE UMA COLUNA PARA EDITAR");
    	} else {
    	emprestimoEditar = tabelaEmprestimos.getItems().get(linha);
    	Main.TelaEditEmprestimo();
    }
    	carregarTableEmprestimos();
    }

    @FXML
    void ActionExcluir(ActionEvent event) {
    	int linha = tabelaEmprestimos.getSelectionModel().getSelectedIndex();
    	if(linha == -1) {
    		Alerts.alerterro("ERRO", "SELEÇÃO NULA", "SELECIONE UMA COLUNA PARA EXCLUIR.");
    		
    	} else {
    		Alert msg = new Alert(AlertType.CONFIRMATION);
    		msg.setTitle("EXCLUIR");
    		msg.setContentText("VOCÊ REALMENTE DESEJA APAGAR O LIVRO?");
    		
    		Optional<ButtonType> confirmacao = msg.showAndWait();
    		if(confirmacao.isPresent() && confirmacao.get() == ButtonType.OK) {
    			Alerts.alertinfo("SUCESSO.", "OPERAÇÃO SUCEDIDA.", "O EMPRÉSTIMO FOI EXLUÍDO.");
    			ClienteLivro cl = new ClienteLivro();
    			ClienteLivroDAO clDAO = new ClienteLivroDAO();
    			cl = tabelaEmprestimos.getItems().get(linha);
    			clDAO.delete(cl.getIdClienteLivro());
    		
    			carregarTableEmprestimos();
    		}
    	}
    }

    @FXML
    void ActionSearch(MouseEvent event) {
    	  String pesquisa = searchField.getText();
          ClienteLivroDAO clDAO = new ClienteLivroDAO();
          ObservableList<ClienteLivro> lista = FXCollections.observableArrayList(clDAO.search(pesquisa));
          tabelaEmprestimos.setItems(lista);
    }

    @FXML
    void ActionTelaLivro(MouseEvent event) throws IOException {
    	Main.TelaLivro();
    }

    @FXML
    void ActionTelaUsuario(MouseEvent event) throws IOException {
    	Main.TelaCliente();
    }
    
    
    

ObservableList<ClienteLivro> listaEmprestimos;
	public void carregarTableEmprestimos() {
		ClienteLivroDAO clDAO = new ClienteLivroDAO();
		listaEmprestimos = FXCollections.observableArrayList(clDAO.read());
		
		colId.setCellValueFactory(new PropertyValueFactory<>("idClienteLivro"));
		colTitulo.setCellValueFactory(new PropertyValueFactory<>("tituloLivro"));
		colCliente.setCellValueFactory(new PropertyValueFactory<>("nomeCliente"));
		colEmprestimo.setCellValueFactory(new PropertyValueFactory<>("dataEmprestimo"));
		colDevolucao.setCellValueFactory(new PropertyValueFactory<>("dataDevolucao"));
		colDevolvido.setCellValueFactory(new PropertyValueFactory<>("devolvido"));
		colTurma.setCellValueFactory(new PropertyValueFactory<>("turmaAluno"));
		
		
		tabelaEmprestimos.setItems(listaEmprestimos);
		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		carregarTableEmprestimos();
		txtNome.setText(controllerLogin.adm.getNome());
		emprestimoEditar = null;
	}

}
