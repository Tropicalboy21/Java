package ucenfotec.ac.cr.bl.entities.vecino;

import ucenfotec.ac.cr.bl.entities.alarma.Alarma;
import ucenfotec.ac.cr.bl.entities.casa.Casa;

import java.util.ArrayList;

public interface IVecinoDAO {
    String registrarVecino(Vecino vecino);
    ArrayList<Vecino> listarVecinos();

    String crearAlarma(Casa casa, Alarma alarma, Vecino vecino);




}
