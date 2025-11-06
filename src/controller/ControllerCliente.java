package controller;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import alertas.Alerts;
import application.Main;
import dao.ClienteDAO;
import dao.ClienteLivroDAO;
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

public class ControllerCliente implements Initializable {

    public static Cliente clienteEditar = new Cliente();

    @FXML
    private Label BtEmprestimos;

    @FXML
    private Label BtLivro;

    @FXML
    private Button btCadastrarAdm;
    
    @FXML
    private Button btAdicionar;

    @FXML
    private Button btEditar;

    @FXML
    private Button btExcluir;

    @FXML
    private Label btPesquisar;

    @FXML
    private Button btSair;

    @FXML
    private TableColumn<Cliente, String> columnCpf;

    @FXML
    private TableColumn<Cliente, String> columnIdCliente;

    @FXML
    private TableColumn<Cliente, String> columnIdade;

    @FXML
    private TableColumn<Cliente, String> columnNome;

    @FXML
    private TableColumn<Cliente, String> columnTelefone;

    @FXML
    private TableColumn<Cliente, String> columnTurma;

    @FXML
    private VBox sidebar;

    @FXML
    private TableView<Cliente> tabelaCliente;

    @FXML
    private Region topSpacer;

    @FXML
    private Label txtNome;

    @FXML
    private TextField txtPesquisar;

    // ========== Navegação ==========
    
    
    @FXML
    void ActionCadAdm(ActionEvent event) throws IOException {
    	Main.TelaCadAdm();
    }
    
    
    @FXML
    void ActionTelaEmprestimos(MouseEvent event) throws IOException {
        Main.TelaEmprestimo();
    }

    @FXML
    void ActionTelaLivro(MouseEvent event) throws IOException {
        Main.TelaLivro();
    }

    @FXML
    void actionSair(ActionEvent event) {
        System.exit(0);
    }

    // ========== CRUD ==========
    @FXML
    void ActionAdicionar(ActionEvent event) throws IOException {
        Main.TelaCadCliente();
        carregarTableClientes();
    }

    @FXML
    void ActionEditar(ActionEvent event) throws IOException {
        int linha = tabelaCliente.getSelectionModel().getSelectedIndex();
        if (linha == -1) {
            Alerts.alerterro("ERRO", "SELEÇÃO NULA", "SELECIONE UM CLIENTE PARA EDITAR.");
        } else {
            clienteEditar = tabelaCliente.getItems().get(linha);
            Main.TelaEditarCliente();
        }
        carregarTableClientes();
    }

    @FXML
    void ActionExcluir(ActionEvent event) {
        int linha = tabelaCliente.getSelectionModel().getSelectedIndex();
        if (linha == -1) {
            Alerts.alerterro("ERRO", "SELEÇÃO NULA", "SELECIONE UM CLIENTE PARA EXCLUIR.");
        } else {
        	Alert msg = new Alert(AlertType.CONFIRMATION);
    		msg.setTitle("EXCLUIR");
    		msg.setContentText("VOCÊ REALMENTE DESEJA APAGAR O LIVRO?");
    		
    		Optional<ButtonType> confirmacao = msg.showAndWait();
    		if(confirmacao.isPresent() && confirmacao.get() == ButtonType.OK) {
    			
    			Cliente cl = new Cliente();
    			ClienteDAO clDAO = new ClienteDAO();
    			cl = tabelaCliente.getItems().get(linha);
    			try {
    			clDAO.delete(cl.getCPF());
    			Alerts.alertinfo("SUCESSO.", "OPERAÇÃO SUCEDIDA.", "O CLIENTE FOI EXLUÍDO.");
    			}catch(RuntimeException e) {
    				
    			}
    			carregarTableClientes();
    		}
    	}
        }
    

    @FXML
    void ActionSearch(MouseEvent event) {
        String pesquisa = txtPesquisar.getText();
        ClienteDAO clienteDAO = new ClienteDAO();
        ObservableList<Cliente> lista = FXCollections.observableArrayList(clienteDAO.search(pesquisa));
        tabelaCliente.setItems(lista);
    }

    // ========== Inicialização ==========
    ObservableList<Cliente> listaClientes;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        txtNome.setText(controllerLogin.adm.getNome());
        carregarTableClientes();
    }

    public void carregarTableClientes() {
        ClienteDAO clienteDAO = new ClienteDAO();
        listaClientes = FXCollections.observableArrayList(clienteDAO.read());

        columnIdCliente.setCellValueFactory(new PropertyValueFactory<>("idCliente"));
        columnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        columnIdade.setCellValueFactory(new PropertyValueFactory<>("idade"));
        columnCpf.setCellValueFactory(new PropertyValueFactory<>("CPF"));
        columnTurma.setCellValueFactory(new PropertyValueFactory<>("turma"));
        columnTelefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));

        tabelaCliente.setItems(listaClientes);
    }
}
