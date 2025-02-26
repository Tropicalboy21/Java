package dao;

import model.Profesor;
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
        String sqlQuery =  "INSERT INTO `estudiantesLUA`( `nombre`, `apellidos`, `identificacion` , `email`, `fechanacimiento`, `carrera`,`estatus`) VALUES ( ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement setProperties = conn.prepareStatement(sqlQuery)){
            setProperties.setString(1, NewStudent.getName());
            setProperties.setString(2, NewStudent.getLastname());
            setProperties.setString(3, NewStudent.getIdentification());
            setProperties.setString(4, NewStudent.getEmail());
            setProperties.setString(5, NewStudent.getBirthdate());
            setProperties.setString(6, NewStudent.getCareer());
            setProperties.setBoolean(7, NewStudent.getStatus());
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

    public Student getStudentById(int id) throws SQLException {
        String sqlQuery = "SELECT * FROM `estudiantesLUA` WHERE `id` = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sqlQuery)) {
            stmt.setInt(1, id);
            try (ResultSet resultado = stmt.executeQuery()) {
                if (resultado.next()) {
                    return new Student(
                            resultado.getInt("id"),
                            resultado.getString("nombre"),
                            resultado.getString("apellidos"),
                            resultado.getString("identificacion"),
                            resultado.getString("email"),
                            resultado.getString("fechanacimiento"),
                            resultado.getString("carrera"),
                            resultado.getBoolean("estatus")
                    );
                }
            }
        }
        return null;
    }

    public void updateStudent(Student student) throws SQLException{
        String sqlQuery = "UPDATE `estudiantesLUA` SET `nombre` = ?, `apellidos` = ?, `identificacion` = ?, `email` = ?, `fechanacimiento` = ?, `carrera` = ?, `estatus` = ? WHERE `id` = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sqlQuery)) {
            stmt.setString(1, student.getName());
            stmt.setString(2, student.getLastname());
            stmt.setString(3, student.getIdentification());
            stmt.setString(4, student.getEmail());
            stmt.setString(5, student.getBirthdate());
            stmt.setString(6, student.getCareer());
            stmt.setBoolean(7, student.getStatus());
            stmt.setInt(8, student.getId()); // The ID is used to update the correct professor
            stmt.executeUpdate();
        }
    }

    public void deleteStudent(int id) throws SQLException {
        String sqlQuery = "DELETE FROM `estudiantesLUA` WHERE `id` = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sqlQuery)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

}
