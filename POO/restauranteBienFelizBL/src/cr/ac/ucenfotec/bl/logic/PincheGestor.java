package cr.ac.ucenfotec.bl.logic;

import cr.ac.ucenfotec.bl.entities.cocinero.Cocinero;
import cr.ac.ucenfotec.bl.entities.cocinero.ICocineroDAO;
import cr.ac.ucenfotec.bl.entities.cocinero.MySqlCocineroImpl;
import cr.ac.ucenfotec.bl.entities.empleado.Empleado;
import cr.ac.ucenfotec.bl.entities.pinche.IPincheDAO;
import cr.ac.ucenfotec.bl.entities.pinche.MySqlPincheImpl;
import cr.ac.ucenfotec.bl.entities.pinche.Pinche;

import java.util.ArrayList;

public class PincheGestor {

    private IPincheDAO datos;
    private ICocineroDAO datosC;

    public PincheGestor(){
        datos = new MySqlPincheImpl();
        datosC = new MySqlCocineroImpl();
    }

    public String registrarPinche(String nombre, String apellidos, String correo, String contrasenna, String id, String numeroSocial, String fechaNacimiento, String rol, String numeroFijo, String numeroMovil){
        Pinche nuevoPinche = new Pinche(nombre,apellidos,correo,contrasenna,id,numeroSocial,fechaNacimiento,rol,numeroFijo,numeroMovil);
        return datos.registrarPinche(nuevoPinche);
    }

    public ArrayList<String> listarPinches(){
        ArrayList<String> infoPiches = new ArrayList<>();
        for (Pinche picheTemp: datos.listarPinches()){
            infoPiches.add(picheTemp.toString());
        }
        return infoPiches;
    }

    public Pinche validarPinche(String correo, String contrasenna){
        for(Pinche pincheTemp: datos.listarPinches()){
            if (pincheTemp.getCorreo().equals(correo) && pincheTemp.getContrasenna().equals(contrasenna))
                return pincheTemp;
        }
        return null;
    }

//        public String asociarPincheACocinero(String cocinero, String pinche){
//
//        Cocinero cocineroEn = buscarCocinero(cocinero);
//        if(cocineroEn != null){
//            Pinche pincheEn =  buscarPinche(pinche);
//            if(pincheEn !=null){
//                pincheEn.setCocineroEncargado(cocinero);
//                return "El cocinero " + cocineroEn.getNombre() + " es ahora el encargado del pinche " + pincheEn.getNombre();
//            }else
//                return "El pinche con el nombre " +pinche+", no existe en el sitema!";
//        }else
//            return "La cocinero con el nombre " + cocinero + ", no existe en el sistema!";
//    }

    public String asociarPincheACocinero(String cocineroNombre, String pincheNombre) {
        ArrayList<Pinche> listadoPinches = datos.listarPinches();
        ArrayList<Cocinero> listadoCocineros = datosC.listarCocineros();

        Cocinero cocineroEncontrado = null;
        for (Cocinero c : listadoCocineros) {
            if (c.getNombre().equals(cocineroNombre)) {
                cocineroEncontrado = c;
                break;
            }
        }

        Pinche pincheEncontrado = null;
        for (Pinche p : listadoPinches) {
            if (p.getNombre().equals(pincheNombre)) {
                pincheEncontrado = p;
                break;
            }
        }

        if (cocineroEncontrado != null && pincheEncontrado != null) {
            try {
                datos.asignarPincheCocinero(pincheEncontrado, cocineroEncontrado);

                return "El cocinero " + cocineroEncontrado.getNombre() + " fue agregado como encargado al pinche en " + pincheEncontrado.getNombre();
            } catch (Exception e) {
                return "Error al asignar encargado: " + e.getMessage();
            }
        } else {
            return "No se encontró el pinche o el cocinero especificado.";
        }
    }

    public Pinche buscarPinche(String nombre){
        for (Pinche pincheEncontrado: datos.listarPinches()) {
            if(pincheEncontrado.getNombre().equals(nombre))
                return pincheEncontrado;
        }
        return null;
    }

        public Cocinero buscarCocinero(String nombre){
        for (Cocinero cocineroEncontrado: datosC.listarCocineros()) {
            if(cocineroEncontrado.getNombre().equals(nombre))
                return cocineroEncontrado;
        }
        return null;
    }
}
