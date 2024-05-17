package cr.ac.ucenfotec.bl.logic;

import cr.ac.ucenfotec.bl.entities.ingrediente.IIngredienteDAO;
import cr.ac.ucenfotec.bl.entities.ingrediente.Ingrediente;
import cr.ac.ucenfotec.bl.entities.ingrediente.MySqlIngredienteImpl;

import java.util.ArrayList;

public class IngredienteGestor {

    private IIngredienteDAO datos;

    public IngredienteGestor() {
        datos = new MySqlIngredienteImpl();
    }
    public String registrarIngrediente(String nombre, int cantidad){
        Ingrediente nuevoIngrediente = new Ingrediente(nombre, cantidad);
        return datos.registrarIngrediente(nuevoIngrediente);
    }

    public ArrayList<String> listarIngredientes(){
        ArrayList<String> infoIngredientes = new ArrayList<>();
        for (Ingrediente ingredienteTemp: datos.listarIngredientes()){
            infoIngredientes.add(ingredienteTemp.toString());
        }
        return infoIngredientes;
    }
}
