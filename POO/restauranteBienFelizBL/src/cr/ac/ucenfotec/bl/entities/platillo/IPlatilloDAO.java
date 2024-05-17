package cr.ac.ucenfotec.bl.entities.platillo;

import java.util.ArrayList;

public interface IPlatilloDAO {
    String registrarPlatillo(Platillo platillo);

    ArrayList<Platillo> listarPlatillos();


}
