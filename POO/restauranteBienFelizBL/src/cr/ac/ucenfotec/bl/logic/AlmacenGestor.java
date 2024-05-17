package cr.ac.ucenfotec.bl.logic;

import cr.ac.ucenfotec.bl.entities.almacen.Almacen;
import cr.ac.ucenfotec.bl.entities.almacen.IAlmacenDAO;
import cr.ac.ucenfotec.bl.entities.almacen.MySqlAlmacenImpl;

import java.util.ArrayList;

public class AlmacenGestor {

    private IAlmacenDAO datos;

    public AlmacenGestor(){
        datos = new MySqlAlmacenImpl();
    }

    public String registrarAlmacen(String codigo){
        Almacen nuevoAlmacen = new Almacen(codigo);
        return datos.registrarAlmacen(nuevoAlmacen);
    }

    public ArrayList<String> listarAlmacenes(){
        ArrayList<String> infoAlmacenes = new ArrayList<>();
        for(Almacen almacenTemp: datos.listarAlmacenes()){
            infoAlmacenes.add(almacenTemp.toString());
        }
        return infoAlmacenes;
    }
}
