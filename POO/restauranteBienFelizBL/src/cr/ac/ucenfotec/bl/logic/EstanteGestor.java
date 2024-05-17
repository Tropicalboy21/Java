package cr.ac.ucenfotec.bl.logic;

import cr.ac.ucenfotec.bl.entities.estante.Estante;
import cr.ac.ucenfotec.bl.entities.estante.IEstanteDAO;
import cr.ac.ucenfotec.bl.entities.estante.MySqlEstanteImpl;

import java.util.ArrayList;

public class EstanteGestor {

    private IEstanteDAO datos;

    public EstanteGestor() {
        datos = new MySqlEstanteImpl();
    }

    public String registrarEstante(String codigo){
        Estante nuevoEstante = new Estante(codigo);
        return datos.registrarEstante(nuevoEstante);
    }

    public ArrayList<String> listarEstantes(){
        ArrayList<String> infoEstantes = new ArrayList<>();
        for (Estante estanteTemp: datos.listarEstantes()){
            infoEstantes.add(estanteTemp.toString());
        }
        return infoEstantes;
    }

}
