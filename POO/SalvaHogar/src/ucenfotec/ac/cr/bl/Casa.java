package ucenfotec.ac.cr.bl;
public class Casa {
    private String direccion;
    private String identificacion;
    private String encargado;


    public Casa(){};
    public Casa(String direccion, String identificacion, String encargado) {
        this.direccion = direccion;
        this.identificacion = identificacion;
        this.encargado = encargado;
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

    @Override
    public String toString() {
        return "Casa" + "\n" +
                "direccion: " + direccion + "\n" +
                "identificacion: " + identificacion + "\n" +
                "Encargado: " + encargado + "\n";
    }
}


