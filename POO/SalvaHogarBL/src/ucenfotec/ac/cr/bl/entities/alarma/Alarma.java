package ucenfotec.ac.cr.bl.entities.alarma;

import ucenfotec.ac.cr.bl.entities.vecino.Vecino;

public class Alarma {
    private String direccion;
    private String identificacion;
    private String encargado;

    private String descripcion;

    public Alarma() {
    }

    public Alarma(String direccion, String identificacion, String encargado, String descripcion) {
        this.direccion = direccion;
        this.identificacion = identificacion;
        this.encargado = encargado;
        this.descripcion = descripcion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getEncargado() {
        return encargado;
    }

    public void setEncargado(String encargado) {
        this.encargado = encargado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        String data = "Alarma" + "\n";
                data += "direccion: " + direccion+"\n";
                data += "identificacion: " + identificacion+"\n";
                data += "encargado: " + encargado+"\n";
                data += "descripcion: " + descripcion+"\n";

        return  data;
    }
}
