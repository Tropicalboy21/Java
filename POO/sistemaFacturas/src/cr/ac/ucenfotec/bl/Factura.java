package cr.ac.ucenfotec.bl;

import java.sql.ClientInfoStatus;
import java.util.ArrayList;

public class Factura {

    private int numFactura;
    private String cliente;
    private Fecha fecha; // relación de composición de 1 a 1
    private ArrayList<Linea> lineasFactura;

    public Factura() {
        lineasFactura = new ArrayList<>();
    }

    public Factura(int numFactura, String cliente, int dia, int mes, int anio){
        this.numFactura = numFactura;
        this.cliente = cliente;
        this.fecha = new Fecha(dia,mes,anio);
        this.lineasFactura = new ArrayList<>();
    }

    public int getNumFactura() {
        return numFactura;
    }

    public void setNumFactura(int numFactura) {
        this.numFactura = numFactura;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public void setFecha(int dia, int mes, int anio) {
        this.fecha = new Fecha(dia,mes,anio);
    }

    public void agregarLinea(String codigo, String descripcion, double precio, int cantidad){
        Linea nuevaLinea = new Linea(codigo,descripcion,precio,cantidad);
        lineasFactura.add(nuevaLinea);
    }

    public String toString() {
        String data  = "---------------------------\n";
               data += "N° Factura: " + numFactura + "\n";
               data += "Cliente   : " + cliente + "\n";
               data += "Fecha     : " + fecha + "\n";
               data +="----------------------------\n";

        for (Linea lineaTemp :lineasFactura) {
               data += lineaTemp.getCodigo() + " - " + lineaTemp.getDescripcion() + " - " +
                       lineaTemp.getPrecio() + " - " + lineaTemp.getCantidad() + "\n";
        }
        return data;
    }
}
