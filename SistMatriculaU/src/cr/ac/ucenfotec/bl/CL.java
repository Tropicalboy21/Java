package cr.ac.ucenfotec.bl;

import java.util.ArrayList;

public class CL {

    private ArrayList<Carrera> listaCarreras;

    public CL(){
        listaCarreras = new ArrayList<>();
    }

    public String registrarCarrera(String codigo, String nombre, boolean esAcreditada){
        Carrera nuevaCarrera = new Carrera(codigo,nombre,esAcreditada);
        listaCarreras.add(nuevaCarrera);

        return "La carrera fue registrada correctamente!";
    }

    public ArrayList<String> listarCarreras(){
        ArrayList<String> infoCarreras = new ArrayList<>();
        for (Carrera carreraTemp:listaCarreras) {
            infoCarreras.add(carreraTemp.toString());
        }
        return infoCarreras;
    }

}
