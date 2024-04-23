package ucenfotec.ac.cr.bl.entities.casa;

import ucenfotec.ac.cr.bl.entities.vecino.Vecino;

import java.util.ArrayList;

public class Casa {
    private String direccion;
    private String identificacion;
    private ArrayList<Vecino> vecinos;
    private Vecino encargado;


    public Casa(){
        vecinos = new ArrayList<>();
    };
    public Casa(String direccion, String identificacion) {
        this.direccion = direccion;
        this.identificacion = identificacion;
        this.vecinos = new ArrayList<>();
        this.encargado = new Vecino();
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

    public ArrayList<Vecino> getVecinos() {
        return vecinos;
    }

    public void asignarEncargado(Vecino vecino){
        this.encargado = vecino;
    }

    public Vecino getEncargado() {
        return encargado;
    }

    @Override
    public String toString() {
        String data = "Casa" + "\n";
        data+= "direccion: " + direccion + "\n";
        data+= "identificacion: " + identificacion + "\n";
        data+= "encargado: " + encargado.getNombre() + "\n";
        data+= "-------------------------------\n";
        data+= "            Vecinos            \n";
        for (Vecino vecinoTemp: vecinos) {
            data+= vecinoTemp.toString() + "\n";
        }

        return data;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Casa casa = (Casa) o;
        return direccion.equals(casa.direccion);
    }
}
