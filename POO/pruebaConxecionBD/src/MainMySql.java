import java.io.*;
import java.sql.*;


public class MainMySql {

    private static BufferedReader in = new BufferedReader(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String args[]){
        listarDatos();
        insertarDatos();
        listarDatos();
        eliminarDatos();
        listarDatos();
//        modificarDatos();
//        listarDatos();
    }

    public static void listarDatos() {
        System.out.println("**** Listado de datos ****");
        try {
            Connection conn = null;
            String query = "SELECT * FROM AUTO";
            Statement stmt  = null;
            ResultSet rs = null;
            String strConexion = "jdbc:mysql://localhost/ventaautos?user=root&password=Tropical21";
            conn = DriverManager.getConnection(strConexion);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);

            while (rs.next()){
                System.out.println("PLACA: " + rs.getInt("PLACA") + ", MARCA: " + rs.getString("MARCA"));
            }
            conn.close();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void insertarDatos() {
        System.out.println("**** registro de datos ******");
        try {
            System.out.print("Por favor digite el número de placa: ");
            int placa = Integer.parseInt(in.readLine());
            System.out.print("Por favor digite la marca del auto: ");
            String marca = in.readLine();

            Connection conn = null;
            String query = "INSERT INTO AUTO VALUES("+placa+",'"+marca+"')";
            Statement stmt = null;
            String strConexion = "jdbc:mysql://localhost/ventaautos?user=root&password=root";
            conn = DriverManager.getConnection(strConexion);
            stmt = conn.createStatement();
            stmt.executeUpdate(query); //Para cualquier insert, update o delete.
            conn.close();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void eliminarDatos() {
        System.out.println("**** eliminación de datos ******");
        try {
            System.out.print("Por favor digite el número de placa: ");
            int placa = Integer.parseInt(in.readLine());

            Connection conn = null;
            String query = "DELETE FROM AUTO WHERE PLACA="+placa;
            Statement stmt = null;
            String strConexion = "jdbc:mysql://localhost/ventaautos?user=root&password=qazwsx123";
            conn = DriverManager.getConnection(strConexion);
            stmt = conn.createStatement();
            stmt.executeUpdate(query); //Para cualquier insert, update o delete.
            conn.close();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
