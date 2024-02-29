package ucenfotec.ac.cr.bl;
import  java.util.ArrayList;


public class Platillo {
    private String nombre;
    private ArrayList<Ingrediente> ingredientes;
    private String experto;
    private double costo;

    public Platillo() {
        ingredientes = new ArrayList<>();
    }

    public Platillo(String nombre, ArrayList<Ingrediente> ingredientes, String experto, double costo) {
        this.nombre = nombre;
        this.ingredientes = ingredientes;
        this.experto = experto;
        this.costo = costo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(ArrayList<Ingrediente> ingredientes) {
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
