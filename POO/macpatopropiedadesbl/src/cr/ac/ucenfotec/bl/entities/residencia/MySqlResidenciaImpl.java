package cr.ac.ucenfotec.bl.entities.residencia;

import cr.ac.ucenfotec.dl.Conector;

import java.sql.ResultSet;
import java.util.ArrayList;

public class MySqlResidenciaImpl implements IResidenciaDAO{

    private String sql;

    public String registrarResidencia(Residencia residencia) {
        sql="INSERT INTO RESIDENCIA VALUES("+residencia.getIdResidencia()+
                ",'"+residencia.getProvincia()+"', '"+residencia.getCanton()+
                "','"+residencia.getDistrito()+"','"+residencia.getBarrio()+"')";
        Conector.getConnector().ejecutarSQL(sql);

        return "La residencia N°" + residencia.getIdResidencia()+", fue registrada correctamente!";
    }


    public ArrayList<Residencia> listarResidencias() {
        ArrayList<Residencia> listaResidencias = new ArrayList<>();
        Residencia residenciaEncontrada;

        try {
            sql = "SELECT IDRESIDENCIA,PROVINCIA,CANTON,DISTRITO,BARRIO FROM RESIDENCIA";
            ResultSet rs = Conector.getConnector().ejecutarQuery(sql);

            while(rs.next()){
                residenciaEncontrada = new Residencia(rs.getInt("IDRESIDENCIA"),
                                                      rs.getString("PROVINCIA"),
                                                      rs.getString("CANTON"),
                                                      rs.getString("DISTRITO"),
                                                      rs.getString("BARRIO"));
               listaResidencias.add(residenciaEncontrada);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return listaResidencias;
    }

    public Residencia buscarResidencia(int idResidencia) {
        Residencia residenciaEncontrada = null;
        sql="SELECT IDRESIDENCIA,PROVINCIA,CANTON,DISTRITO,BARRIO FROM RESIDENCIA WHERE IDRESIDENCIA="+idResidencia;
        try {
            ResultSet rs = Conector.getConnector().ejecutarQuery(sql);
            if(rs.next()){
                residenciaEncontrada = new Residencia(rs.getInt("IDRESIDENCIA"),
                                                      rs.getString("PROVINCIA"),
                                                      rs.getString("CANTON"),
                                                      rs.getString("DISTRITO"),
                                                      rs.getString("BARRIO"));
            }
        }catch(Exception e){
            residenciaEncontrada = null;
        }finally {
         return residenciaEncontrada;
        }
    }
}
