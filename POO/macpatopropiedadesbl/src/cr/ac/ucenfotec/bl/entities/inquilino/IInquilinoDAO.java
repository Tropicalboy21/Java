package cr.ac.ucenfotec.bl.entities.inquilino;

import cr.ac.ucenfotec.bl.entities.residencia.Residencia;
import java.util.ArrayList;

public interface IInquilinoDAO {
    String registrarInquilino(Inquilino inquilino);
    ArrayList<Inquilino> listarInquilinos();
    String asignarResidencia(Inquilino inquilino, Residencia residencia);
}
