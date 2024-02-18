package ucenfotec.ac.cr.bl;

public class Vecino {
    private String nombre;
    private String apellido;
    private String identificacion;
    private String nacimiento;
    private int edad;
    private String genero;
    private String telefono;
    private boolean encargado;

    public Vecino(){}

    public Vecino(String nombre, String apellido, String identificacion, String nacimiento, int edad,  String genero, String telefono, boolean encargado) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.identificacion = identificacion;
        this.nacimiento = nacimiento;
        this.edad = edad;
        this.genero = genero;
        this.telefono = telefono;
        this.encargado = encargado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(String nacimiento) {
        this.nacimiento = nacimiento;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public boolean getEncargado() {
        return encargado;
    }

    public void setEncargado(boolean encargado) {
        this.encargado = encargado;
    }

    @Override
    public String toString() {
        return "\nVecino\n" +
                "nombre: " + nombre + "\n" +
                "apellido: " + apellido + "\n" +
                "identificacion: " + identificacion + "\n" +
                "nacimiento: " + nacimiento + "\n" +
                "edad: " + edad + "\n" +
                "genero: " + genero + "\n" +
                "telefono: " + telefono + "\n" +
                "Encargado: " + encargado + "\n";
    }
}

