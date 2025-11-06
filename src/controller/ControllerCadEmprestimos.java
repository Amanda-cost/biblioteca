package controller;

import alertas.Alerts;
import dao.ClienteDAO;
import dao.ClienteLivroDAO;
import dao.LivroDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Cliente;
import model.ClienteLivro;
import model.Livro;


public class ControllerCadEmprestimos {

    @FXML
    private Button btAdicionar;

    @FXML
    private Button btCancelar;

    @FXML
    private TextField txtDataDevolucao;

    @FXML
    private TextField txtDataEmprestimo;

    @FXML
    private TextField txtNomeCliente;

    @FXML
    private TextField txtTituloLivro;

    @FXML
    private TextField txtTurma;

    @FXML
    void ActionAdd(ActionEvent event) {
    	if(txtNomeCliente.getText().isEmpty() || txtTituloLivro.getText().isEmpty() || txtTurma.getText().isEmpty() || txtDataEmprestimo.getText().isEmpty()) {
    		Alerts.alerterro("ERRO", "INFORMAÇÕES INSUFICIENTES.", "PREENCHA TODOS OS CAMPOS.");
    	}else {
    		ClienteLivro cl = new ClienteLivro();
    		ClienteLivroDAO clDAO = new ClienteLivroDAO();
    		
    		cl.setNomeCliente(txtNomeCliente.getText());
    		cl.setTurmaAluno(txtTurma.getText());
    		cl.setTituloLivro(txtTituloLivro.getText());
    		cl.setDataEmprestimo(txtDataEmprestimo.getText());
    		cl.setDataDevolucao(txtDataDevolucao.getText());
    		Cliente cliente = new Cliente();
        	
        	ClienteDAO clienteDAO = new ClienteDAO();
        	
        	cliente.setNome(txtNomeCliente.getText());
        	cliente = clienteDAO.search(cliente.getNome()).get(0);
        	
        	cl.setFK_idCliente(cliente.getIdCliente());
        	
        	Livro lv = new Livro();
        	
        	LivroDAO lvDAO = new LivroDAO();
        	
        	lv.setTitulo(txtTituloLivro.getText());
        	lv = lvDAO.search(lv.getTitulo()).get(0);
        	
        	cl.setFK_idLivro(lv.getIdLivro());
        	
        
    		
    		clDAO.create(cl);
    		
    		Alerts.alertinfo("SUCESSO.", "EMPRÉSTIMO CADASTRADO.", "VOCÊ CADASTROU O EMPRÉSTIMO.");
    		
    		Stage stage = (Stage) btAdicionar.getScene().getWindow();
    		stage.close();
    		
    	}
    }

    @FXML
    void ActionCancel(ActionEvent event) {

		Stage stage = (Stage) btCancelar.getScene().getWindow();
		stage.close();
    }

}
