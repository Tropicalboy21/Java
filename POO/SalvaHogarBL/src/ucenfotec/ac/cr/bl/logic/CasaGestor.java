package ucenfotec.ac.cr.bl.logic;

import ucenfotec.ac.cr.bl.entities.casa.Casa;
import ucenfotec.ac.cr.bl.entities.casa.ICasaDAO;
import ucenfotec.ac.cr.bl.entities.casa.MySqlCasaImpl;
import ucenfotec.ac.cr.bl.entities.vecino.IVecinoDAO;
import ucenfotec.ac.cr.bl.entities.vecino.MySqlVecinoImpl;
import ucenfotec.ac.cr.bl.entities.vecino.Vecino;

import java.util.ArrayList;

public class CasaGestor  {

    private ICasaDAO datos;
    private IVecinoDAO datosV;
    public CasaGestor(){
        datos = new MySqlCasaImpl();
        datosV = new MySqlVecinoImpl();
    }

    public String registrarCasa(String direccion, String identificacion){
        Casa nuevaCasa = new Casa(direccion,identificacion);
        return datos.registrarCasa(nuevaCasa);
    }
    public ArrayList<String> listarCasas(){
        ArrayList<String> infoCasas = new ArrayList<>();
        for (Casa casaTemp: datos.listarCasas()){
            infoCasas.add(casaTemp.toString());
        }
        return infoCasas;
    }

    public String agregarVecinoCasa(String direccion, String nombre) {
        ArrayList<Casa> listadoDeCasas = datos.listarCasas();
        ArrayList<Vecino> listadoDeVecinos = datosV.listarVecinos();

        // Encontrar casa por direccion
        Casa casa = null;
        for (Casa c : listadoDeCasas) {
            if (c.getDireccion().equals(direccion)) {
                casa = c;
                break;
            }
        }

        // Encontrar vecino por nombre
        Vecino vecino = null;
        for (Vecino v : listadoDeVecinos) {
            if (v.getNombre().equals(nombre)) {
                vecino = v;
                break;
            }
        }

        // Si existen agregar vecino a casa
        if (casa != null && vecino != null) {
            casa.asociarVecino(vecino);
            for (int i = 0; i < listadoDeCasas.size(); i++) {
                if (listadoDeCasas.get(i).getDireccion().equals(casa.getDireccion())) {
                    listadoDeCasas.set(i, casa); // Update the existing casa object in the list
                    break;
                }
            }
            String mensaje = datos.agregarVecinoCasa(casa, vecino);
            return mensaje;
        } else {
            return "No se encontró la casa o el vecino especificado.";
        }
    }

    public String asignarEncargadoCasa(String direccion, String nombre) {
        ArrayList<Casa> listadoDeCasas = datos.listarCasas();
        ArrayList<Vecino> listadoDeVecinos = datosV.listarVecinos();

        Casa casa = null;
        for (Casa c : listadoDeCasas) {
            if (c.getDireccion().equals(direccion)) {
                casa = c;
                break;
            }
        }

        Vecino vecino = null;
        for (Vecino v : listadoDeVecinos) {
            if (v.getNombre().equals(nombre)) {
                vecino = v;
                break;
            }
        }

        if (casa != null && vecino != null) {
            try {
                casa.asignarEncargado(vecino);

                datos.asignarEncargadoCasa(casa, vecino);

                return "El vecino " + vecino.getNombre() + " fue agregado como encargado a la casa en " + casa.getDireccion();
            } catch (Exception e) {
                return "Error al asignar encargado: " + e.getMessage();
            }
        } else {
            return "No se encontró la casa o el vecino especificado.";
        }
    }
}
