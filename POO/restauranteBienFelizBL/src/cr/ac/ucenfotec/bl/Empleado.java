package cr.ac.ucenfotec.bl;

public class Empleado {

    private String nombre;
    private String apellidos;
    private String id;
    private String numeroSocial;
    private String fechaNacimiento;
    private String rol;
    private String numeroFijo;
    private String numeroMovil;

    public Empleado() {}
    public Empleado(String nombre, String apellidos, String id, String numeroSocial, String fechaNacimiento, String rol, String numeroFijo, String numeroMovil) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.id = id;
        this.numeroSocial = numeroSocial;
        this.fechaNacimiento = fechaNacimiento;
        this.rol = rol;
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

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
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
                "\nEmpleado\n" +
                "nombre: " + nombre + "\n" +
                "apellidos: " + apellidos + "\n" +
                "id: " + id + "\n" +
                "numeroSocial: " + numeroSocial + "\n" +
                "fechaNacimiento: " + fechaNacimiento + "\n" +
                "rol: " + rol + "\n" +
                "numeroFijo: " + numeroFijo + "\n" +
                "numeroMovil: " + numeroMovil + "\n";
    }
}
