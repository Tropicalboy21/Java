package controller;

import dao.CourseDAO;
import dao.GroupDAO;
import model.ConnectionManager;
import model.Course;
import model.Group;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CourseController {

    public CourseDAO courseDAO;

    public CourseController() {

        Connection conn = ConnectionManager.connect();

        if(conn != null){
            courseDAO = new CourseDAO(conn);
        } else {
            System.err.println("No se conecto");
        }

    }

    public void addCourse( String nombre, String descripcion, boolean estatus) {
        if(courseDAO == null){
            System.err.println("Conexion no disponible");
            return;
        }
        try {
            Course courseParameters = new Course(0, nombre, descripcion, estatus);
            courseDAO.addCourse(courseParameters);
            System.out.println("Insercion exitosa");

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void  getCourse() {
        if(courseDAO == null){
            System.err.println("Conexion no disponible");
            return;
        }
        try {
            List<Course> courseList = courseDAO.getCourse();

            for (Course courses : courseList){
                System.out.println( "Id: " + courses.getId() + " ,Nombre: " + courses.getName() + " ,Descripción: " + courses.getDescription() + " , Estatus" + courses.getStatus());
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
