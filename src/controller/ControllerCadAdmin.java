package controller;

import alertas.Alerts;
import dao.AdministradorDAO;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Administrador;


public class ControllerCadAdmin {

    @FXML
    private Button btAdicionar;

    @FXML
    private Button btCancelar;

    @FXML
    private TextField txtCpf;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtSenha;

    @FXML
    private TextField txtTelefone;

    @FXML
    void ActionAdd(ActionEvent event) {

        if (txtNome.getText().isEmpty() || txtCpf.getText().isEmpty() 
            || txtSenha.getText().isEmpty() || txtTelefone.getText().isEmpty() )
            {
            
            Alerts.alerterro("ERRO", "INFORMAÇÕES INSUFICIENTES.", "PREENCHA TODOS OS CAMPOS.");
        
        } else {
         
                Administrador adm = new Administrador();
                AdministradorDAO admDAO = new AdministradorDAO();

                adm.setNome(txtNome.getText());
                adm.setCPF(txtCpf.getText());
                adm.setSenha(txtSenha.getText());
                adm.setTelefone(txtTelefone.getText());
            
                admDAO.create(adm);

                Alerts.alertinfo("SUCESSO", "ADMINISTRADOR CADASTRADO.", 
                        "VOCÊ CADASTROU O ADMINISTRADOR  " + txtNome.getText() + ".");

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
