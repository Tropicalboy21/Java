package cr.ac.ucenfotec.bl;

import java.time.LocalDate;

public class Matricula {

    private LocalDate fecha;
    private double costoTotal;

    public Matricula() {
    }

    public Matricula(LocalDate fecha, double costoTotal) {
        this.fecha = fecha;
        this.costoTotal = costoTotal;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
    }

    public String toString() {
        return "fecha=" + fecha + ", costoTotal=" + costoTotal;
    }
}
