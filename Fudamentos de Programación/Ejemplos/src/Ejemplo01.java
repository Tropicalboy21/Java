public class Ejemplo01 {
    public static void main(String[] args) {
        String nombreProducto;
        double precioBruto;
        double impuesto;
        double tasaImpuesto;
        double total;

        impuesto = 13;

        nombreProducto = Utils.leerString("Ingrese el nombre del producto:");
        precioBruto = Utils.leerDoble("Ingrese el valor del producto.");

        tasaImpuesto = (precioBruto / 100) * impuesto;

        total = precioBruto + tasaImpuesto;

        System.out.println(nombreProducto + " \nPrecio: " + total);
    }
}