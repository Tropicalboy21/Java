package ucenfotec.ac.cr.bl;

import java.util.ArrayList;

public class Casa {
    private String direccion;
    private String identificacion;
    private ArrayList<Vecino> vecinos;


    public Casa(){
        vecinos = new ArrayList<>();
    };
    public Casa(String direccion, String identificacion) {
        this.direccion = direccion;
        this.identificacion = identificacion;
        this.vecinos = new ArrayList<>();
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

    public void asociarVecino(Vecino vecino){
        vecinos.add(vecino);
    }
    @Override
    public String toString() {
        String data = "Casa" + "\n";
                data+= "direccion: " + direccion + "\n";
                data+= "identificacion: " + identificacion + "\n";
                data+= "-------------------------------\n";
                data+= "       Vecino Encargado        \n";
        for (Vecino vecinoTemp: vecinos) {
                data+= vecinoTemp.toString() + "\n";
        }

        return data;
    }
}


