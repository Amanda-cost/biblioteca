package controller;

import java.io.IOException;

import alertas.Alerts;
import application.Main;
import dao.AdministradorDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.Administrador;

public class controllerLogin {

    @FXML
    private Button btLogin;

    @FXML
    private PasswordField txtSenha;

    @FXML
    private TextField txtUsuario;

    static Administrador adm = new Administrador();
    AdministradorDAO admDAO = new AdministradorDAO();
    
    @FXML
    void ActionLogin(ActionEvent event) throws IOException {
        String user = txtUsuario.getText();
        String senha = txtSenha.getText();

        if (user.isEmpty() || senha.isEmpty()) {
           Alerts.alerterro("ERRO", "UM OU MAIS CAMPOS VAZIOS.", "POR FAVOR, PREENCHA TODOS OS CAMPOS.");
            return;
        }

        adm = admDAO.autenticarUser(user, senha);

        if (adm != null && adm.getCPF() != null && adm.getSenha() != null) {
            if (adm.getCPF().equals(user) && adm.getSenha().equals(senha)) {
              Alerts.alertinfo("BEM VINDO", "VOCÊ ENTROU", "SEJA BEM-VINDO(A), "+adm.getNome().toUpperCase());
                Main.TelaLivro();
            } else {
            	Alerts.alerterro("ERRO", "PARÂMETROS INVÁLIDOS.", "CORRIGA SEU USUÁRIO OU SENHA.");
            }
        } else {
           Alerts.alerterro("ERRO", "USUÁRIO NÃO ENCONTRADO.", "DIGITE SEU CPF E SENHA.");
        }
    }


}
