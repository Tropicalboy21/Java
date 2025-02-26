package dao;

import model.Course;
import model.Group;
import model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseDAO {

    private Connection conn;

    public CourseDAO(Connection conn){
        this.conn = conn;
    }

    public void addCourse(Course NewCourse) throws SQLException {
        String sqlQuery =  "INSERT INTO `cursosLUA`( `nombre`, `descripcion`,`estatus`) VALUES ( ?, ?, ?)";

        try (PreparedStatement setProperties = conn.prepareStatement(sqlQuery)){
            setProperties.setString(1, NewCourse.getName());
            setProperties.setString(2, NewCourse.getDescription());
            setProperties.setBoolean(3, NewCourse.getStatus());
            setProperties.executeUpdate();
        }
    }

    public List<Course> getCourse() throws SQLException{
        List<Course> listaCourse = new ArrayList<>();

        String sqlQuery = "SELECT `id`, `nombre`, `descripcion`, `estatus` FROM `cursosLUA`";
        //Nos permite que creemos nuestros SP, desde la base de datos y los invoquemos.
        try (
                Statement stmt = conn.createStatement();
                ResultSet resultadoConsultado = stmt.executeQuery(sqlQuery);

        ){
            while (resultadoConsultado.next()){
                listaCourse.add(
                        new Course(
                                resultadoConsultado.getInt("id"),
                                resultadoConsultado.getString("nombre"),
                                resultadoConsultado.getString("descripcion"),
                                resultadoConsultado.getBoolean("estatus")
                        )
                );
            }
        }

        return listaCourse;
    }

    public Course getCourseId(int id) throws SQLException {
        String sqlQuery = "SELECT * FROM `cursosLUA` WHERE `id` = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sqlQuery)) {
            stmt.setInt(1, id);
            try (ResultSet resultado = stmt.executeQuery()) {
                if (resultado.next()) {
                    return new Course(
                            resultado.getInt("id"),
                            resultado.getString("nombre"),
                            resultado.getString("descripcion"),
                            resultado.getBoolean("estatus")
                    );
                }
            }
        }
        return null;
    }

    public void updateCourse(Course course) throws SQLException{
        String sqlQuery = "UPDATE `cursosLUA` SET `nombre` = ?, `descripcion` = ?, `estatus` = ? WHERE `id` = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sqlQuery)) {
            stmt.setString(1, course.getName());
            stmt.setString(2, course.getDescription());
            stmt.setBoolean(3, course.getStatus());
            stmt.setInt(4, course.getId()); // The ID is used to update the correct professor
            stmt.executeUpdate();
        }
    }

    public void deleteCourse(int id) throws SQLException {
        String sqlQuery = "DELETE FROM `cursosLUA` WHERE `id` = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sqlQuery)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }


}
