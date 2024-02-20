package cr.ac.ucenfotec.bl;


public class Computadora {
    private int numero;
    private String serie;
    private String marca;
    private Empleado responsable;// relación de asociación

    public Computadora() {
    }

    public Computadora(int numero, String serie, String marca) {
        this.numero = numero;
        this.serie = serie;
        this.marca = marca;
    }

    public Computadora(int numero, String serie, String marca, Empleado responsable) {
        this.numero = numero;
        this.serie = serie;
        this.marca = marca;
        this.responsable = responsable;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Empleado getResponsable() {
        return responsable;
    }

    public void setResponsable(Empleado responsable) {
        this.responsable = responsable;
    }

    public String getNombreResponsable(){
        return responsable.getNombre();
    }

    public String toString() {
        return numero + "," + serie +"," + marca +","+ responsable;
    }
}
