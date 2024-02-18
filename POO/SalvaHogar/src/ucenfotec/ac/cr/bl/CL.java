package ucenfotec.ac.cr.bl;

import java.time.LocalDate;
import java.time.Period;

import java.util.ArrayList;

public class CL {

    private ArrayList<Vecino> vecinos;

    private ArrayList<Casa> casas;

    public CL() {vecinos = new ArrayList<>(); casas = new ArrayList<>();}

    public String registrarCasa(String direccion, String identificacion, String encargado){
        Casa nuevaCasa = new Casa(direccion,identificacion,encargado);

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

    public String registrarVecino(String nombre, String apellidos, String identificacion, String nacimiento, int edad,  String genero, String telefono, boolean encargado){
        Vecino nuevoVecino = new Vecino(nombre, apellidos,identificacion,nacimiento, edad, genero,telefono, encargado);

        vecinos.add(nuevoVecino);

        return "\nEl Vecino fue añadido con exito";
    }

    public ArrayList<String> listarVecinos(){
        ArrayList<String> infoVecinos = new ArrayList<>();
        for(Vecino vecinoTemp: vecinos){
            infoVecinos.add(vecinoTemp.toString());
        }
        return  infoVecinos;
    }

    public int CalcularEdad(LocalDate dob)
    {
        LocalDate curDate = LocalDate.now();
        if ((dob != null) && (curDate != null))
        {
            return Period.between(dob, curDate).getYears();
        }
        else
        {
            return 0;
        }
    }
}


