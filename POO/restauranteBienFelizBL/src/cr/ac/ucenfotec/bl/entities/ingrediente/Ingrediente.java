package cr.ac.ucenfotec.bl.entities.ingrediente;

public class Ingrediente {
    private String nombre;
    private int cantidad;

    public Ingrediente() {
    }

    public Ingrediente(String nombre, int cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return
                "\nIngrediente\n" +
                "nombre: " + nombre + "\n" +
                "cantidad: " + cantidad;
    }
}
