package cr.ac.ucenfotec.bl.entities.inquilino;

import cr.ac.ucenfotec.bl.entities.residencia.Residencia;

public class    Inquilino {
    private int cedula;
    private String nombre;
    private String profesion;
    private int edad;
    private Residencia residencia; // asociación de 1 a 1

    public Inquilino() {
    }

    public Inquilino(int cedula, String nombre, String profesion, int edad) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.profesion = profesion;
        this.edad = edad;
        this.residencia = new Residencia();
    }

    public Inquilino(int cedula, String nombre, String profesion, int edad, Residencia residencia) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.profesion = profesion;
        this.edad = edad;
        this.residencia = residencia;
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

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void asignarResidencia(Residencia residencia){
        this.residencia = residencia;
    }

    public String toString() {
        return cedula + "," + nombre + "," + profesion +"," + edad +","+residencia;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Inquilino inquilino = (Inquilino) o;
        return cedula == inquilino.cedula;
    }
}
