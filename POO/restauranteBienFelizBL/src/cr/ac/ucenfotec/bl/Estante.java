package cr.ac.ucenfotec.bl;

import java.util.ArrayList;

public class Estante {

    private String codigo;

    private ArrayList<Ingrediente> ingredientes;
    private Almacen almacen;


    public Estante() {
        ingredientes = new ArrayList<>();
    }

    public Estante(String codigo, ArrayList<Ingrediente> ingredientes, Almacen almacen) {
        this.codigo = codigo;
        this.ingredientes = ingredientes;
        this.almacen = almacen;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public ArrayList<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(ArrayList<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public Almacen getAlmacen() {
        return almacen;
    }

    public void setAlmacen(Almacen almacen) {
        this.almacen = almacen;
    }

    @Override
    public String toString() {
        return
                "\nEstante\n" +
                "codigo: " + codigo + "\n" +
                "ingredientes: " + ingredientes + "\n" +
                "almacen: " + almacen;
    }
}
