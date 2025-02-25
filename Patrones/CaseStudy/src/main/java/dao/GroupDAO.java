package dao;

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
}
