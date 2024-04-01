package ucenfotec.ac.cr.bl.logic;

import ucenfotec.ac.cr.bl.entities.Casa;
import ucenfotec.ac.cr.bl.entities.Vecino;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class VecinoGestor extends Gestor{

    public String registrarVecino(String nombre, String apellido, String identificacion, String nacimiento, int edad,  String genero, String telefono, boolean encargado){
        Vecino nuevoVecino = new Vecino(nombre, apellido, identificacion, nacimiento, edad, genero, telefono, encargado);

        return datos.registrarVecino(nuevoVecino);
    }

    public ArrayList<String> listarVecinos(){
        return datos.listarVecinos();
    }

    public String agregarVecinoCasa(String idCasa, String idVecino) {
        Casa casa = datos.buscarCasa(idCasa);
        if(casa != null){
            Vecino vecino = datos.buscarVecino(idVecino);
            if(vecino !=null){
                //  agregacion
                casa.asociarVecino(vecino);
                return "El vecino " + vecino.getNombre() +" fue agregado a la casa en " + casa.getDireccion();
            }else
                return "El vecino con el id " +idVecino+", no existe en el sitema!";
        }else
            return "La casa con el id " + idCasa + ", no existe en el sistema!";
    }

    public int calcularEdad(LocalDate dob)
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

