package controller;

import dao.GroupDAO;
import model.ConnectionManager;
import model.Group;
import model.Profesor;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class GroupController {

    public GroupDAO groupDAO;

    public GroupController() {

        Connection conn = ConnectionManager.connect();

        if(conn != null){
            groupDAO = new GroupDAO(conn);
        } else {
            System.err.println("No se conecto");
        }

    }

    public void addGroup( String nombre, String descripcion, boolean estatus) {
        if(groupDAO == null){
            System.err.println("Conexion no disponible");
            return;
        }
        try {
            Group groupParameters = new Group(0, nombre, descripcion, estatus);
            groupDAO.addGroup(groupParameters);
            System.out.println("Insercion exitosa");

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void  getGroup() {
        if(groupDAO == null){
            System.err.println("Conexion no disponible");
            return;
        }
        try {
            List<Group> groupsList = groupDAO.getGroup();

            for (Group groups : groupsList){
                System.out.println( "Id: " + groups.getId() + " ,Nombre: " + groups.getName() + " ,Descripción: " + groups.getDescription() + " ,Estatus: " + groups.getStatus());
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }


    public Group getGroupById(int id) {
        if(groupDAO == null){
            System.err.println("Conexion no disponible");
            return null;
        }
        try {
            Group group = groupDAO.getGroupById(id);
            if(group != null){
                return group;
            } else {
                System.err.println("Grupo no encontrado.");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public void updateGroup(Group group){
        if(groupDAO == null){
            System.err.println("Conexion no disponible");
            return;
        }
        try {
            groupDAO.updateGroup(group);
            System.out.println("Grupo Actualizado con éxito");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteGroup(int id){
        if(groupDAO == null){
            System.err.println("Conexion no disponible");
            return;
        }
        try {
            groupDAO.deleteGroup(id);
            System.out.println("Grupo fue eliminado con éxito");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
