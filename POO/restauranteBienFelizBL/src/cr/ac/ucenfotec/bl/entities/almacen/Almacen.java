package cr.ac.ucenfotec.bl.entities.almacen;

import cr.ac.ucenfotec.bl.entities.estante.Estante;

import java.util.ArrayList;

public class Almacen {

    private String codigo;

    private ArrayList<Estante> estantes;


    public Almacen() {
        estantes = new ArrayList<>();
    }

    public Almacen(String codigo) {
        this.codigo = codigo;
        this.estantes = new ArrayList<>();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void agregarEstanteAlmacen (Estante estante) {
        estantes.add(estante);
    }

    public ArrayList<Estante> getEstantes() {
       return estantes;
    }

    @Override
    public String toString() {
        return
                "\nAlmacen\n" +
                "codigo: " + codigo + "\n" +
                "estantes: " + estantes;
    }
}
