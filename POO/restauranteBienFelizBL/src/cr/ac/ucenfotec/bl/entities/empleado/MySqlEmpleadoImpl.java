package cr.ac.ucenfotec.bl.entities.empleado;

import cr.ac.ucenfotec.dl.Conector;

import java.sql.ResultSet;
import java.util.ArrayList;


public class MySqlEmpleadoImpl  implements IEmpleadoDAO{

    String sql;

    public String registrarEmpleado(Empleado empleado) {
        sql ="INSERT INTO EMPLEADO (NOMBRE, APELLIDO, CORREO, CONTRASENNA, ID, NUMEROSOCIAL,FECHANACIMIENTO, ROL, NUMEROFIJO, NUMEROMOVIL) VALUES ('"+empleado.getNombre()+"','"+empleado.getApellidos()+"','"+empleado.getCorreo()+"','"+empleado.getContrasenna()+"','"+empleado.getId()+"','"+empleado.getNumeroSocial()+"','"+empleado.getFechaNacimiento()+"','"+empleado.getRol()+"','"+empleado.getNumeroFijo()+"','"+empleado.getNumeroMovil()+"')";
        Conector.getConnector().ejecutarSQL(sql);
        return
                "El emplado " + empleado.getNombre() + ", fue registrado correctamente!";
    }

    public ArrayList<Empleado> listarEmpleados() {
        ArrayList<Empleado> listaEmpleados = new ArrayList<>();

        sql ="SELECT NOMBRE, APELLIDO, CORREO, CONTRASENNA, ID, NUMEROSOCIAL,FECHANACIMIENTO, ROL, NUMEROFIJO, NUMEROMOVIL FROM EMPLEADO";

        try {
            ResultSet rsEmpleado = Conector.getConnector().ejecutarQuery(sql);
            while (rsEmpleado.next()) {
                String nombre = rsEmpleado.getString("NOMBRE");
                String apellidos = rsEmpleado.getString("APELLIDO");
                String correo = rsEmpleado.getString("CORREO");
                String contrasenna = rsEmpleado.getString("CONTRASENNA");
                String id = rsEmpleado.getString("ID");
                String numeroSocial = rsEmpleado.getString("NUMEROSOCIAL");
                String fechaNacimiento = rsEmpleado.getString("FECHANACIMIENTO");
                String rol = rsEmpleado.getString("ROL");
                String numeroFijo = rsEmpleado.getString("NUMEROFIJO");
                String numeroMovil = rsEmpleado.getString("NUMEROMOVIL");
                Empleado EmpleadoEncontrado = new Empleado(nombre,apellidos,correo,contrasenna,id,numeroSocial,fechaNacimiento,rol,numeroFijo,numeroMovil);

                listaEmpleados.add(EmpleadoEncontrado);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaEmpleados;
    }


    public String eliminarEmpleado(String nombre){
        sql =
                "DELETE FROM COCINERO WHERE NOMBRE='"+ nombre+"'";
        Conector.getConnector().ejecutarSQL(sql);
        return
                "El empleado con nombre " + nombre + " fue eliminado del sistema";

    }
}
