package ucenfotec.ac.cr.bl.logic;

import ucenfotec.ac.cr.bl.entities.alarma.Alarma;
import ucenfotec.ac.cr.bl.entities.casa.Casa;
import ucenfotec.ac.cr.bl.entities.casa.ICasaDAO;
import ucenfotec.ac.cr.bl.entities.casa.MySqlCasaImpl;
import ucenfotec.ac.cr.bl.entities.vecino.IVecinoDAO;
import ucenfotec.ac.cr.bl.entities.vecino.MySqlVecinoImpl;
import ucenfotec.ac.cr.bl.entities.vecino.Vecino;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class VecinoGestor{

    public IVecinoDAO datos;
    public ICasaDAO datosC;

    public VecinoGestor(){
        datos = new MySqlVecinoImpl();
        datosC = new MySqlCasaImpl();
    }

    public String registrarVecino(String nombre, String apellido, String identificacion, String nacimiento, int edad,  String genero, String telefono, String encargado){
        Vecino nuevoVecino = new Vecino(nombre, apellido, identificacion, nacimiento, edad, genero, telefono, encargado);

        return datos.registrarVecino(nuevoVecino);
    }

    public ArrayList<String> listarVecinos(){
        ArrayList<String> infoVecinos = new ArrayList<>();
        for (Vecino vecinoTemp: datos.listarVecinos()){
            infoVecinos.add(vecinoTemp.toString());
        }
        return infoVecinos;
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

    public String crearAlarma(String direccion, String descripcion) {
        ArrayList<Casa> listadoDeCasas = datosC.listarCasas();
        ArrayList<Vecino> listadoDeVecinos = datos.listarVecinos();

        Casa casa = null;
        for (Casa c : listadoDeCasas) {
            if (c.getDireccion().equals(direccion)) {
                casa = c;
                break;
            }
        }

        if (casa == null) {
            return "No se encontró la casa especificada.";
        }

        String encargadoNombre = casa.getEncargado().getNombre();

        Vecino vecinoEncargado = null;
        for (Vecino v : listadoDeVecinos) {
            if (v.getNombre().equals(encargadoNombre)) {
                vecinoEncargado = v;
                break;
            }
        }

        if (vecinoEncargado == null) {
            return "No se encontró el vecino encargado de la casa.";
        }

        try {
            Alarma alarma = new Alarma(casa.getDireccion(), casa.getIdentificacion(), vecinoEncargado.getNombre(), descripcion);
            vecinoEncargado.asociarAlarma(alarma);
            datos.crearAlarma(casa, alarma, vecinoEncargado);

            return "La alarma fue generada con éxito para la casa en " + casa.getDireccion() + " y el encargado es " + encargadoNombre;
        } catch (Exception e) {
            return "Error al generar alarma: " + e.getMessage();
        }
    }
}

