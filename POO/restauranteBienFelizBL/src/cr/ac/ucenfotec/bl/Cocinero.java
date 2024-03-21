package cr.ac.ucenfotec.bl;

public class Cocinero extends Empleado {
    private String fechaIngreso;
    private String tiempoRestaurante;

    public Cocinero() {
    }

    public Cocinero(String nombre, String apellidos,String correo, String contrasenna, String id, String numeroSocial, String fechaNacimiento, String rol, String numeroFijo, String numeroMovil, String fechaIngreso) {
        super(nombre, apellidos,correo, contrasenna, id,numeroSocial,fechaNacimiento, rol, numeroFijo, numeroMovil);
        this.fechaIngreso = fechaIngreso;
//      this.tiempoRestaurante = tiempoRestaurante;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getTiempoRestaurante() {
        return tiempoRestaurante;
    }

    public void setTiempoRestaurante(String tiempoRestaurante) {
        this.tiempoRestaurante = tiempoRestaurante;
    }


    @Override
    public String toString() {
        return
                "\nCocinero\n" +
                 super.toString() +
                "fechaIngreso: " + fechaIngreso + "\n" +
                "tiempoRestaurante: " + tiempoRestaurante;
    }
}
