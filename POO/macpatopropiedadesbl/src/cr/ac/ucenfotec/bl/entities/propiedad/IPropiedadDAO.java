package cr.ac.ucenfotec.bl.entities.propiedad;

import cr.ac.ucenfotec.bl.entities.hipoteca.Hipoteca;
import cr.ac.ucenfotec.bl.entities.inquilino.Inquilino;

import java.util.ArrayList;

public interface IPropiedadDAO {
    String registrarPropiedad(Propiedad propiedad);
    ArrayList<Propiedad> listarPropiedades();
    String asignarInquilinoAPropiedad(Propiedad propiedad, Inquilino inquilino);
    String crearHipoteca(Propiedad propiedad, Hipoteca hipoteca);
}
