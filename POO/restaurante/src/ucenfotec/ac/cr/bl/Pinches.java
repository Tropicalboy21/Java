package ucenfotec.ac.cr.bl;

public class Pinches {
    private String nombre;
    private String apellidos;
    private String id;
    private String numeroSocial;
    private String fechaNacimiento;
    private String cocineroEncargado;
    private String numeroFijo;
    private String numeroMovil;

    public Pinches() {}

    public Pinches(String nombre, String apellidos, String id, String numeroSocial, String fechaNacimiento, String cocineroEncargado, String numeroFijo, String numeroMovil) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.id = id;
        this.numeroSocial = numeroSocial;
        this.fechaNacimiento = fechaNacimiento;
        this.cocineroEncargado = cocineroEncargado;
        this.numeroFijo = numeroFijo;
        this.numeroMovil = numeroMovil;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumeroSocial() {
        return numeroSocial;
    }

    public void setNumeroSocial(String numeroSocial) {
        this.numeroSocial = numeroSocial;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCocineroEncargado() {
        return cocineroEncargado;
    }

    public void setCocineroEncargado(String cocineroEncargado) {
        this.cocineroEncargado = cocineroEncargado;
    }

    public String getNumeroFijo() {
        return numeroFijo;
    }

    public void setNumeroFijo(String numeroFijo) {
        this.numeroFijo = numeroFijo;
    }

    public String getNumeroMovil() {
        return numeroMovil;
    }

    public void setNumeroMovil(String numeroMovil) {
        this.numeroMovil = numeroMovil;
    }

    @Override
    public String toString() {
        return "Pinches{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", id='" + id + '\'' +
                ", numeroSocial='" + numeroSocial + '\'' +
                ", fechaNacimiento='" + fechaNacimiento + '\'' +
                ", cocineroEncargado='" + cocineroEncargado + '\'' +
                ", numeroFijo='" + numeroFijo + '\'' +
                ", numeroMovil='" + numeroMovil + '\'' +
                '}';
    }
}
