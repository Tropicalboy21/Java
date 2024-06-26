package cr.ac.ucenfotec.bl.entities.estante;

import cr.ac.ucenfotec.bl.entities.ingrediente.Ingrediente;

import java.util.ArrayList;

public class Estante {

    private String codigo;

    private ArrayList<Ingrediente> ingredientes;

    public Estante() {
        ingredientes = new ArrayList<>();
    }

    public Estante(String codigo) {
        this.codigo = codigo;
        this.ingredientes = new ArrayList<>();
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

