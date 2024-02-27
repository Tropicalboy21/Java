package cr.ac.ucenfotec.bl;

public class Grupo {

    private int numero;
    private String codigo;

    public Grupo() {
    }

    public Grupo(int numero, String codigo) {
        this.numero = numero;
        this.codigo = codigo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String toString() {
        return "numero=" + numero + ", codigo=" + codigo;
    }
}
