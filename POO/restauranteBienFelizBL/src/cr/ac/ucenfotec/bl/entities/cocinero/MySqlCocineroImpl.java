package cr.ac.ucenfotec.bl.entities.cocinero;

import cr.ac.ucenfotec.bl.entities.empleado.Empleado;
import cr.ac.ucenfotec.dl.Conector;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MySqlCocineroImpl implements ICocineroDAO{

    private String sql;

    public String registrarCocinero(Cocinero cocinero){
        sql="INSERT INTO COCINERO (NOMBRE, APELLIDO, CORREO, CONTRASENNA, ID, NUMEROSOCIAL,FECHANACIMIENTO, ROL, NUMEROFIJO, NUMEROMOVIL, FECHAINGRESO) VALUES ('"+cocinero.getNombre()+"','"+cocinero.getApellidos()+"','"+cocinero.getCorreo()+"','"+cocinero.getContrasenna()+"','"+cocinero.getId()+"','"+cocinero.getNumeroSocial()+"','"+cocinero.getFechaNacimiento()+"','"+cocinero.getRol()+"','"+cocinero.getNumeroFijo()+"','"+cocinero.getNumeroMovil()+"','"+cocinero.getFechaIngreso()+"')";
        Conector.getConnector().ejecutarSQL(sql);
        return "El cocinero " +cocinero.getNombre()+", fue agregado con exito!";
    }

    public ArrayList<Cocinero> listarCocineros() {
        ArrayList<Cocinero> listaCocineros = new ArrayList<>();

        sql ="SELECT NOMBRE, APELLIDO, CORREO, CONTRASENNA, ID, NUMEROSOCIAL,FECHANACIMIENTO, ROL, NUMEROFIJO, NUMEROMOVIL, FECHAINGRESO FROM COCINERO";

        try {
            ResultSet rsCocinero = Conector.getConnector().ejecutarQuery(sql);
            while (rsCocinero.next()) {
                String nombre = rsCocinero.getString("NOMBRE");
                String apellidos = rsCocinero.getString("APELLIDO");
                String correo = rsCocinero.getString("CORREO");
                String contrasenna = rsCocinero.getString("CONTRASENNA");
                String id = rsCocinero.getString("ID");
                String numeroSocial = rsCocinero.getString("NUMEROSOCIAL");
                String fechaNacimiento = rsCocinero.getString("FECHANACIMIENTO");
                String rol = rsCocinero.getString("ROL");
                String numeroFijo = rsCocinero.getString("NUMEROFIJO");
                String numeroMovil = rsCocinero.getString("NUMEROMOVIL");
                String fechaIngreso = rsCocinero.getString("FECHAINGRESO");
                Cocinero cocineroEncontrado = new Cocinero(nombre,apellidos,correo,contrasenna,id,numeroSocial,fechaNacimiento,rol,numeroFijo,numeroMovil,fechaIngreso);

                listaCocineros.add(cocineroEncontrado);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaCocineros;
    }
}
