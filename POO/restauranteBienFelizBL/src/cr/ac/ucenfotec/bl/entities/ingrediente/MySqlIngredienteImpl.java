package cr.ac.ucenfotec.bl.entities.ingrediente;

import cr.ac.ucenfotec.dl.Conector;

import java.sql.ResultSet;
import java.util.ArrayList;

public class MySqlIngredienteImpl implements IIngredienteDAO {
    private String sql;

    public String registrarIngrediente(Ingrediente ingrediente){
        sql="INSERT INTO INGREDIENTE (NOMBRE, CANTIDAD) VALUES ('"+ingrediente.getNombre()+"','"+ingrediente.getCantidad()+"')";
        Conector.getConnector().ejecutarSQL(sql);
        return "El ingrediente fue agregado con exito";
    }

    public ArrayList<Ingrediente> listarIngredientes(){
        ArrayList<Ingrediente> listaIngredientes = new ArrayList<>();

        sql ="SELECT NOMBRE, CANTIDAD FROM INGREDIENTE";

        try{
            ResultSet rsIngrediente = Conector.getConnector().ejecutarQuery(sql);
            while(rsIngrediente.next()){
                String nombre = rsIngrediente.getString("NOMBRE");
                int cantidad = rsIngrediente.getInt("CANTIDAD");

                Ingrediente ingredienteEncontrado = new Ingrediente(nombre, cantidad);

                listaIngredientes.add(ingredienteEncontrado);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return listaIngredientes;
    }
}
