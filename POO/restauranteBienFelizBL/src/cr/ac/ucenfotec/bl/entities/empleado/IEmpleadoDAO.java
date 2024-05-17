package cr.ac.ucenfotec.bl.entities.empleado;

import java.util.ArrayList;

public interface IEmpleadoDAO {
    String registrarEmpleado(Empleado empleado);
    ArrayList<Empleado> listarEmpleados();

    String eliminarEmpleado(String nombre);

}
