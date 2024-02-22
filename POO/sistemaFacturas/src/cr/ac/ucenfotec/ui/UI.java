package cr.ac.ucenfotec.ui;

import cr.ac.ucenfotec.bl.Factura;

public class UI {

    public static void main(String[] args) {

        Factura factura1 = new Factura(1001,"Pedro Perez",21,02,2024);
        Factura factura2 = new Factura(1002,"Ana Morales",01,01,2024);

        // agregando lineas a las facturas
        factura1.agregarLinea("P-001","Atún azul",2500,2);
        factura1.agregarLinea("P-002","Pasta dental",1700,1);
        factura2.agregarLinea("P-003","Salsa de tomate",1000,4);

        System.out.println(factura1);
        System.out.println(factura2);
    }

}
