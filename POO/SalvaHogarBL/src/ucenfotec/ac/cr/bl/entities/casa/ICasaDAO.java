package ucenfotec.ac.cr.bl.entities.casa;

import ucenfotec.ac.cr.bl.entities.vecino.Vecino;

import java.util.ArrayList;

public interface ICasaDAO {
    String registrarCasa(Casa casa);
    ArrayList<Casa> listarCasas();
    String agregarVecinoCasa(Casa casa, Vecino vecino);
    String asignarEncargadoCasa(Casa casa, Vecino vecino);
}
