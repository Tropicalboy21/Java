package ucenfotec.ac.cr.bl;

public class Cocinero {
    private String nombre;
    private String apellidos;
    private String id;
    private String numeroSocial;
    private String fechaNacimiento;
    private String fechaIngreso;
    private String tiempoRestaurante;
    private String numeroFijo;
    private String numeroMovil;

    public Cocinero() {
    }

    public Cocinero(String nombre, String apellidos, String id, String numeroSocial, String fechaNacimiento, String fechaIngreso, String numeroFijo, String numeroMovil) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.id = id;
        this.numeroSocial = numeroSocial;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaIngreso = fechaIngreso;
//        this.tiempoRestaurante = tiempoRestaurante;
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
        return
                "\nCocinero\n" +
                "nombre: " + nombre + "\n" +
                "apellidos: " + apellidos + "\n" +
                "id: " + id + "\n" +
                "numeroSocial: " + numeroSocial + "\n" +
                "fechaNacimiento: " + fechaNacimiento + "\n" +
                "fechaIngreso: " + fechaIngreso + "\n" +
                "tiempoRestaurante: " + tiempoRestaurante + "\n" +
                "numeroFijo: " + numeroFijo + "\n" +
                "numeroMovil: " + numeroMovil;
    }
}
