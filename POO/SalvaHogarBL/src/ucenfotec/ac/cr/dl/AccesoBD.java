package ucenfotec.ac.cr.dl;

import java.sql.*;

public class AccesoBD {

    private Connection conn = null;
    private Statement stmt = null;

    public AccesoBD(String URL, String user, String password){
        try {
            conn = DriverManager.getConnection(URL,user,password);
        } catch(Exception e){
            e.printStackTrace();
        }
    }


    public void ejecutarSQL(String query){
        try{
            stmt = conn.createStatement();
            stmt.executeQuery(query);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public ResultSet ejecutarQuery (String query){
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
        }catch(Exception e){
            e.printStackTrace();
        }
        return rs;
    }
}
