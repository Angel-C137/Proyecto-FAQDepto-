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

    public void inicio(ActionEvent actionEvent) {
    }

    public void unirse(ActionEvent actionEvent) {
        CrearCuenta cuenta = new CrearCuenta();
        cuenta.setNombreCompleto(nombreCompleto.getText());
        cuenta.setPassword(password.getText());
        cuenta.setMatricula(matricula.getText());
        cuenta.setId(idTipo);
        crearCuentaDAO.guardarActualizar(cuenta);

        nombreCompleto.clear();
        password.clear();
        matricula.clear();

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try (Connection conexionDB = DriverManager.getConnection("jdbc:h2:./target/FAQDepto")){
            Statement setencia = conexionDB.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS credenciales" + "(id INTEGER auto_increment, " + "nombreCompleto VARCHAR(30), " +
                    "password VARCHAR(20), " + "matricula VARCHAR(10))";
            setencia.executeUpdate(sql);
            System.out.println("Se registro un nuevo alumno");
        } catch (Exception e){
            throw new RuntimeException("No se pudo registrar el alumno." + e.getMessage());
        }

    }


}
