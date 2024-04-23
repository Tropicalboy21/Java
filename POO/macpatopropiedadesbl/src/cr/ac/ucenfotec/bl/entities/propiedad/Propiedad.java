package cr.ac.ucenfotec.bl.entities.propiedad;

import cr.ac.ucenfotec.bl.entities.hipoteca.Hipoteca;
import cr.ac.ucenfotec.bl.entities.inquilino.Inquilino;

import java.time.LocalDate;
import java.util.ArrayList;

public class Propiedad {
    private int numFinca;
    private String nombre;
    private int cuartos;
    private String provincia;
    private double costoMensual;
    private ArrayList<Inquilino> listaInquilinos; //Agregación  de 1 a 1....*
    private ArrayList<Hipoteca> listaHipotecas;   //Composición de 1 a 1....*

    public Propiedad() {
        listaInquilinos = new ArrayList<>();
        listaHipotecas  = new ArrayList<>();
    }

    public Propiedad(int numFinca, String nombre, int cuartos, String provincia, double costoMensual) {
        this.numFinca = numFinca;
        this.nombre = nombre;
        this.cuartos = cuartos;
        this.provincia = provincia;
        this.costoMensual = costoMensual;
        this.listaInquilinos = new ArrayList<>();
        this.listaHipotecas  = new ArrayList<>();
    }

    public int getNumFinca() {
        return numFinca;
    }

    public void setNumFinca(int numFinca) {
        this.numFinca = numFinca;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCuartos() {
        return cuartos;
    }

    public void setCuartos(int cuartos) {
        this.cuartos = cuartos;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public double getCostoMensual() {
        return costoMensual;
    }

    public void setCostoMensual(double costoMensual) {
        this.costoMensual = costoMensual;
    }

    //Agregación de 1 a 1....*
    public void agregarInquilino(Inquilino inquilino){
        listaInquilinos.add(inquilino);
    }

    //Composición de 1 a 1....*
    public void asignarHipoteca(int numHipoteca, LocalDate fechaFinaliza, double monto, String acredor){
        Hipoteca nuevaHipoteca = new Hipoteca(numHipoteca,fechaFinaliza,monto,acredor);
        listaHipotecas.add(nuevaHipoteca);
    }

    public String toString() {
        String info  = numFinca +"," + nombre +  "," + cuartos + "," + provincia + "," + costoMensual+"\n";
               info += "*** Inquilinos ***\n";
        for (Inquilino inquilino:listaInquilinos) {
            info+= inquilino.toString() + "\n";
        }
        info += "*** Hipotecas ***\n";
        for(Hipoteca hipoteca:listaHipotecas){
            info += hipoteca.toString() + "\n";
        }
        return info;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Propiedad propiedad = (Propiedad) o;
        return numFinca == propiedad.numFinca;
    }
}
