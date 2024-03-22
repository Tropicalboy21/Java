package cr.ac.ucenfotec.bl;

import java.util.ArrayList;

public class Estante {

    private String codigo;

    private ArrayList<Ingrediente> ingredientes;

    public Estante() {
        ingredientes = new ArrayList<>();
    }

    public Estante(String codigo, ArrayList<Ingrediente> ingredientes) {
        this.codigo = codigo;
        this.ingredientes = ingredientes;
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

    public void setIngredientes(Ingrediente ingrediente) {
        ingredientes.add(ingrediente);
    }

    @Override
    public String toString() {
        return
                "\nEstante\n" +
                "codigo: " + codigo + "\n" +
                "ingredientes: " + ingredientes + "\n";
    }
}

