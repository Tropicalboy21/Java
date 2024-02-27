package cr.ac.ucenfotec.bl;

import java.time.LocalDate;

public class Profesor {

    private int identificacion;
    private String nombre;
    private LocalDate fechaNacimiento;
    private int edad;
    private String genero;
    private String profesion;

    public Profesor() {
    }

    public Profesor(int identificacion, String nombre, LocalDate fechaNacimiento, int edad, String genero, String profesion) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.edad = edad;
        this.genero = genero;
        this.profesion = profesion;
    }

    public int getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
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

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String toString() {
        return  "identificacion=" + identificacion +
                ", nombre=" + nombre +
                ", fechaNacimiento=" + fechaNacimiento +
                ", edad=" + edad +
                ", genero=" + genero +
                ", profesion=" + profesion;
    }
}
