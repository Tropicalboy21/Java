package ucenfotec.ac.cr.bl.entities.vecino;

import ucenfotec.ac.cr.bl.entities.alarma.Alarma;
import ucenfotec.ac.cr.bl.entities.casa.Casa;
import ucenfotec.ac.cr.dl.Conector;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class MySqlVecinoImpl implements IVecinoDAO{

    private String sql;

    public String registrarVecino(Vecino vecino){
        sql="INSERT INTO VECINO VALUES('"+vecino.getNombre()+"','"+vecino.getApellido()+"','"+vecino.getIdentificacion()+"','"+vecino.getNacimiento()+"','"+vecino.getEdad()+"','"+vecino.getGenero()+"','"+vecino.getTelefono()+"','"+vecino.getEncargado()+"')";
        Conector.getConnector().ejecutarSQL(sql);
        return "El vecino " + vecino.getNombre() + ", ha sido registrado con exito!";
    }

    public ArrayList<Vecino> listarVecinos() {
        ArrayList<Vecino> listaVecinos = new ArrayList<>();

        sql = "SELECT VECINO.NOMBRE, VECINO.APELLIDO, VECINO.IDENTIFICACION AS VECINO_IDENTIFICACION, " +
                "VECINO.FECHANACIMIENTO, VECINO.EDAD, VECINO.GENERO, VECINO.TELEFONO, VECINO.ENCARGADO, " +
                "ALARMA.DIRECCION, CASA.IDENTIFICACION AS CASA_IDENTIFICACION, ALARMA.DESCRIPCION " +
                "FROM VECINO " +
                "LEFT JOIN ALARMA ON VECINO.NOMBRE = ALARMA.ENCARGADO " +
                "LEFT JOIN CASA ON ALARMA.DIRECCION = CASA.DIRECCION";

        try {
            ResultSet rs = Conector.getConnector().ejecutarQuery(sql);
            Vecino vecino = null;
            while (rs.next()) {
                if (vecino == null || !vecino.getNombre().equals(rs.getString("NOMBRE"))) {
                    vecino = new Vecino(rs.getString("NOMBRE"),
                            rs.getString("APELLIDO"),
                            rs.getString("VECINO_IDENTIFICACION"),
                            rs.getString("FECHANACIMIENTO"),
                            rs.getInt("EDAD"),
                            rs.getString("GENERO"),
                            rs.getString("TELEFONO"),
                            rs.getString("ENCARGADO"));
                    listaVecinos.add(vecino);
                }
                if (rs.getString("DIRECCION") != null) {
                    Alarma alarma = new Alarma(rs.getString("DIRECCION"),
                            rs.getString("CASA_IDENTIFICACION"),
                            rs.getString("NOMBRE"),
                            rs.getString("DESCRIPCION"));
                    vecino.asociarAlarma(alarma);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaVecinos;
    }

    public String crearAlarma(Casa casa, Alarma alarma, Vecino vecino) {
        sql = "INSERT INTO alarma (direccion, identificacion, encargado, descripcion) VALUES " + "('" + casa.getDireccion() + "','" + casa.getIdentificacion() + "','" + vecino.getNombre() + "','" + alarma.getDescripcion() + "')";
        vecino.asociarAlarma(alarma);
        Conector.getConnector().ejecutarSQL(sql);
        return null;
    }

}
