package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    public static final String URL = "jdbc:mysql://srv863.hstgr.io/u484426513_pooc125";
    public static final String USER = "u484426513_pooc125";
    public static final String PASSWORD = "]Eq317KX6i*";

    public static Connection connect() {
        try {
            return DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

}
