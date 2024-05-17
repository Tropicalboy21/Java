package cr.ac.ucenfotec.bl.logic;

import cr.ac.ucenfotec.bl.entities.empleado.Empleado;
import cr.ac.ucenfotec.bl.entities.empleado.IEmpleadoDAO;
import cr.ac.ucenfotec.bl.entities.empleado.MySqlEmpleadoImpl;

import java.util.ArrayList;

public class EmpleadoGestor {

    private IEmpleadoDAO datos;

    public EmpleadoGestor(){
        datos = new MySqlEmpleadoImpl();
    }


    public String registrarEmpleado(String nombre, String apellidos, String correo, String contrasenna, String id, String numeroSocial, String fechaNacimiento, String rol, String numeroFijo, String numeroMovil){
        Empleado nuevoEmpleado = new Empleado(nombre,apellidos,correo,contrasenna,id,numeroSocial,fechaNacimiento,rol,numeroFijo,numeroMovil);
        return datos.registrarEmpleado(nuevoEmpleado);
    }

    public ArrayList<String> listarEmpleados(){
        ArrayList<String> infoEmpleados = new ArrayList<>();
        for (Empleado empTemp: datos.listarEmpleados()){
            infoEmpleados.add(empTemp.toString());
        }
        return infoEmpleados;
    }

    public Empleado validarEmpleado(String correo, String contrasenna){
        for(Empleado empleadoTemp: datos.listarEmpleados()){
            if (empleadoTemp.getCorreo().equals(correo) && empleadoTemp.getContrasenna().equals(contrasenna))
                return empleadoTemp;
        }
        return null;
    }


    public String eliminarEmpleado(String nombre){
        Empleado empleadoEliminar = new Empleado();

        return datos.eliminarEmpleado(nombre);
    }
}
