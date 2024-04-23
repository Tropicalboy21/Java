package ucenfotec.ac.cr.bl.entities.casa;

import java.util.ArrayList;

public interface ICasaDAO {
    String registrarCasa(Casa casa);
    ArrayList<Casa> listarCasas();

}
