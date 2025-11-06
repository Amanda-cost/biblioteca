package controller;

import java.net.URL;
import java.util.ResourceBundle;

import alertas.Alerts;
import dao.ClienteDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Cliente;

public class ControllerCadCliente implements Initializable {

    @FXML
    private Button btAdicionar;

    @FXML
    private Button btCancelar;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtCpf;

    @FXML
    private TextField txtIdade;

    @FXML
    private TextField txtTelefone;

    @FXML
    private TextField txtTurma;

    @FXML
    void ActionAdd(ActionEvent event) {

        if (txtNome.getText().isEmpty() || txtCpf.getText().isEmpty() 
            || txtIdade.getText().isEmpty() || txtTelefone.getText().isEmpty() 
            || txtTurma.getText().isEmpty()) {
            
            Alerts.alerterro("ERRO", "INFORMAÇÕES INSUFICIENTES.", "PREENCHA TODOS OS CAMPOS.");
        
        } else {
         
                Cliente cliente = new Cliente();
                ClienteDAO clienteDAO = new ClienteDAO();

                cliente.setNome(txtNome.getText());
                cliente.setCPF(txtCpf.getText());
                cliente.setIdade(txtIdade.getText());
                cliente.setTelefone(txtTelefone.getText());
                cliente.setTurma(txtTurma.getText());

                clienteDAO.create(cliente);

                Alerts.alertinfo("SUCESSO", "CLIENTE CADASTRADO.", 
                        "VOCÊ CADASTROU O CLIENTE " + txtNome.getText() + ".");

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
    public void initialize(URL location, ResourceBundle resources) {
      
    }
}
