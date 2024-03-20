package cr.ac.ucenfotec.bl;

public class Ingrediente {
    private String nombre;
    private String estante;
    private String almacen;
    private int cantidad;

    public Ingrediente() {

    }

    public Ingrediente(String nombre, String estante, String almacen, int cantidad) {
        this.nombre = nombre;
        this.estante = estante;
        this.almacen = almacen;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstante() {
        return estante;
    }

    public void setEstante(String estante) {
        this.estante = estante;
    }

    public String getAlmacen() {
        return almacen;
    }

    public void setAlmacen(String almacen) {
        this.almacen = almacen;
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
                "estante: " + estante + "\n" +
                "almacen: " + almacen + "\n" +
                "cantidad: " + cantidad;
    }
}
