package cr.ac.ucenfotec.bl.entities.platillo;

import cr.ac.ucenfotec.dl.Conector;

import java.sql.Array;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;

public class MySqlPlatilloImpl implements IPlatilloDAO {

    private String sql;

    public String registrarPlatillo(Platillo platillo){
        sql="INSERT INTO PLATILLO (NOMBRE,INGREDIENTES,EXPERTO, COSTO) VALUES ('"+platillo.getNombre()+"','"+platillo.getIngredientes()+"','"+platillo.getExperto()+"','"+platillo.getCosto()+"')";
        Conector.getConnector().ejecutarSQL(sql);
        return "El Platillo fue agregado con exito! ";
    }

//    public ArrayList<Platillo> listarPlatillos(){
//        ArrayList<Platillo> listaPlatillos = new ArrayList<>();
//        sql= "SELECT NOMBRE,INGREDIENTES,EXPERTO,COSTO FROM PLATILLO";
//        try {
//            ResultSet rsPlatillo = Conector.getConnector().ejecutarQuery(sql);
//            while(rsPlatillo.next()){
//                Platillo PlatilloEncontrado = new Platillo(rsPlatillo.getString("NOMBRE"),
//                        rsPlatillo.getArray("INGREDIENTES"),
//                        rsPlatillo.getString("EXPERTO"),
//                        rsPlatillo.getDouble("COSTO"));
//
//            }
//            listaPlatillos
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return listaPlatillos;
//    }

    public ArrayList<Platillo> listarPlatillos() {
        ArrayList<Platillo> listaPlatillos = new ArrayList<>();
        sql = "SELECT NOMBRE, EXPERTO, COSTO FROM PLATILLO";
        try {
            ResultSet rsPlatillo = Conector.getConnector().ejecutarQuery(sql);
            while (rsPlatillo.next()) {

                // Create the Platillo object and add it to the list
                Platillo platilloEncontrado = new Platillo(
                        rsPlatillo.getString("NOMBRE"),
                        rsPlatillo.getString("EXPERTO"),
                        rsPlatillo.getDouble("COSTO")
                );
                listaPlatillos.add(platilloEncontrado);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaPlatillos;
    }

}
