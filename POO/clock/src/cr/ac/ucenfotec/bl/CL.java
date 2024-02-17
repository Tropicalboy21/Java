package cr.ac.ucenfotec.bl;

import java.util.ArrayList;

public class CL {
    private ArrayList<Empleado> empleados;

    public  CL(){
        empleados = new ArrayList<>();
    }

    public String registrarEmpleado(String nombreIn,String identificacionIn, String generoIn, String edadIn, String puestoIn){
        Empleado nuevoEmpleado = new Empleado(nombreIn, identificacionIn, generoIn, edadIn, puestoIn);

        empleados.add(nuevoEmpleado);

        return "El empleaado " + nuevoEmpleado.getNombre() + " fue añadido con exito";

    };

    public ArrayList<String> listarEmpleados(){
        ArrayList<String> infoEmpleados = new ArrayList<>();
        for (Empleado empleadoTemp:empleados){
            infoEmpleados.add(empleadoTemp.toString());
        }
        return infoEmpleados;
    }

    public String buscarEmpleado(String identificacion){
        Empleado empleadoBuscado = buscarEmpleadoPorId(identificacion);
        if(empleadoBuscado!=null)
            return empleadoBuscado.toString();
        else
            return  "El empleado con la identificación "+identificacion+", no existe en el sistema!";
    }

    private Empleado buscarEmpleadoPorId(String identificacion){
        for(Empleado empleado:empleados){
            if(empleado.getIdentificacion().equals(identificacion))
                return empleado;
        }
        return null;
    }

}
