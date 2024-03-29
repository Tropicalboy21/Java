package cr.ac.ucenfotec.bl;

public class Empleado {

   private int cedula;
   private String nombre;

    public Empleado() {
    }

    public Empleado(int cedula, String nombre) {
        this.cedula = cedula;
        this.nombre = nombre;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String toString() {
        return cedula + "," + nombre;
    }
}
