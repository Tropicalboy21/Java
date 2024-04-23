package cr.ac.ucenfotec.bl.entities.hipoteca;

import java.time.LocalDate;

public class Hipoteca {
    private int numHipoteca;
    private LocalDate fechaFinaliza;
    private double monto;
    private String acredor;

    public Hipoteca() {
    }

    public Hipoteca(int numHipoteca, LocalDate fechaFinaliza, double monto, String acredor) {
        this.numHipoteca = numHipoteca;
        this.fechaFinaliza = fechaFinaliza;
        this.monto = monto;
        this.acredor = acredor;
    }

    public int getNumHipoteca() {
        return numHipoteca;
    }

    public void setNumHipoteca(int numHipoteca) {
        this.numHipoteca = numHipoteca;
    }

    public LocalDate getFechaFinaliza() {
        return fechaFinaliza;
    }

    public void setFechaFinaliza(LocalDate fechaFinaliza) {
        this.fechaFinaliza = fechaFinaliza;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getAcredor() {
        return acredor;
    }

    public void setAcredor(String acredor) {
        this.acredor = acredor;
    }

    public String toString() {
        return numHipoteca + "," + fechaFinaliza + "," + monto +"," + acredor;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hipoteca hipoteca = (Hipoteca) o;
        return numHipoteca == hipoteca.numHipoteca;
    }
}
