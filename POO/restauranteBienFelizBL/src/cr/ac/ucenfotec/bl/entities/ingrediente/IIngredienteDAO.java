package cr.ac.ucenfotec.bl.entities.ingrediente;

import java.util.ArrayList;

public interface IIngredienteDAO {

    String registrarIngrediente(Ingrediente ingrediente);

    ArrayList<Ingrediente> listarIngredientes();
}
