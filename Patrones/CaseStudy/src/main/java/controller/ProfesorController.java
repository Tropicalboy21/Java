package controller;

import dao.ProfesorDAO;
import model.ConnectionManager;
import model.Profesor;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ProfesorController {

    public static ProfesorDAO profesorDAO;

    public ProfesorController() {

        Connection conn = ConnectionManager.connect();

        if(conn != null){
            profesorDAO = new ProfesorDAO(conn);
        } else {
            System.err.println("No se conecto");
        }

    }

    public void addProfesor(String nombre, String apellidos, String identificacion, String email, String fechanacimiento, String departamento, boolean estatus) {
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

    public static void  getProfesor() {
        if(profesorDAO == null){
            System.err.println("Conexion no disponible");
            return;
        }
        try {
            List<Profesor> profesorList = profesorDAO.getProfesor();

            for (Profesor profesors : profesorList){
                System.out.println( "Id: " + profesors.getId() + " ,Nombre: " + profesors.getName() + " ,Apellidos: " + profesors.getLastname() + " ,Identificación: " + profesors.getIdentification() + " ,Email: " + profesors.getEmail() + " ,Fecha: " + profesors.getBirthdate() + " ,Departamento: " + profesors.getDepartment() + " ,Status: " + profesors.getStatus());
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public Profesor getProfesorById(int id) {
        if(profesorDAO == null){
            System.err.println("Conexion no disponible");
            return null;
        }
        try {
            Profesor profesor = profesorDAO.getProfesorById(id);
            if(profesor != null){
                return profesor;
            } else {
                System.err.println("Profesor no encontrado.");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateProfesor(Profesor profesor){
        if(profesorDAO == null){
            System.err.println("Conexion no disponible");
            return;
        }
        try {
            profesorDAO.updateProfesor(profesor);
            System.out.println("Profesor Actualizado con éxito");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteProfesor(int id){
        if(profesorDAO == null){
            System.err.println("Conexion no disponible");
            return;
        }
        try {
            profesorDAO.deleteProfesor(id);
            System.out.println("Profesor eliminado con éxito");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
