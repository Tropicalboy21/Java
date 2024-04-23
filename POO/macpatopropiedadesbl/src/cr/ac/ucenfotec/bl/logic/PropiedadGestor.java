package cr.ac.ucenfotec.bl.logic;

import cr.ac.ucenfotec.bl.entities.hipoteca.Hipoteca;
import cr.ac.ucenfotec.bl.entities.propiedad.IPropiedadDAO;
import cr.ac.ucenfotec.bl.entities.propiedad.MySqlPropiedadImpl;
import cr.ac.ucenfotec.bl.entities.propiedad.Propiedad;
import java.time.LocalDate;
import java.util.ArrayList;

public class PropiedadGestor {

    private IPropiedadDAO datos;

    public PropiedadGestor(){
        datos = new MySqlPropiedadImpl();
    }

    public String registrarPropiedad(int numFinca, String nombre, int cuartos, String provincia, double costoMensual){
        Propiedad nuevaPropiedad = new Propiedad(numFinca,nombre,cuartos,provincia,costoMensual);
        return datos.registrarPropiedad(nuevaPropiedad);
    }

    public ArrayList<String> listarPropiedades(){
        ArrayList<String> infoPropiedades = new ArrayList<>();
        for (Propiedad propiedadTemp: datos.listarPropiedades()) {
            infoPropiedades.add(propiedadTemp.toString());
        }
        return infoPropiedades;
    }

    public String asignarInquilinoAPropiedad(int numFinca, int cedula){
        /*Propiedad propiedad = new Propiedad();
        propiedad.setNumFinca(numFinca);
        return datos.asignarInquilinoAPropiedad(new Propiedad(),new Inquilino());*/
        return "";
    }

    public String crearHipoteca(int numFinca, int numHipoteca, LocalDate fechaFinaliza, double monto, String acredor){

        ArrayList<Propiedad> listadoDePropiedades = datos.listarPropiedades();
        Propiedad propiedadEncontrada = new Propiedad();
        propiedadEncontrada.setNumFinca(numFinca);
        int pos = listadoDePropiedades.indexOf(propiedadEncontrada);

        if(pos >=0){
            propiedadEncontrada = listadoDePropiedades.get(pos);
            Hipoteca nuevaHipoteca = new Hipoteca(numHipoteca,fechaFinaliza,monto,acredor);
            return datos.crearHipoteca(propiedadEncontrada,nuevaHipoteca);
        }
        return "La propiedad N°"+numFinca + ", no existe en el sistema!";
    }

}
