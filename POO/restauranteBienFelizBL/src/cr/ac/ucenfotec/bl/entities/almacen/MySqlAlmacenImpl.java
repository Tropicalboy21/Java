package cr.ac.ucenfotec.bl.entities.almacen;

import cr.ac.ucenfotec.bl.entities.estante.Estante;
import cr.ac.ucenfotec.dl.Conector;

import java.sql.ResultSet;
import java.util.ArrayList;

public class MySqlAlmacenImpl  implements IAlmacenDAO{

    String sql;

    public String registrarAlmacen(Almacen almacen){
        sql="INSERT INTO ALMACEN (CODIGO) VALUES ('"+almacen.getCodigo()+"')";
        Conector.getConnector().ejecutarSQL(sql);
        return "El Almacen con codigo" +almacen.getCodigo()+ ", se creo con exito!";
    }

    public ArrayList<Almacen> listarAlmacenes(){
        ArrayList<Almacen> listaAlmacenes = new ArrayList<>();

        sql= "SELECT CODIGO FROM ALMACEN";

        try {
            ResultSet rsAlmacen = Conector.getConnector().ejecutarQuery(sql);
            while (rsAlmacen.next()){
                String codigo = rsAlmacen.getString("CODIGO");
                Almacen almacenEncontrado = new Almacen(codigo);

//                sql = "SELECT E.CODIGO" +
//                        "FROM ALMACEN_ESTANTE AE INNER JOIN ESTANTE E ON AE.CODIGO = E.CODIGO " +
//                        "AND AE.CODIGO = '" + codigo + "'";
//
//                ResultSet rsEstante = Conector.getConnector().ejecutarQuery(sql);
//                while(rsEstante.next()){
//                    Estante estanteEncontrado = new Estante(rsEstante.getString("CODIGO"));
//                    almacenEncontrado.agregarEstanteAlmacen(estanteEncontrado);
//                }
                listaAlmacenes.add(almacenEncontrado);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return listaAlmacenes;
    }
}
