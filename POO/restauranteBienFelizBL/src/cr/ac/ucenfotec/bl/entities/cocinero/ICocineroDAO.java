package cr.ac.ucenfotec.bl.entities.cocinero;

import cr.ac.ucenfotec.bl.entities.empleado.Empleado;

import java.util.ArrayList;

public interface ICocineroDAO {
    String registrarCocinero(Cocinero cocinero);

    ArrayList<Cocinero> listarCocineros();
}
