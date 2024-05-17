package cr.ac.ucenfotec.bl.entities.platillo;
import  java.util.ArrayList;


public class Platillo {
    private String nombre;
    private ArrayList<String> ingredientes;
    private String experto;
    private double costo;

    public Platillo() {
        ingredientes = new ArrayList<>();
    }

    public Platillo(String nombre, String experto, double costo) {
        this.nombre = nombre;
        this.ingredientes = new ArrayList<>();
        this.experto = experto;
        this.costo = costo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<String> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(ArrayList<String> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String getExperto() {
        return experto;
    }

    public void setExperto(String experto) {
        this.experto = experto;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    @Override
    public String toString() {
        return
                "\nPlatillo\n" +
                "nombre='" + nombre + "\n" +
                "ingredientes=" + ingredientes +  "\n" +
                "experto='" + experto + "\n" +
                "costo=" + costo;
    }
}
