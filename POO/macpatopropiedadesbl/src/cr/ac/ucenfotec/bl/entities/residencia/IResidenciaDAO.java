package cr.ac.ucenfotec.bl.entities.residencia;

import java.util.ArrayList;

public interface IResidenciaDAO {
    String registrarResidencia(Residencia residencia);
    ArrayList<Residencia> listarResidencias();
    Residencia buscarResidencia(int idResidencia);
}
