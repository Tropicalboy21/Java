package cr.ac.ucenfotec.dl;

import java.sql.*;

/**
 * Clase que se encarga de realizar las operaciones con la base de datos y
 * establecer la conexión con el servidor.
 * @author Universidad Cenfotec
 * @since 2024
 */
public class AccesoBD {

    private Connection conn = null;
    private Statement stmt = null;

    /**
     * Constructor que inicializa la conexión.
     * Recibe el string de conexión en la forma de tres variables por separado.
     * @param URL nombre del servidor y base de datos.
     * @param user usuario para conextarse al servidor y base de datos.
     * @param password clave del usuario que se usa para conectar al servidor
     */
    public AccesoBD(String URL, String user, String password) {
        try {
            conn = DriverManager.getConnection(URL,user,password);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Método que ejecuta las consultas al servidor de base de datos.
     * Debe invocarse si se ejecutan las operaciones de:INSERT,UPDATE,DELETE
     * @param query String con la consulta sql que se debe ejecutar en el servidor.
     * @throws SQLException Expceción SQL que indica los errores de base de datos.
     */
    public void ejecutarSQL(String query){
        try {
            stmt = conn.createStatement();
            stmt.executeUpdate(query);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * @param query String con la consulta sql que se debe ejecutar en el servidor
     * @return ResultSet con la información que se obtiene a partir de una consulta
     * de tipo SELECT
     * @throws SQLException
     */
    public ResultSet ejecutarQuery(String query){
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
