package dao;

import model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    private Connection conn;

    public StudentDAO(Connection conn){
        this.conn = conn;
    }

    public void addStudent(Student NewStudent) throws SQLException {
        String sqlQuery =  "INSERT INTO `estudiantesLUA`( `nombre`, `apellidos`,, `identificacion`, `email`, `fechanacimiento`, `carrera`,`estatus`) VALUES ( ?, ?, ?, ?)";

        try (PreparedStatement setProperties = conn.prepareStatement(sqlQuery)){
            setProperties.setString(1, NewStudent.getName());
            setProperties.setString(2, NewStudent.getLastname());
            setProperties.setString(3, NewStudent.getBirthdate());
            setProperties.setString(4, NewStudent.getCareer());
            setProperties.executeUpdate();
        }
    }

    public List<Student> getStudent() throws SQLException{
        List<Student> listaEstudiante = new ArrayList<>();

        String sqlQuery = "SELECT `id`, `nombre`, `apellidos`, `identificacion`, `email`, `fechanacimiento`, `carrera`,`estatus` FROM `estudiantesLUA`";
        //Nos permite que creemos nuestros SP, desde la base de datos y los invoquemos.
        try (
                Statement stmt = conn.createStatement();
                ResultSet resultadoConsultado = stmt.executeQuery(sqlQuery);

        ){
            while (resultadoConsultado.next()){
                listaEstudiante.add(
                        new Student(
                                resultadoConsultado.getInt("id"),
                                resultadoConsultado.getString("nombre"),
                                resultadoConsultado.getString("apellidos"),
                                resultadoConsultado.getString("identificacion"),
                                resultadoConsultado.getString("email"),
                                resultadoConsultado.getString("fechanacimiento"),
                                resultadoConsultado.getString("carrera"),
                                resultadoConsultado.getBoolean("estatus")
                                )
                );
            }
        }

        return listaEstudiante;
    }


}
