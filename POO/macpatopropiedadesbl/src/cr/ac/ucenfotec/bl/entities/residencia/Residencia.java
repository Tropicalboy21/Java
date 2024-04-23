package cr.ac.ucenfotec.bl.entities.residencia;

import java.util.Objects;

public class Residencia {

    private int idResidencia;
    private String provincia;
    private String canton;
    private String distrito;
    private String barrio;

    public Residencia(){

    }

    public Residencia(int idResidencia, String provincia, String canton, String distrito, String barrio) {
        this.idResidencia = idResidencia;
        this.provincia = provincia;
        this.canton = canton;
        this.distrito = distrito;
        this.barrio = barrio;
    }

    public int getIdResidencia() {
        return idResidencia;
    }

    public void setIdResidencia(int idResidencia) {
        this.idResidencia = idResidencia;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCanton() {
        return canton;
    }

    public void setCanton(String canton) {
        this.canton = canton;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String toString() {
        return idResidencia +"," + provincia + "," + canton + "," + distrito +  "," + barrio;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Residencia that = (Residencia) o;
        return Objects.equals(provincia, that.provincia) && Objects.equals(canton, that.canton) && Objects.equals(distrito, that.distrito);
    }

}
