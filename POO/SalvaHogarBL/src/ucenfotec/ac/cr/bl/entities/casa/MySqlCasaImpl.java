package ucenfotec.ac.cr.bl.entities.casa;

import ucenfotec.ac.cr.dl.Conector;

import java.sql.ResultSet;
import java.util.ArrayList;

public class MySqlCasaImpl implements ICasaDAO{

    private String sql;

    public String registrarCasa(Casa casa) {
        sql= "INSERT INTO CASA VALUES("+casa.getDireccion()+",'"+casa.getIdentificacion()+")";
        return "la casa " + casa.getDireccion() + ", fue registrada con correctamente!";
    }

    public ArrayList<Casa> listarCasas() {
        ArrayList<Casa> listaCasas = new ArrayList<>();
        Casa casaEncontrada;

        sql = "SELECT ID,DIRECCION FROM CASA";

        try {
            ResultSet rsCasa = Conector.getConnector().ejecutarQuery(sql);
            while (rsCasa.next()){
                casaEncontrada = new Casa(rsCasa.getString("DIRECCION"),
                                          rsCasa.getString("ID"));

                listaCasas.add(casaEncontrada);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return listaCasas;
    }
}
