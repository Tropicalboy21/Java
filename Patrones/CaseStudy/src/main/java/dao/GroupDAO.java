package dao;

import model.Course;
import model.Group;
import model.Profesor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GroupDAO {

    private Connection conn;

    public GroupDAO(Connection conn){
        this.conn = conn;
    }

    public void addGroup(Group NewGroup) throws SQLException {
        String sqlQuery =  "INSERT INTO `gruposLUA`( `nombre`, `descripcion`,`estatus`) VALUES ( ?, ?, ?)";

        try (PreparedStatement setProperties = conn.prepareStatement(sqlQuery)){
            setProperties.setString(1, NewGroup.getName());
            setProperties.setString(2, NewGroup.getDescription());
            setProperties.setBoolean(3, NewGroup.getStatus());
            setProperties.executeUpdate();
        }
    }

    public List<Group> getGroup() throws SQLException{
        List<Group> listaGrupos = new ArrayList<>();

        String sqlQuery = "SELECT `id`, `nombre`, `descripcion`, `estatus` FROM `gruposLUA`";
        //Nos permite que creemos nuestros SP, desde la base de datos y los invoquemos.
        try (
                Statement stmt = conn.createStatement();
                ResultSet resultadoConsultado = stmt.executeQuery(sqlQuery);

        ){
            while (resultadoConsultado.next()){
                listaGrupos.add(
                        new Group(
                                resultadoConsultado.getInt("id"),
                                resultadoConsultado.getString("nombre"),
                                resultadoConsultado.getString("descripcion"),
                                resultadoConsultado.getBoolean("estatus")
                        )
                );
            }
        }

        return listaGrupos;
    }


    public Group getGroupId(int id) throws SQLException {
        String sqlQuery = "SELECT * FROM `gruposLUA` WHERE `id` = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sqlQuery)) {
            stmt.setInt(1, id);
            try (ResultSet resultado = stmt.executeQuery()) {
                if (resultado.next()) {
                    return new Group(
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

    public void updateGroup(Group group) throws SQLException{
        String sqlQuery = "UPDATE `gruposLUA` SET `nombre` = ?, `descripcion` = ?, `estatus` = ? WHERE `id` = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sqlQuery)) {
            stmt.setString(1, group.getName());
            stmt.setString(2, group.getDescription());
            stmt.setBoolean(3, group.getStatus());
            stmt.setInt(4, group.getId()); // The ID is used to update the correct professor
            stmt.executeUpdate();
        }
    }

    public void deleteGroup(int id) throws SQLException {
        String sqlQuery = "DELETE FROM `gruposLUA` WHERE `id` = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sqlQuery)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
