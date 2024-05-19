package cr.ac.ucenfotec.bl.entities.almacen;

import java.util.ArrayList;

public interface IAlmacenDAO {

    String registrarAlmacen(Almacen almacen);

    ArrayList<Almacen> listarAlmacenes();

    String eliminarAlmacen(String codigo);
}
