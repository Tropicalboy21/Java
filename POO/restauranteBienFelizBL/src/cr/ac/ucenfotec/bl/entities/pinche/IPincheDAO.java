package cr.ac.ucenfotec.bl.entities.pinche;

import cr.ac.ucenfotec.bl.entities.cocinero.Cocinero;

import java.util.ArrayList;

public interface IPincheDAO {
    String registrarPinche(Pinche pinche);
    ArrayList<Pinche> listarPinches();
    String asignarPincheCocinero(Pinche pinche, Cocinero cocinero);
}
