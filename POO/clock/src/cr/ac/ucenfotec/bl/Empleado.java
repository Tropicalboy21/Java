package cr.ac.ucenfotec.bl;

public class Empleado {
    private String nombre;
    private String identificacion;
    private String genero;
    private String edad;
    private String puesto;

    public Empleado( String nombre, String identificacion, String genero, String edad, String puesto) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.genero = genero;
        this.edad = edad;
        this.puesto = puesto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    @Override
    public String toString() {
        return "cr.ac.ucenfotec.bl.Empleado\n" +
                "nombre: " + nombre + "\n" +
                "identificacion: " + identificacion + "\n" +
                "genero: " + genero + "\n" +
                "edad: " + edad + "\n" +
                "puesto: " + puesto + "\n";
    }
}


