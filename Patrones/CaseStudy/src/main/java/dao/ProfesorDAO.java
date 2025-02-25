package dao;

import model.Profesor;
import model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProfesorDAO {

    private Connection conn;

    public ProfesorDAO(Connection conn){
        this.conn = conn;
    }

    public void addProfesor(Profesor NewProfesor) throws SQLException {
        String sqlQuery =  "INSERT INTO `profesoresLUA`( `nombre`, `apellidos`, `identificacion`, `email`, `fechanacimiento`, `departamento`,`estatus`) VALUES ( ?, ?, ?, ?, ?,?,?)";

        try (PreparedStatement setProperties = conn.prepareStatement(sqlQuery)){
            setProperties.setString(1, NewProfesor.getName());
            setProperties.setString(2, NewProfesor.getLastname());
            setProperties.setString(3, NewProfesor.getIdentification());
            setProperties.setString(4, NewProfesor.getEmail());
            setProperties.setString(5, NewProfesor.getBirthdate());
            setProperties.setString(6, NewProfesor.getDepartment());
            setProperties.setBoolean(7, NewProfesor.getStatus());
            setProperties.executeUpdate();
        }
    }

    public List<Profesor> getProfesor() throws SQLException{
        List<Profesor> listaProfesores = new ArrayList<>();

        String sqlQuery = "SELECT `id`, `nombre`, `apellidos`, `identificacion`, `email`, `fechanacimiento`, `departamento`,`estatus` FROM `profesoresLUA`";
        //Nos permite que creemos nuestros SP, desde la base de datos y los invoquemos.
        try (
                Statement stmt = conn.createStatement();
                ResultSet resultadoConsultado = stmt.executeQuery(sqlQuery);

        ){
            while (resultadoConsultado.next()){
                listaProfesores.add(
                        new Profesor(
                                resultadoConsultado.getInt("id"),
                                resultadoConsultado.getString("nombre"),
                                resultadoConsultado.getString("apellidos"),
                                resultadoConsultado.getString("identificacion"),
                                resultadoConsultado.getString("email"),
                                resultadoConsultado.getString("fechanacimiento"),
                                resultadoConsultado.getString("departamento"),
                                resultadoConsultado.getBoolean("estatus")
                        )
                );
            }
        }

        return listaProfesores;
    }

}
