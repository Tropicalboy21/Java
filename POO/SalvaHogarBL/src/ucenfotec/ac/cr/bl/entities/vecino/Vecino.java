package ucenfotec.ac.cr.bl.entities.vecino;

import ucenfotec.ac.cr.bl.entities.alarma.Alarma;

import java.util.ArrayList;

public class Vecino {
    private String nombre;
    private String apellido;
    private String identificacion;
    private String nacimiento;
    private int edad;
    private String genero;
    private String telefono;
    private String encargado;
    private ArrayList<Alarma> listaAlarmas;

    public Vecino(){
        listaAlarmas = new ArrayList<>();
    }

    public Vecino(String nombre, String apellido, String identificacion, String nacimiento, int edad,  String genero, String telefono, String encargado) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.identificacion = identificacion;
        this.nacimiento = nacimiento;
        this.edad = edad;
        this.genero = genero;
        this.telefono = telefono;
        this.encargado = encargado;
        this.listaAlarmas = new ArrayList<>();
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

    public String getEncargado() {
        return encargado;
    }

    public void setEncargado(String encargado) {
        this.encargado = encargado;
    }

    public void asociarAlarma(Alarma alarma) {
        listaAlarmas.add(alarma);
    }

    @Override
    public String toString() {
        String data = "\nVecino\n" +
                "nombre: " + nombre + "\n" +
                "apellido: " + apellido + "\n" +
                "identificacion: " + identificacion + "\n" +
                "nacimiento: " + nacimiento + "\n" +
                "edad: " + edad + "\n" +
                "genero: " + genero + "\n" +
                "telefono: " + telefono + "\n" +
                "Encargado: " + encargado + "\n";
        data+= "--------------------------\n";
        data+= "           Alarmas            \n";
        for (Alarma alarmaTemp: listaAlarmas) {
            data+= alarmaTemp.toString() + "\n";
        }


        return data;
    }
}
