package controller;

import java.net.URL;
import java.util.ResourceBundle;

import alertas.Alerts;
import dao.LivroDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import model.Livro;

public class ControllerEditLivro implements Initializable {

    @FXML
    private Button btAdd;

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
    private TextField txtId;

    @FXML
    private TextField txtQuantidade;

    @FXML
    private TextField txtTitulo;

    @FXML
    void actionAdd(ActionEvent event) {
    	Livro livro = new Livro();
		LivroDAO livroDAO = new LivroDAO();
    	if(ControllerLivros.livroEditar == null) {
    		
    		Alerts.alertinfo("ERRO", "ERRO EM EDITAR.", "VOCÊ NÃO SELECIONOU UMA COLUNA NA TABELA.");
    		
    		Stage stage = (Stage) btAdd.getScene().getWindow();
    		stage.close();
    		}else {
    			
    			
    			livro.setIdLivro(txtId.getText());
    			livro.setTitulo(txtTitulo.getText());
    			livro.setAutor(txtAutor.getText());
    			livro.setGenero(txtGenero.getText());
    			livro.setAno(txtAno.getText());
    			livro.setEditora(txtEditora.getText());
    			livro.setQuantDisponivel(Integer.parseInt(txtQuantidade.getText()));
    			
    			livroDAO.update(livro);
    			
    			Alerts.alertinfo("SUCESSO.", "EDITADO.", "LIVRO EDITADO.");
        		ControllerLivros.livroEditar = null;
        		Stage stage = (Stage) btAdd.getScene().getWindow();
        		stage.close();
    		}
    }

    @FXML
    void actionCancel(ActionEvent event) {
    	Stage stage = (Stage) btCancelar.getScene().getWindow();
		stage.close();
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		Livro lv = new Livro();
		
		lv = ControllerLivros.livroEditar;
		
		txtId.setText(lv.getIdLivro());
		txtTitulo.setText(lv.getTitulo());
		txtAutor.setText(lv.getAutor());
		txtAno.setText(lv.getAno());
		txtGenero.setText(lv.getGenero());
		txtEditora.setText(lv.getEditora());
		txtQuantidade.setText(""+lv.getQuantDisponivel());
	}

}
