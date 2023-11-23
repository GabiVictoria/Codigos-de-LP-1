package br.graecus.neptunum;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloApplication extends Application {

    private static Stage stage;
    private static Scene criaContaScene;
    private static Scene loginScene;
    private static Scene homeScene;


    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login.fxml"));
        FXMLLoader fxmlLoadercc = new FXMLLoader(HelloApplication.class.getResource("criaConta.fxml"));
        FXMLLoader fxmlLoaderho = new FXMLLoader(HelloApplication.class.getResource("home.fxml"));


        criaContaScene = new Scene(fxmlLoadercc.load());
        loginScene = new Scene(fxmlLoader.load());
        homeScene = new Scene(fxmlLoaderho.load());


        stage.setTitle("Neptunum");
        stage.setScene(loginScene);
        stage.show();
    }
    public static void telas(String src) {
        switch(src) {
            case "login":
                stage.setScene(loginScene);
                break;
            case "criaConta":
                stage.setScene(criaContaScene);
                break;
            case "home":
                stage.setScene(homeScene);
        }
    }

    public static void main(String[] args) {
        launch();
    }
}