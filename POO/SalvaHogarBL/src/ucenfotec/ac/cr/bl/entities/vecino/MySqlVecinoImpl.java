package ucenfotec.ac.cr.bl.entities.vecino;

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

    public ArrayList<Vecino> listarVecinos(){
        ArrayList<Vecino> listaVecinos = new ArrayList<>();
        Vecino vecinoEncontrado;

        sql="SELECT NOMBRE,APELLIDO,IDENTIFICACION,NACIMIENTO,EDAD,GENERO,TELEFONO,ENCARGADO FROM VECINO";

        try {
            ResultSet rsVecino = Conector.getConnector().ejecutarQuery(sql);
            while (rsVecino.next()){
                vecinoEncontrado = new Vecino(rsVecino.getString("NOMBRE"),
                                              rsVecino.getString("APELLIDO"),
                                              rsVecino.getString("IDENTIFICACION"),
                                              rsVecino.getString("NACIMIENTO"),
                                              rsVecino.getInt("EDAD"),
                                              rsVecino.getString("GENERO"),
                                              rsVecino.getString("TELEFONO"),
                                              rsVecino.getString("ENCARGADO"));
                listaVecinos.add(vecinoEncontrado);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return listaVecinos;
    }

}
