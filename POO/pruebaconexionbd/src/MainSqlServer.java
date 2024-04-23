import java.io.*;
import java.sql.*;
//import cr.ac.ucenfotec.accesodatos.*;
import java.util.ArrayList;

public class MainSqlServer {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;

    public static void main(String args[]){
      insertarDatosPrpStmt();
      //  listarDatosPStmt();
      //  listarDatos();
      //  insertarDatos();
    }

    public static void listarDatosPStmt(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = null;
            String query = "SELECT * FROM PERSONA  ";
            PreparedStatement stmt = null;
            ResultSet rs = null;
            String strConexion = "jdbc:sqlserver://DESKTOP-A6HIJ7C\\CENFO;DatabaseName=test;user=sa;password=123456";
            conn = DriverManager.getConnection(strConexion);
            stmt = conn.prepareStatement(query);
            rs = stmt.executeQuery();// el rs almacena la información de la base de datos.
            // TENGO QUE RECORRERLA
            while (rs.next()) { //rs.next devuelve true si hay más líneas en el result set. por defecto, al iniciar el ciclo, el rs está en la línea 0.
                System.out.println(rs.getString("NOMBRE") + " " + rs.getString("IDENTIFICACION"));
            }
            conn.close();
        }
        catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }


    public static void listarDatos(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = null;
            String query = "SELECT * FROM PERSONA";
            Statement stmt = null;
            ResultSet rs = null;
            String strConexion = "jdbc:sqlserver://DESKTOP-A6HIJ7C\\CENFO;DatabaseName=test;user=sa;password=123456";
            conn = DriverManager.getConnection(strConexion);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);// el rs almacena la información de la base de datos.
            // TENGO QUE RECORRERLA
            while (rs.next()) { //rs.next devuelve true si hay más líneas en el result set. por defecto, al iniciar el ciclo, el rs está en la línea 0.
                System.out.println(rs.getString("NOMBRE") + " " + rs.getString("IDENTIFICACION"));
            }
            conn.close();
        }
        catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public static void actualizarDatos(){

    }

    public static void insertarDatosPrpStmt(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String nombre;
            int edad;
            String id;
            System.out.println("Digite el nombre");
            nombre = in.readLine();
            System.out.println("Digite la identificación");
            id = in.readLine();
            System.out.println("Digite la edad");
            edad = Integer.parseInt(in.readLine());

            String query = "INSERT INTO PERSONA(NOMBRE,IDENTIFICACION,EDAD) VALUES(?,?,?)";
            Connection conn = null;

            PreparedStatement stmt = null;
            String connectionUrl = "jdbc:sqlserver://DESKTOP-A6HIJ7C\\CENFO;DatabaseName=test;user=sa;password=123456";
            conn = DriverManager.getConnection(connectionUrl);
            stmt = conn.prepareStatement(query);

            stmt.setString(1,nombre);
            stmt.setString(2,id);
            stmt.setInt(3,edad);
            stmt.execute();
            System.out.println("Registro ingresado");
            listarDatosPStmt();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static void insertarDatos(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String nombre;
            int edad;
            String id;
            System.out.println("Digite el nombre");
            nombre = in.readLine();
            System.out.println("Digite la identificación");
            id = in.readLine();
            System.out.println("Digite la edad");
            edad = Integer.parseInt(in.readLine());

            String query = "INSERT INTO PERSONA(NOMBRE,CEDULA,EDAD) VALUES('" + nombre +"','" + id + "',"
                            + edad + ")";
            Connection conn = null;

            Statement stmt = null;
            String connectionUrl = "jdbc:sqlserver://DESKTOP-A6HIJ7C\\CENFO;DatabaseName=test;user=sa;password=123456";
            conn = DriverManager.getConnection(connectionUrl);
            stmt = conn.createStatement();
            stmt.execute(query);
            System.out.println("Registro ingresado");
            listarDatos();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


}
