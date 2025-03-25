package dao;

import model.Profesor;
import java.sql.*;
import java.util.List;

public class ProfesorDAO extends BaseDAO<Profesor> {
    public ProfesorDAO(Connection conn){
        super(conn);
    }
    @Override
    protected String getTableName(){
        return "profesoresLUA";
    }
    @Override
    protected Profesor mapResultSetToEntity(ResultSet rs) throws SQLException {
        return new Profesor(
                rs.getInt("id"),
                rs.getString("nombre"),
                rs.getString("apellidos"),
                rs.getString("identificacion"),
                rs.getString("email"),
                rs.getString("fechanacimiento"),
                rs.getString("departamento"),
                rs.getBoolean("estatus")
        );
    }
    @Override
    protected void setEntityProperties(PreparedStatement stmt, Profesor profesor) throws SQLException {
        stmt.setString(1, profesor.getName());
        stmt.setString(2, profesor.getLastname());
        stmt.setString(3, profesor.getIdentification());
        stmt.setString(4, profesor.getEmail());
        stmt.setString(5, profesor.getBirthdate());
        stmt.setString(6, profesor.getDepartment());
        stmt.setBoolean(7, profesor.getStatus());

        ParameterMetaData metaData = stmt.getParameterMetaData();
        if (metaData.getParameterCount() == 8) {
            stmt.setInt(8, profesor.getId());
        }
    }
    public void addProfesor(Profesor profesor) throws SQLException {
        String query = "INSERT INTO `profesoresLUA`( `nombre`, `apellidos`, `identificacion` , `email`, `fechanacimiento`, `departamento`, `estatus`) VALUES (?, ?, ?, ?, ?, ?, ?)";
        addEntity(profesor, query);
    }
    public List<Profesor> getProfesor() throws SQLException {
        String query = "SELECT `id`, `nombre`, `apellidos`, `identificacion`, `email`, `fechanacimiento`, `departamento`, `estatus` FROM `profesoresLUA`";
        return getEntities(query);
    }
    public Profesor getProfesorById(int id) throws SQLException {
        String query = "SELECT * FROM `profesoresLUA` WHERE `id` = ?";
        return getEntityById(id, query);
    }
    public void updateProfesor(Profesor profesor) throws SQLException {
        String query = "UPDATE `profesoresLUA` SET `nombre` = ?, `apellidos` = ?, `identificacion` = ?, `email` = ?, `fechanacimiento` = ?, `departamento` = ?, `estatus` = ? WHERE `id` = ?";
        updateEntity(profesor, query);
    }
    public void deleteProfesor(int id) throws SQLException {
        String query = "DELETE FROM `profesoresLUA` WHERE `id` = ?";
        deleteEntity(id, query);
    }
}
