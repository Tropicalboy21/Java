package ucenfotec.ac.cr.bl.entities.casa;

import ucenfotec.ac.cr.bl.entities.vecino.Vecino;
import ucenfotec.ac.cr.dl.Conector;

import java.sql.ResultSet;
import java.util.ArrayList;

public class MySqlCasaImpl implements ICasaDAO{

    private String sql;

    public String registrarCasa(Casa casa) {
        sql = "INSERT INTO CASA (DIRECCION, IDENTIFICACION) VALUES ('"+casa.getDireccion()+"','"+casa.getIdentificacion()+"')";
        Conector.getConnector().ejecutarSQL(sql);
        return "la casa " + casa.getDireccion() + ", fue registrada con correctamente!";
    }

    public ArrayList<Casa> listarCasas() {
        ArrayList<Casa> listaCasas = new ArrayList<>();

        sql = "SELECT DIRECCION, IDENTIFICACION FROM CASA";

        try {
            ResultSet rsCasa = Conector.getConnector().ejecutarQuery(sql);
            while (rsCasa.next()) {
                String direccion = rsCasa.getString("DIRECCION");
                String identificacion = rsCasa.getString("IDENTIFICACION");

                Casa casaEncontrada = new Casa(direccion, identificacion);

                sql = "SELECT NOMBRE, APELLIDO, IDENTIFICACION, FECHANACIMIENTO, EDAD, GENERO, TELEFONO, ENCARGADO " +
                        "FROM VECINO WHERE NOMBRE = (SELECT ENCARGADO FROM CASA WHERE DIRECCION='" + direccion + "')";

                ResultSet rsEncargado = Conector.getConnector().ejecutarQuery(sql);

                if (rsEncargado.next()) {
                    String nombreEncargado = rsEncargado.getString("NOMBRE");
                    String apellidoEncargado = rsEncargado.getString("APELLIDO");
                    String identificacionEncargado = rsEncargado.getString("IDENTIFICACION");
                    String fechaNacimientoEncargado = rsEncargado.getString("FECHANACIMIENTO");
                    int edadEncargado = rsEncargado.getInt("EDAD");
                    String generoEncargado = rsEncargado.getString("GENERO");
                    String telefonoEncargado = rsEncargado.getString("TELEFONO");

                    Vecino encargado = new Vecino(nombreEncargado, apellidoEncargado, identificacionEncargado,
                            fechaNacimientoEncargado, edadEncargado, generoEncargado,
                            telefonoEncargado, nombreEncargado);

                    casaEncontrada.asignarEncargado(encargado);
                }

                sql = "SELECT V.NOMBRE, V.APELLIDO, V.IDENTIFICACION, V.FECHANACIMIENTO, V.EDAD, V.GENERO, V.TELEFONO, V.ENCARGADO " +
                        "FROM CASA_VECINO CV INNER JOIN VECINO V ON CV.NOMBRE = V.NOMBRE " +
                        "AND CV.DIRECCION = '" + direccion + "'";

                ResultSet rsVeci = Conector.getConnector().ejecutarQuery(sql);
                while (rsVeci.next()) {
                    Vecino vecinoEncontrado = new Vecino(rsVeci.getString("NOMBRE"),
                            rsVeci.getString("APELLIDO"),
                            rsVeci.getString("IDENTIFICACION"),
                            rsVeci.getString("FECHANACIMIENTO"),
                            rsVeci.getInt("EDAD"),
                            rsVeci.getString("GENERO"),
                            rsVeci.getString("TELEFONO"),
                            rsVeci.getString("ENCARGADO"));
                    casaEncontrada.asociarVecino(vecinoEncontrado);
                }
                listaCasas.add(casaEncontrada);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaCasas;
    }
    public String agregarVecinoCasa(Casa casa, Vecino vecino) {
        sql="INSERT INTO CASA_VECINO VALUES ('"+casa.getDireccion()+"','"+vecino.getNombre()+"')";
        Conector.getConnector().ejecutarSQL(sql);
        return "El vecino " + vecino.getNombre() +" fue agregado a la casa en " + casa.getDireccion();
    }
    public String asignarEncargadoCasa(Casa casa, Vecino vecino) {
        sql = "UPDATE CASA SET ENCARGADO='" + vecino.getNombre() + "' WHERE DIRECCION='" + casa.getDireccion() + "'";
        casa.asignarEncargado(vecino);
        Conector.getConnector().ejecutarSQL(sql);
        return "El vecino " + vecino.getNombre() + " fue agregado como encargado a la casa en " + casa.getDireccion();
    }

}
