package cr.ac.ucenfotec.bl;

public class Carrera {

    private String codigo;
    private String nombre;
    private boolean esAcreditada;

    public Carrera() {
    }

    public Carrera(String codigo, String nombre, boolean esAcreditada) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.esAcreditada = esAcreditada;
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

    public boolean isEsAcreditada() {
        return esAcreditada;
    }

    public void setEsAcreditada(boolean esAcreditada) {
        this.esAcreditada = esAcreditada;
    }

    public String toString() {
        return "codigo=" + codigo +
                ", nombre=" + nombre +
                ", esAcreditada=" + esAcreditada;
    }
}
