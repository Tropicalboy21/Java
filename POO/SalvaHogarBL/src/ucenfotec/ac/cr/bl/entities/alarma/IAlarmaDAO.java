package ucenfotec.ac.cr.bl.entities.alarma;

import ucenfotec.ac.cr.bl.entities.casa.Casa;
import ucenfotec.ac.cr.bl.entities.vecino.Vecino;

public interface IAlarmaDAO {

    String crearAlarma(Casa casa, Alarma alarma, Vecino vecino);

}
