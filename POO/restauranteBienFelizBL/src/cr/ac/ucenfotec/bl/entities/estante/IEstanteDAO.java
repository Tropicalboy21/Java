package cr.ac.ucenfotec.bl.entities.estante;

import java.util.ArrayList;

public interface IEstanteDAO {

    String registrarEstante(Estante estante);

    ArrayList<Estante> listarEstantes();

}
