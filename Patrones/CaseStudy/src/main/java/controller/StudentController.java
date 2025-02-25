package controller;

import dao.StudentDAO;
import model.ConnectionManager;
import model.Student;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class StudentController {

    // DAO
    public StudentDAO studentDAO;

    public StudentController() {

        Connection conn = ConnectionManager.connect();

        if(conn != null){
            studentDAO = new StudentDAO(conn);
        } else {
            System.err.println("No se conecto");
        }

    }

    public void addStudent(String nombre, String apellidos, String identificacion, String email, String fechanacimiento, String carrera, boolean estatus) {
        if(studentDAO == null){
            System.err.println("Conexion no disponible");
            return;
        }
        try {
            Student studentParameters = new Student(0, nombre, apellidos, identificacion, email, fechanacimiento, carrera, estatus);
            studentDAO.addStudent(studentParameters);
            System.out.println("Insercion exitosa");

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void  getStudent() {
        if(studentDAO == null){
            System.err.println("Conexion no disponible");
            return;
        }
        try {
            List<Student> studentList = studentDAO.getStudent();

            for (Student students : studentList){
                System.out.println( "Id: " + students.getId() + " ,Nombre: " + students.getName() + " ,Apellidos: " + students.getLastname() + " ,Identificaión: " + students.getIdentification() + " ,Email: " + students.getEmail() + " ,Fecha: " + students.getBirthdate() + " ,Carerra: " + students.getCareer());

            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
