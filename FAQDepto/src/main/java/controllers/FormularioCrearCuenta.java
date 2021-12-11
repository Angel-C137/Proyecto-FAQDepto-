package controllers;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FormularioCrearCuenta extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent contenedor = new FXMLLoader().load((getClass().getResource("/view/CrearCuenta.fxml")));

        Scene sceneCrearCuenta = new Scene(contenedor,600, 400);
        primaryStage.setScene(sceneCrearCuenta);
        primaryStage.show();
    }

    public static void main(String[] args){
        launch(args);
    }
}
