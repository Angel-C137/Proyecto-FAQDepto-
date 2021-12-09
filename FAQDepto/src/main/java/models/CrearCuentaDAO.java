package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CrearCuentaDAO {
    public static final String URL_CONEXION = "jdbc:h2:./target/FAQDepto";
    public static final String USUARIO = "sa";
    public static final String PASSWORD = "C1sc0";

    public CrearCuentaDAO(){}

    public void guardarActualizar(CrearCuenta cuenta){
        if(cuenta.getId() == 0){
            guardar(cuenta);
        } else {
            actualizar(cuenta);
        }
    }

    public void guardar(CrearCuenta cuenta){
        try(Connection conexionDB = DriverManager.getConnection(URL_CONEXION,USUARIO,PASSWORD)){
            Statement statement = conexionDB.createStatement();
            String sql = "INSERT INTO crearCuenta(nombreCompleto, password, matricula) "+
                    "VALUES ('" + cuenta.getNombreCompleto() + "', '" + cuenta.getPassword() + "', '" + cuenta.getMatricula() + "')";
            statement.executeUpdate(sql);
        }catch (Exception e){
            throw new RuntimeException("Error al registrarse." + e.getMessage());
        }
    } //guardar

    public void actualizar(CrearCuenta cuenta){
        try (Connection conexionDB = DriverManager.getConnection(URL_CONEXION, USUARIO, PASSWORD)){
            Statement statement = conexionDB.createStatement();
            String sql = "UPDATE crearCuenta SET nombreCompleto='" + cuenta.getNombreCompleto() +
                    "', password= '" + cuenta.getPassword() + "', matricula = '" + cuenta.getMatricula() +
                    "' WHERE id=" + cuenta.getId();
            statement.executeUpdate(sql);
        } catch (Exception e){
            throw new RuntimeException("Error al actualizar." + e.getMessage());
        }
    } //actualizar

    public List<CrearCuenta> buscarTodo(){
        List<CrearCuenta> cuentas = new ArrayList<>();

        try (Connection conexionDB = DriverManager.getConnection(URL_CONEXION, USUARIO, PASSWORD)){
            Statement statement = conexionDB.createStatement();
            String sql = "SELECTO * FROM crearCuenta ORDER BY id";
            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()){
                CrearCuenta cuenta = new CrearCuenta();
                cuenta.setNombreCompleto(resultSet.getString("Nombre completo"));
                cuenta.setPassword(resultSet.getString("Password"));
                cuenta.setMatricula(resultSet.getString("Matricula"));
                cuenta.setId(resultSet.getInt("Id"));
                cuentas.add(cuenta);
            } //while
        } catch (Exception e){
            throw new RuntimeException("Error al consultar las cuentas." + e.getMessage());
        }
        return cuentas;
    } //buscarTodo

    public void eliminar(CrearCuenta cuenta){
        try (Connection conexionDB = DriverManager.getConnection(URL_CONEXION, USUARIO, PASSWORD)){
            Statement statement = conexionDB.createStatement();
            String sql = "DELETE FROM crearCuenta WHERE id =" + cuenta.getId();
            statement.executeUpdate(sql);
        }catch (Exception e){
            throw new RuntimeException("Error al eliminar." + e.getMessage());
        }
    } //eliminar

} //CrearCuenta
