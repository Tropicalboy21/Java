package ucenfotec.ac.cr.bl;

public class Camiseta {
    private int id;
    private String color;
    private char tamanno;
    private String descripcion;
    private double precio;

    Camiseta(){};

    Camiseta(int id, String color, char tamanno, String descripcion, double precio){
        this.id = id;
        this.color = color;
        this.tamanno = tamanno;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public char getTamanno() {
        return tamanno;
    }

    public void setTamanno(char tamanno) {
        this.tamanno = tamanno;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Camiseta{" +
                "id=" + id +
                ", color='" + color + '\'' +
                ", tamanno=" + tamanno +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                '}';
    }
}
