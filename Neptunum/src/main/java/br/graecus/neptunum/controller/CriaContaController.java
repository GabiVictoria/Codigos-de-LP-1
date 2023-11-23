package br.graecus.neptunum.controller;

import br.graecus.neptunum.HelloApplication;
import br.graecus.neptunum.modelos.*;
import br.graecus.neptunum.Sessao.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class CriaContaController {
    @FXML
    private TextField txtnome;
    @FXML
    private TextField txtnomeUsuario;
    @FXML
    private PasswordField txtsenha;

    @FXML
    private Label aviso;
    UsuarioSessao usuarioSessao = new UsuarioSessao();


    public void mudaLogin(ActionEvent event) {

        String nome = txtnome.getText();
        String nomeUsuario = txtnomeUsuario.getText();
        String senha = txtsenha.getText();

        if(nome.isEmpty() && nomeUsuario.isEmpty() && senha.isEmpty())
            exibirErro(0);

        else  if(nome.isEmpty())
            exibirErro(1);

        else if(nomeUsuario.isEmpty())
            exibirErro(2);

        else if(senha.isEmpty())
            exibirErro(3);

        else {
            Usuario u = new Usuario(nome,nomeUsuario,senha);
            usuarioSessao.salvarUsuario(u);
            HelloApplication.telas("login");
        }
    }

    public void retornar(ActionEvent event) {

        HelloApplication.telas("login");
    }


    public void exibirErro(int i) {
        if(i==0)
            aviso.setText("Campos vazios ");

        else if(i==1)
            aviso.setText("Campo nome vazio ");

        else if(i==2)
            aviso.setText("Campo nome de usuário vazio ");

        else if(i==3)
            aviso.setText("Campo Senha vazio ");

    }


}
