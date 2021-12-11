package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import models.CrearCuenta;
import models.CrearCuentaDAO;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.List;
import java.util.ResourceBundle;

public class ControladorCrearCuenta implements Initializable{
    @FXML
    TextField nombreCompleto;

    @FXML
    TextField password;

    @FXML
    TextField matricula;

    CrearCuentaDAO crearCuentaDAO;

    private int idTipo = 0;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        crearCuentaDAO = new CrearCuentaDAO();
    }

    public void inicio(ActionEvent actionEvent) {
        System.out.println("Vuelve inicio");
    }

    public void unirse(ActionEvent actionEvent) {
        CrearCuenta cuenta = new CrearCuenta();
        cuenta.setNombreCompleto(nombreCompleto.getText());
        cuenta.setPassword(password.getText());
        cuenta.setMatricula(matricula.getText());
        cuenta.setId(idTipo);
        crearCuentaDAO.guardar(cuenta);

        nombreCompleto.clear();
        password.clear();
        matricula.clear();

    }


}
