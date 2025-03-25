package dao;
import model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO extends BaseDAO<Student> {

    public StudentDAO(Connection conn){
        super(conn);
    }

    @Override
    protected String getTableName(){
        return "estudantesLUA";
    }

    @Override
    protected Student mapResultSetToEntity(ResultSet rs) throws SQLException {
        return new Student(
                rs.getInt("id"),
                rs.getString("nombre"),
                rs.getString("apellidos"),
                rs.getString("identificacion"),
                rs.getString("email"),
                rs.getString("fechanacimiento"),
                rs.getString("carrera"),
                rs.getBoolean("estatus")
        );
    }

    @Override
    protected void setEntityProperties(PreparedStatement stmt, Student student) throws SQLException {
        stmt.setString(1, student.getName());
        stmt.setString(2, student.getLastname());
        stmt.setString(3, student.getIdentification());
        stmt.setString(4, student.getEmail());
        stmt.setString(5, student.getBirthdate());
        stmt.setString(6, student.getCareer());
        stmt.setBoolean(7, student.getStatus());
        stmt.setInt(8, student.getId());
    }

    public void addStudent(Student student) throws SQLException {
        String query = "INSERT INTO `estudiantesLUA`( `nombre`, `apellidos`, `identificacion` , `email`, `fechanacimiento`, `carrera`, `estatus`) VALUES (?, ?, ?, ?, ?, ?, ?)";
        addEntity(student, query);
    }

    public List<Student> getStudent() throws SQLException {
        String query = "SELECT `id`, `nombre`, `apellidos`, `identificacion`, `email`, `fechanacimiento`, `carrera`, `estatus` FROM `estudiantesLUA`";
        return getEntities(query);
    }

    public Student getStudentById(int id) throws SQLException {
        String query = "SELECT * FROM `estudiantesLUA` WHERE `id` = ?";
        return getEntityById(id, query);
    }

    public void updateStudent(Student student) throws SQLException {
        String query = "UPDATE `estudiantesLUA` SET `nombre` = ?, `apellidos` = ?, `identificacion` = ?, `email` = ?, `fechanacimiento` = ?, `carrera` = ?, `estatus` = ? WHERE `id` = ?";
        updateEntity(student, query);
    }

    public void deleteStudent(int id) throws SQLException {
        String query = "DELETE FROM `estudiantesLUA` WHERE `id` = ?";
        deleteEntity(id, query);
    }

}
