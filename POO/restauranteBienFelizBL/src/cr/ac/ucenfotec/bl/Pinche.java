package cr.ac.ucenfotec.bl;

public class Pinche extends Empleado{
    private String cocineroEncargado;


    public Pinche() {}

    public Pinche(String nombre, String apellidos, String id, String numeroSocial, String fechaNacimiento, String rol, String numeroFijo, String numeroMovil, String cocineroEncargado) {
        super(nombre, apellidos, id, numeroSocial, fechaNacimiento, rol, numeroFijo, numeroMovil);
        this.cocineroEncargado = cocineroEncargado;
    }

    public String getCocineroEncargado() {
        return cocineroEncargado;
    }

    public void setCocineroEncargado(String cocineroEncargado) {
        this.cocineroEncargado = cocineroEncargado;
    }

    @Override
    public String toString() {
        return
                "\nPinche\n" +
                super.toString() +
                "cocineroEncargado: " + cocineroEncargado;
    }
}
