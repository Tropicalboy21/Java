package cr.ac.ucenfotec.bl;

import java.util.ArrayList;

public class Carrera {

    private String codigo;
    private String nombre;
    private boolean esAcreditada;
    private ArrayList<Curso> listaDeCursos;

    public Carrera() {
        listaDeCursos = new ArrayList<>();
    }

    public Carrera(String codigo, String nombre, boolean esAcreditada) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.esAcreditada = esAcreditada;
        this.listaDeCursos = new ArrayList<>();
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

    public void agregarCurso(Curso curso){
        listaDeCursos.add(curso);
    }

    public String toString() {
        String data = "Código    : " + codigo + "\n";
               data+= "Nombre    : " + nombre + "\n";
               data+= "Acreditada: " + esAcreditada + "\n";
               data+= "-------------------------------\n";
        for (Curso cursoTemp:listaDeCursos) {
            data+= cursoTemp.toString() + "\n";
        }
        return data;
    }
}
