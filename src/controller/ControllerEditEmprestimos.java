package controller;

import java.net.URL;
import java.util.ResourceBundle;

import alertas.Alerts;
import dao.ClienteLivroDAO;
import dao.LivroDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.ClienteLivro;
import model.Livro;

public class ControllerEditEmprestimos implements Initializable {

    @FXML
    private Button btAdicionar;

    @FXML
    private Button btCancelar;
    
    @FXML
    private TextField txtdCliente;

    @FXML
    private ComboBox<Boolean> cbDevolvido;

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
    	ClienteLivro cl = new ClienteLivro();
		ClienteLivroDAO clDAO = new ClienteLivroDAO();
    	if(ControllerEmprestimos.emprestimoEditar == null) {
    		
    		Alerts.alertinfo("ERRO", "ERRO EM EDITAR.", "VOCÊ NÃO SELECIONOU UMA COLUNA NA TABELA.");
    		
    		Stage stage = (Stage) btAdicionar.getScene().getWindow();
    		stage.close();
    		}else {
    			
    			
    			cl.setNomeCliente(txtNomeCliente.getText());
    			cl.setTurmaAluno(txtTurma.getText());
    			cl.setTituloLivro(txtTituloLivro.getText());
    			cl.setDevolvido(Boolean.parseBoolean(cbDevolvido.getValue().toString()));
    			cl.setDataEmprestimo(txtDataEmprestimo.getText());
    			cl.setDataDevolucao(txtDataDevolucao.getText());
    			cl.setIdClienteLivro(txtdCliente.getText());
    			
    			clDAO.update(cl);
    			
    			Alerts.alertinfo("SUCESSO.", "EDITADO.", "LIVRO EDITADO.");
        		ControllerEmprestimos.emprestimoEditar = null;
        		Stage stage = (Stage) btAdicionar.getScene().getWindow();
        		stage.close();
    		}
    }

    @FXML
    void ActionCancel(ActionEvent event) {
		Stage stage = (Stage) btCancelar.getScene().getWindow();
		stage.close();
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
			ClienteLivro cl = new ClienteLivro();
			
			cl = ControllerEmprestimos.emprestimoEditar;
		cbDevolvido.getItems().addAll(true, false);
		
		cbDevolvido.setValue(cl.isDevolvido());
		txtNomeCliente.setText(cl.getNomeCliente());
		txtTurma.setText(cl.getTurmaAluno());
		txtTituloLivro.setText(cl.getTituloLivro());
		txtDataDevolucao.setText(cl.getDataDevolucao());
		txtDataEmprestimo.setText(cl.getDataEmprestimo());
		txtdCliente.setText(cl.getIdClienteLivro());
	}

}
