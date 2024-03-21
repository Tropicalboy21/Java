package cr.ac.ucenfotec.bl;

import java.util.ArrayList;

public class CL {
    private ArrayList<Cocinero> cocineros;
    private ArrayList<Pinche> pinches;
    private ArrayList<Empleado> empleados;


    public CL() {cocineros = new ArrayList<>(); pinches = new ArrayList<>(); empleados = new ArrayList<>();}

    public String registrarEmpleado(String nombre, String apellidos, String correo, String contrasenna, String id, String numeroSocial, String fechaNacimiento, String rol, String numeroFijo, String numeroMovil){
        Empleado nuevoEmpleado = new Empleado(nombre,apellidos,correo,contrasenna,id,numeroSocial,fechaNacimiento,rol,numeroFijo,numeroMovil);
        empleados.add(nuevoEmpleado);
        return "El empleado fue agregado con exito";
    }

    public String registrarCocinero(String nombre, String apellidos,String correo, String contrasenna, String id, String numeroSocial, String fechaNacimiento, String rol, String numeroFijo, String numeroMovil, String fechaIngreso){
        Cocinero nuevoCocinero = new Cocinero(nombre,apellidos,correo,contrasenna,id,numeroSocial,fechaNacimiento,rol,numeroFijo,numeroMovil,fechaIngreso);
        cocineros.add(nuevoCocinero);
        return
                "El cocinero fue agregado con exito";
    }

    public String registrarPinche(String nombre, String apellidos,String correo, String contrasenna, String id, String numeroSocial, String fechaNacimiento,String rol, String numeroFijo, String numeroMovil, String cocineroEncargado){
        Pinche nuevoPinche = new Pinche(nombre,apellidos,correo,contrasenna,id,numeroSocial,fechaNacimiento,rol,numeroFijo,numeroMovil,cocineroEncargado);
        pinches.add(nuevoPinche);
        return
                "El cocinero fue agregado con exito";
    }

    public ArrayList<String> listarEmpleados(){
        ArrayList<String> infoEmpleados = new ArrayList<>();
        for (Empleado empTemp: empleados){
            infoEmpleados.add(empTemp.toString());
        }
        return infoEmpleados;
    }

    public ArrayList<String> listarCocinero(){
        ArrayList<String> infoCocineros = new ArrayList<>();
        for (Cocinero cocineroTemp: cocineros){
            infoCocineros.add(cocineroTemp.toString());
        }
        return infoCocineros;
    }

    public ArrayList<String> listarPinche(){
        ArrayList<String> infoPinches = new ArrayList<>();
        for (Pinche pincheTemp: pinches){
            infoPinches.add(pincheTemp.toString());
        }
        return infoPinches;
    }

    public Cocinero validarCocinero(String correo, String contrasenna){
        for(Cocinero cocineroTemp: cocineros){
            if (cocineroTemp.getCorreo().equals(correo) && cocineroTemp.getContrasenna().equals(contrasenna))
               return cocineroTemp;
        }
        return null;
    }

    public Pinche validarPinche(String correo, String contrasenna){
        for(Pinche pincheTemp: pinches){
            if (pincheTemp.getCorreo().equals(correo) && pincheTemp.getContrasenna().equals(contrasenna))
                return pincheTemp;
        }
        return null;
    }

    public Empleado validarEmpleado(String correo, String contrasenna){
        for(Empleado empleadoTemp: empleados){
            if (empleadoTemp.getCorreo().equals(correo) && empleadoTemp.getContrasenna().equals(contrasenna))
                return empleadoTemp;
        }
        return null;
    }


}
