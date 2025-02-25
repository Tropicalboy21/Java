package controller;

import dao.ProfesorDAO;
import dao.StudentDAO;
import model.ConnectionManager;
import model.Profesor;
import model.Student;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ProfesorController {

    public ProfesorDAO profesorDAO;

    public ProfesorController() {

        Connection conn = ConnectionManager.connect();

        if(conn != null){
            profesorDAO = new ProfesorDAO(conn);
        } else {
            System.err.println("No se conecto");
        }

    }

    public void addProfesor( String nombre, String apellidos, String identificacion, String email, String fechanacimiento, String departamento, boolean estatus) {
        if(profesorDAO == null){
            System.err.println("Conexion no disponible");
            return;
        }
        try {
            Profesor profesorParameters = new Profesor(0, nombre, apellidos, identificacion, email, fechanacimiento, departamento, estatus);
            profesorDAO.addProfesor(profesorParameters);
            System.out.println("Insercion exitosa");

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void  getProfesor() {
        if(profesorDAO == null){
            System.err.println("Conexion no disponible");
            return;
        }
        try {
            List<Profesor> profesorList = profesorDAO.getProfesor();

            for (Profesor profesors : profesorList){
                System.out.println( "Id: " + profesors.getId() + " ,Nombre: " + profesors.getName() + " ,Apellidos: " + profesors.getLastname() + " ,Identificaión: " + profesors.getIdentification() + " ,Email: " + profesors.getEmail() + " ,Fecha: " + profesors.getBirthdate() + " ,Carerra: " + profesors.getDepartment() + " ,Status: " + profesors.getStatus());
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
