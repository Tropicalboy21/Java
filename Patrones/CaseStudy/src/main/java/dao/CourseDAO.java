package dao;

import model.Course;
import java.sql.*;
import java.util.List;

public class CourseDAO extends BaseDAO<Course>{
    public CourseDAO(Connection conn){
        super(conn);
    }
    @Override
    protected String getTableName(){
        return "cursosLUA";
    }
    @Override
    protected Course mapResultSetToEntity(ResultSet rs) throws SQLException {
        return new Course(
                rs.getInt("id"),
                rs.getString("nombre"),
                rs.getString("descripcion"),
                rs.getBoolean("estatus")
        );
    }
    @Override
    protected void setEntityProperties(PreparedStatement stmt, Course course) throws SQLException {
        stmt.setString(1, course.getName());
        stmt.setString(2, course.getDescription());
        stmt.setBoolean(3, course.getStatus());
    }
    public void addCourse(Course course) throws SQLException {
        String query = "INSERT INTO `cursosLUA`( `nombre`, `descripcion`, `estatus`) VALUES (?, ?, ?)";
        addEntity(course, query);
    }
    public List<Course> getCourse() throws SQLException {
        String query = "SELECT `id`, `nombre`, `descripcion`, `estatus` FROM `cursosLUA`";
        return getEntities(query);
    }
    public Course getCourseId(int id) throws SQLException {
        String query = "SELECT * FROM `cursosLUA` WHERE `id` = ?";
        return getEntityById(id, query);
    }
    public void updateCourse(Course course) throws SQLException {
        String query = "UPDATE `cursosLUA` SET `nombre` = ?, `descripcion` = ?, `estatus` = ? WHERE `id` = ?";
        updateEntity(course, query);
    }
    public void deleteCourse(int id) throws SQLException {
        String query = "DELETE FROM `cursosLUA` WHERE `id` = ?";
        deleteEntity(id, query);
    }
}
