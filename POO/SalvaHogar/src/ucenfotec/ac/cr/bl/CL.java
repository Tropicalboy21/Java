package ucenfotec.ac.cr.bl;

import java.time.LocalDate;
import java.time.Period;

import java.util.ArrayList;

public class CL {

    private ArrayList<Vecino> vecinos;

    private ArrayList<Casa> casas;

    public CL() {vecinos = new ArrayList<>(); casas = new ArrayList<>();}

    public String registrarCasa(String direccion, String identificacion){
        Casa nuevaCasa = new Casa(direccion,identificacion);

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

    public ArrayList<String> listarVecinos() {
        ArrayList<String> infoVecinos = new ArrayList<>();
        for (Vecino vecinoTemp : vecinos) {
            infoVecinos.add(vecinoTemp.toString());
        }
        return infoVecinos;
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

    public String agregarVecinoCasa(String idCasa, String idVecino) {
        Casa casa = buscarCasa(idCasa);
        if(casa != null){
            Vecino vecino = buscarVecino(idVecino);
            if(vecino !=null){
                //  agregacion
                casa.asociarVecino(vecino);
                return "El vecino " + vecino.getNombre() +" fue agregado a la casa en " + casa.getDireccion();
            }else
                return "El vecino con el id " +idVecino+", no existe en el sitema!";
        }else
            return "La casa con el id " + idCasa + ", no existe en el sistema!";
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


