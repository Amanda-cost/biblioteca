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

public class ControllerEditCliente implements Initializable {

    @FXML
    private Button btCancelar;

    @FXML
    private Button btEditar;

    @FXML
    private TextField txtCpf;

    @FXML
    private TextField txtTurma;

    @FXML
    private TextField txtIdade;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtTelefone;

    @FXML
    void actionCancel(ActionEvent event) {
        Stage stage = (Stage) btCancelar.getScene().getWindow();
        stage.close();
    }

    @FXML
    void actionEdit(ActionEvent event) {
        if (ControllerCliente.clienteEditar == null) {
            Alerts.alerterro("ERRO", "ERRO EM EDITAR.", "VOCÊ NÃO SELECIONOU UM CLIENTE NA TABELA.");
            Stage stage = (Stage) btEditar.getScene().getWindow();
            stage.close();
        } else {
            try {
                Cliente cliente = new Cliente();
                ClienteDAO clienteDAO = new ClienteDAO();

                cliente.setNome(txtNome.getText());
                cliente.setCPF(txtCpf.getText());
                cliente.setIdade(txtIdade.getText());
                cliente.setTelefone(txtTelefone.getText());
                cliente.setTurma(txtTurma.getText());

                clienteDAO.update(cliente);

                Alerts.alertinfo("SUCESSO.", "CLIENTE EDITADO.", 
                        "CLIENTE " + txtNome.getText() + " EDITADO COM SUCESSO.");
                ControllerCliente.clienteEditar = null;

                Stage stage = (Stage) btEditar.getScene().getWindow();
                stage.close();

            } catch (NumberFormatException e) {
                Alerts.alerterro("ERRO", "VALOR INVÁLIDO.", "O CAMPO ID PRECISA SER UM NÚMERO.");
            }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Cliente cliente = ControllerCliente.clienteEditar;
        if (cliente != null) {
            txtId.setText(String.valueOf(cliente.getIdCliente()));
            txtNome.setText(cliente.getNome());
            txtCpf.setText(cliente.getCPF());
            txtIdade.setText(cliente.getIdade());
            txtTelefone.setText(cliente.getTelefone());
            txtTurma.setText(cliente.getTurma());
        }
    }
}
