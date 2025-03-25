package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseDAO<T> {

    protected Connection conn;

    public BaseDAO(Connection conn) {
        this.conn = conn;
    }

    protected abstract String getTableName();
    protected abstract T mapResultSetToEntity(ResultSet rs) throws SQLException;

    public void addEntity(T entity, String insertQuery) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(insertQuery)) {
            setEntityProperties(stmt, entity);
            stmt.executeUpdate();
        }
    }

    public List<T> getEntities(String selectQuery) throws SQLException {
        List<T> entities = new ArrayList<>();
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(selectQuery)) {
            while (rs.next()) {
                entities.add(mapResultSetToEntity(rs));
            }
        }
        return entities;
    }

    public T getEntityById(int id, String selectQuery) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(selectQuery)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToEntity(rs);
                }
            }
        }
        return null;
    }

    public void updateEntity(T entity, String updateQuery) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(updateQuery)) {
            setEntityProperties(stmt, entity);
            stmt.executeUpdate();
        }
    }

    public void deleteEntity(int id, String deleteQuery) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(deleteQuery)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
    protected abstract void setEntityProperties(PreparedStatement stmt, T entity) throws SQLException;
}