package ucenfotec.ac.cr.dl;

import ucenfotec.ac.cr.bl.entities.Casa;
import ucenfotec.ac.cr.bl.entities.Vecino;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class Data {
    private ArrayList<Casa> casas;

    private  ArrayList<Vecino> vecinos;

    public Data() {
        casas = new ArrayList<>();
        vecinos = new ArrayList<>();
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
    
    public String registrarVecino(Vecino nuevoVecino){
        vecinos.add(nuevoVecino);
        
        return 
                "\nEl vecino fue añadido con exito";
    }
    
    public ArrayList<String> listarVecinos(){
        ArrayList<String> infoVecinos = new ArrayList<>();
        
        for (Vecino vecinoTemp: vecinos){
            infoVecinos.add(vecinoTemp.toString());
        }

        return  infoVecinos;

    }

    public Casa buscarCasa(String idCasa){
        for (Casa casaEncotrada:casas) {
            if(casaEncotrada.getIdentificacion().equals(idCasa))
                return casaEncotrada;
        }
        return null;
    }

    public Vecino buscarVecino(String idVecino){
        for (Vecino vecinoEncotrada:vecinos) {
            if(vecinoEncotrada.getIdentificacion().equals(idVecino))
                return vecinoEncotrada;
        }
        return null;
    }

}
