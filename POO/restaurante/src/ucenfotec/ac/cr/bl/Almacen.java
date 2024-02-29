package ucenfotec.ac.cr.bl;

import java.util.ArrayList;

public class Almacen {

    private String codigo;
    private ArrayList<Estante> estantes;


    public Almacen() {
        estantes = new ArrayList<>();
    }

    public Almacen(String codigo, ArrayList<Estante> estantes) {
        this.codigo = codigo;
        this.estantes = estantes;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public ArrayList<Estante> getEstantes() {
        return estantes;
    }

    public void setEstantes(ArrayList<Estante> estantes) {
        this.estantes = estantes;
    }

    @Override
    public String toString() {
        return
                "\nAlmacen\n" +
                "codigo: " + codigo + "\n" +
                "estantes: " + estantes;
    }
}
