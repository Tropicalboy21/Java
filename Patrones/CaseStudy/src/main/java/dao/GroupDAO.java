package dao;
import model.Group;
import java.sql.*;
import java.util.List;

public class GroupDAO extends BaseDAO<Group> {
    public GroupDAO(Connection conn){
        super(conn);
    }
    @Override
    protected String getTableName(){
        return "gruposLUA";
    }
    @Override
    protected Group mapResultSetToEntity(ResultSet rs) throws SQLException {
        return new Group(
                rs.getInt("id"),
                rs.getString("nombre"),
                rs.getString("descripcion"),
                rs.getBoolean("estatus")
        );
    }
    @Override
    protected void setEntityProperties(PreparedStatement stmt, Group group) throws SQLException {
        stmt.setString(1, group.getName());
        stmt.setString(2, group.getDescription());
        stmt.setBoolean(3, group.getStatus());

        ParameterMetaData metaData = stmt.getParameterMetaData();
        if (metaData.getParameterCount() == 4) {
            stmt.setInt(4, group.getId());
        }
    }
    public void addGroup(Group group) throws SQLException {
        String query = "INSERT INTO `gruposLUA`( `nombre`, `descripcion`, `estatus`) VALUES (?, ?, ?)";
        addEntity(group, query);
    }
    public List<Group> getGroup() throws SQLException {
        String query = "SELECT `id`, `nombre`, `descripcion`, `estatus` FROM `gruposLUA`";
        return getEntities(query);
    }
    public Group getGroupId(int id) throws SQLException {
        String query = "SELECT * FROM `gruposLUA` WHERE `id` = ?";
        return getEntityById(id, query);
    }
    public void updateGroup(Group group) throws SQLException {
        String query = "UPDATE `gruposLUA` SET `nombre` = ?, `descripcion` = ?, `estatus` = ? WHERE `id` = ?";
        updateEntity(group, query);
    }
    public void deleteGroup(int id) throws SQLException {
        String query = "DELETE FROM `gruposLUA` WHERE `id` = ?";
        deleteEntity(id, query);
    }
}
