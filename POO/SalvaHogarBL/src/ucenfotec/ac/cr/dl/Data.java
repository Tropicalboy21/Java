package ucenfotec.ac.cr.dl;

import ucenfotec.ac.cr.bl.entities.Casa;

import java.util.ArrayList;

public class Data {
    private ArrayList<Casa> casas;

    public Data() {
        casas = new ArrayList<>();
    }

    public String registrarCasa(Casa nuevaCasa){
        casas.add(nuevaCasa);

        return "\nLa casa fue añadida con exito";
    }

    public ArrayList<String> listarCasas(){
        ArrayList<String> infoCasas = new ArrayList<>();

        for(Casa casaTemp: casas){
            infoCasas.add(casaTemp.toString());
        }

        return infoCasas;

    }
}
