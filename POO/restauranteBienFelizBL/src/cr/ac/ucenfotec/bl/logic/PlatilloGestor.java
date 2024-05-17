package cr.ac.ucenfotec.bl.logic;

import cr.ac.ucenfotec.bl.entities.ingrediente.IIngredienteDAO;
import cr.ac.ucenfotec.bl.entities.ingrediente.Ingrediente;
import cr.ac.ucenfotec.bl.entities.ingrediente.MySqlIngredienteImpl;
import cr.ac.ucenfotec.bl.entities.platillo.IPlatilloDAO;
import cr.ac.ucenfotec.bl.entities.platillo.MySqlPlatilloImpl;
import cr.ac.ucenfotec.bl.entities.platillo.Platillo;

import java.util.ArrayList;

public class PlatilloGestor {
        private IPlatilloDAO datos;

    public PlatilloGestor() {
        datos = new MySqlPlatilloImpl();
    }

    public String registrarPlatillo(String nombre, String experto, double costo){
        Platillo nuevoplatillo = new Platillo(nombre, experto, costo);
        return datos.registrarPlatillo(nuevoplatillo);
    }

    public ArrayList<String> listarPlatillos(){
        ArrayList<String> infoPlatillos = new ArrayList<>();
        for (Platillo platilloTemp: datos.listarPlatillos()) {
            infoPlatillos.add(platilloTemp.toString());
        }
        return infoPlatillos;
        }
}
