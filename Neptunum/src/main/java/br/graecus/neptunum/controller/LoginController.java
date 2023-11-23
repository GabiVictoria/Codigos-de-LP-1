package br.graecus.neptunum.controller;
import br.graecus.neptunum.HelloApplication;
import br.graecus.neptunum.util.HibernateUtil;
import br.graecus.neptunum.modelos.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import org.hibernate.query.Query;

import java.util.List;

public class LoginController {

    @FXML
    private TextField user;
    @FXML
    private TextField senha;
    @FXML
    private Label iris;
    @FXML
    private Button idCadastreSe;

    public void initialize() {
        // Adiciona um efeito de sombra quando o mouse entra no botão
        idCadastreSe.setOnMouseEntered((MouseEvent e) -> {
            idCadastreSe.setEffect(new DropShadow());
        });

        // Remove o efeito de sombra quando o mouse sai do botão
        idCadastreSe.setOnMouseExited((MouseEvent e) -> {
            idCadastreSe.setEffect(null);
        });
    }


    public void entrar(ActionEvent actionEvent) {
        String nomeUsuario = user.getText();
        String senha1 = senha.getText();

        if(nomeUsuario.isEmpty() && senha1.isEmpty())
            exibirErro(0);

        else  if(nomeUsuario.isEmpty())
            exibirErro(1);

        else if(senha1.isEmpty())
            exibirErro(2);

        else{
            //consulta
            String uuu = "FROM Usuario u WHERE u.nomeUsuario = :nomeUsuario AND u.senha = :senha";//consulta se as info digitadas correspondem às info de algum usuario do banco
            Query<Usuario> query = HibernateUtil.getSessionFactory().openSession().createQuery(uuu, Usuario.class);
            query.setParameter("nomeUsuario", user.getText());
            query.setParameter("senha", senha.getText());

            List<Usuario> usuarios = query.getResultList();//adiciona o usuario encontrado (o usuário cujas info que correspondem às info digitadas) em uma lista

            if (!usuarios.isEmpty()) {//verifico se a lista não está vazia
                //como a lista não está vazia, então significa que o usuário foi encontrado no banco (ele já possuia cadastrado)
                HelloApplication.telas("home"); //pode prosseguir pra próx pg
            } else {//como a lista está vazia, então significa que ele não encontrou nenhuma correspondência no banco (ele não possui cadastro)
                System.out.println("usuário não está registrado no banco.");
                exibirErro(3); //chama o método que printa um erro
            }
        }
    }


    public void exibirErro(int i) {
        // vai jogar essa mensagem lá no label encoberto de acordo com o numero recebido
        if(i==0)
            iris.setText("Campos  vazios !!");

        else if(i==1)
            iris.setText("Campo nome vazio !!");

        else if(i==2)
            iris.setText("Campo Senha vazio !!");
        else
            iris.setText("inválido!!");


    }
    public void criando() {

        HelloApplication.telas("criaConta");
    }
}