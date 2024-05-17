package cr.ac.ucenfotec.bl.entities.estante;

import cr.ac.ucenfotec.dl.Conector;

import java.sql.ResultSet;
import java.util.ArrayList;

public class MySqlEstanteImpl implements IEstanteDAO{

    private String sql;

    public String registrarEstante(Estante estante){
        sql= "INSERT INTO ESTANTE (CODIGO) VALUES('"+estante.getCodigo()+"')";
        Conector.getConnector().ejecutarSQL(sql);
        return "El Estado con codigo " +estante.getCodigo()+", fue agregado con exito!";
    }

    public ArrayList<Estante> listarEstantes(){
        ArrayList<Estante> listaEstantes = new ArrayList<>();

        sql= "SELECT CODIGO FROM ESTANTE ";

        try{
            ResultSet rsEstante = Conector.getConnector().ejecutarQuery(sql);
            while (rsEstante.next()){
                String codigo = rsEstante.getString("CODIGO");

                Estante estanteEncontrado = new Estante(codigo);

                listaEstantes.add(estanteEncontrado);
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        return listaEstantes;
    }

}
