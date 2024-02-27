package cr.ac.ucenfotec.bl;

public class Curso {

    private String codigo;
    private String nombre;
    private int creditos;
    private double costo;

    public Curso() {
    }

    public Curso(String codigo, String nombre, int creditos, double costo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.creditos = creditos;
        this.costo = costo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public String toString() {
        return  "codigo=" + codigo +
                ", nombre=" + nombre +
                ", creditos=" + creditos +
                ", costo=" + costo;
    }
}
