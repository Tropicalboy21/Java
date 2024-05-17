package cr.ac.ucenfotec.bl.entities.pinche;

import cr.ac.ucenfotec.bl.entities.cocinero.Cocinero;
import cr.ac.ucenfotec.bl.entities.empleado.Empleado;
import cr.ac.ucenfotec.dl.Conector;

import java.sql.ResultSet;
import java.util.ArrayList;

public class MySqlPincheImpl implements IPincheDAO{

    private String sql;

    public String registrarPinche(Pinche pinche){
        sql="INSERT INTO PINCHE (NOMBRE, APELLIDO, CORREO, CONTRASENNA, ID, NUMEROSOCIAL,FECHANACIMIENTO, ROL, NUMEROFIJO, NUMEROMOVIL, COCINEROENCARGADO) VALUES ('"+pinche.getNombre()+"','"+pinche.getApellidos()+"','"+pinche.getCorreo()+"','"+pinche.getContrasenna()+"','"+pinche.getId()+"','"+pinche.getNumeroSocial()+"','"+pinche.getFechaNacimiento()+"','"+pinche.getRol()+"','"+pinche.getNumeroFijo()+"','"+pinche.getNumeroMovil()+"','"+pinche.getCocineroEncargado()+"')";
        Conector.getConnector().ejecutarSQL(sql);
        return "El pinche " +pinche.getNombre()+", fue agregado con exito";
    }

    public ArrayList<Pinche> listarPinches(){
        ArrayList<Pinche>listaPinches = new ArrayList<>();

        sql="SELECT NOMBRE, APELLIDO, CORREO, CONTRASENNA,ID, NUMEROSOCIAL,FECHANACIMIENTO, ROL, NUMEROFIJO, NUMEROMOVIL FROM PINCHE";

        try {
            ResultSet rsPinche = Conector.getConnector().ejecutarQuery(sql);
            while (rsPinche.next()) {
                String nombre = rsPinche.getString("NOMBRE");
                String apellidos = rsPinche.getString("APELLIDO");
                String correo = rsPinche.getString("CORREO");
                String contrasenna = rsPinche.getString("CONTRASENNA");
                String id = rsPinche.getString("ID");
                String numeroSocial = rsPinche.getString("NUMEROSOCIAL");
                String fechaNacimiento = rsPinche.getString("FECHANACIMIENTO");
                String rol = rsPinche.getString("ROL");
                String numeroFijo = rsPinche.getString("NUMEROFIJO");
                String numeroMovil = rsPinche.getString("NUMEROMOVIL");
                Pinche pincheEncontrado = new Pinche(nombre,apellidos,correo,contrasenna,id,numeroSocial,fechaNacimiento,rol,numeroFijo,numeroMovil);


                sql = "SELECT NOMBRE, APELLIDO, CORREO, CONTRASENNA, ID, NUMEROSOCIAL,FECHANACIMIENTO, ROL, NUMEROFIJO, NUMEROMOVIL, FECHAINGRESO " +
                        "FROM COCINERO WHERE NOMBRE = (SELECT COCINEROENCARGADO FROM PINCHE WHERE NOMBRE='" + nombre + "')";

                ResultSet rsCocinero = Conector.getConnector().ejecutarQuery(sql);

                if (rsCocinero.next()) {
                    String nombrec = rsCocinero.getString("NOMBRE");
                    String apellidosc = rsCocinero.getString("APELLIDO");
                    String correoc = rsCocinero.getString("CORREO");
                    String contrasennac = rsCocinero.getString("CONTRASENNA");
                    String idc = rsCocinero.getString("ID");
                    String numeroSocialc = rsCocinero.getString("NUMEROSOCIAL");
                    String fechaNacimientoc = rsCocinero.getString("FECHANACIMIENTO");
                    String rolc = rsCocinero.getString("ROL");
                    String numeroFijoc = rsCocinero.getString("NUMEROFIJO");
                    String numeroMovilc = rsCocinero.getString("NUMEROMOVIL");
                    String fechaIngresoc = rsCocinero.getString("FECHAINGRESO");
                    Cocinero cocinero = new Cocinero(nombrec,apellidosc,correoc,contrasennac,idc,numeroSocialc,fechaNacimientoc,rolc,numeroFijoc,numeroMovilc,fechaIngresoc);

                    pincheEncontrado.setCocineroEncargado(cocinero.getNombre());
                }

                listaPinches.add(pincheEncontrado);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaPinches;
    }

    public String asignarPincheCocinero(Pinche pinche, Cocinero cocinero) {
        sql = "UPDATE PINCHE SET COCINEROENCARGADO='" + cocinero.getNombre() + "' WHERE NOMBRE='" + pinche.getNombre() + "'";
        pinche.setCocineroEncargado(cocinero.getNombre());
        Conector.getConnector().ejecutarSQL(sql);
        return
                "El cocinero " + cocinero.getNombre() + " fue agregado como encargado al pinche " + pinche.getNombre();
    }

}
