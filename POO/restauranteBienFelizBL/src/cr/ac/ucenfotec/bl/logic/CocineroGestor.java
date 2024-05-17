package cr.ac.ucenfotec.bl.logic;

import cr.ac.ucenfotec.bl.entities.cocinero.Cocinero;
import cr.ac.ucenfotec.bl.entities.cocinero.ICocineroDAO;
import cr.ac.ucenfotec.bl.entities.cocinero.MySqlCocineroImpl;

import java.util.ArrayList;

public class CocineroGestor {

    private ICocineroDAO datos;

    public CocineroGestor(){
        datos = new MySqlCocineroImpl();
    }
    public String registrarCocinero(String nombre, String apellidos,String correo, String contrasenna, String id, String numeroSocial, String fechaNacimiento, String rol, String numeroFijo, String numeroMovil, String fechaIngreso){
        Cocinero nuevoCocinero = new Cocinero(nombre,apellidos,correo,contrasenna,id,numeroSocial,fechaNacimiento,rol,numeroFijo,numeroMovil,fechaIngreso);
        return datos.registrarCocinero(nuevoCocinero);
    }
    public ArrayList<String> listarCocineros(){
        ArrayList<String> infoCocineros = new ArrayList<>();
        for (Cocinero casaTemp: datos.listarCocineros()){
            infoCocineros.add(casaTemp.toString());
        }
        return infoCocineros;
    }

    public Cocinero validarCocinero(String correo, String contrasenna){
        for(Cocinero cocineroTemp: datos.listarCocineros()){
            if (cocineroTemp.getCorreo().equals(correo) && cocineroTemp.getContrasenna().equals(contrasenna))
                return cocineroTemp;
        }
        return null;
    }
}
