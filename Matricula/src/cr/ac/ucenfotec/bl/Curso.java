package cr.ac.ucenfotec.bl;

import java.util.ArrayList;

public class Curso {

    private String codigo;
    private String nombre;
    private int creditos;
    private double costo;
    private ArrayList<Grupo> listaDeGrupos;

    public Curso(){
        listaDeGrupos = new ArrayList<>();
    }

    public Curso(String codigo, String nombre, int creditos, double costo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.creditos = creditos;
        this.costo = costo;
        this.listaDeGrupos = new ArrayList<>();
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

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public void agregarGrupoACurso(int numGrupo,String codigoGrupo){
        Grupo nuevoGrupo = new Grupo(numGrupo,codigoGrupo);
        listaDeGrupos.add(nuevoGrupo);
    }

    public String toString() {
      String data ="codigo=" + codigo +
                    ", nombre=" + nombre +
                    ", creditos=" + creditos +
                    ", costo=" + costo +"\n";
        for (Grupo grupo:listaDeGrupos) {
            data += grupo.toString() + "\n";
        }
        return data;
    }
}
