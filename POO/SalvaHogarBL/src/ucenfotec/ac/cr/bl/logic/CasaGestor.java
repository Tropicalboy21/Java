package ucenfotec.ac.cr.bl.logic;

import ucenfotec.ac.cr.bl.entities.Casa;

import java.util.ArrayList;

public class CasaGestor extends Gestor {

    public String registrarCasa(String direccion, String identificacion){
        Casa nuevaCasa = new Casa(direccion,identificacion);

        return datos.registrarCasa(nuevaCasa);
    }
    public ArrayList<String> listarCasas(){
        return datos.listarCasas();

    }

}
