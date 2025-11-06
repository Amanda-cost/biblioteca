package controller;

import java.net.URL;
import java.util.ResourceBundle;

import alertas.Alerts;
import dao.LivroDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Livro;

public class ControllerCadLivro implements Initializable {

    @FXML
    private Button btAdicionar;

    @FXML
    private Button btCancelar;

    @FXML
    private TextField txtAno;

    @FXML
    private TextField txtAutor;

    @FXML
    private TextField txtEditora;

    @FXML
    private TextField txtGenero;

    @FXML
    private TextField txtQuantidadeDisponivel;

    @FXML
    private TextField txtTitulo;

    @FXML
    void ActionAdd(ActionEvent event) {
    	
    	if(txtAutor.getText().isEmpty() || txtTitulo.getText().isEmpty() || txtAno.getText().isEmpty() || txtGenero.getText().isEmpty() || txtEditora.getText().isEmpty() || txtQuantidadeDisponivel.getText().isEmpty()) {
    		Alerts.alerterro("ERRO", "INFORMAÇÕES INSUFICIENTES.", "PREENCHA TODOS OS CAMPOS.");
    	}else {
    		Livro livro = new Livro();
    		LivroDAO livroDAO = new LivroDAO();
    		
    		livro.setTitulo(txtTitulo.getText());
    		livro.setAutor(txtAutor.getText());
    		livro.setAno(txtAno.getText());
    		livro.setGenero(txtGenero.getText());
    		livro.setEditora(txtEditora.getText());
    		livro.setQuantDisponivel(Integer.parseInt(txtQuantidadeDisponivel.getText()));
    		
    		livroDAO.create(livro);
    		
    		Alerts.alertinfo("SUCESSO", "LIVRO CADASTRADO.", "VOCÊ CADASTROU O LIVRO "+ txtTitulo.getText() + ".");
    		
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
	
	}

}
