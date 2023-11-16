public class Ejemplo23 {

    public static double ventaMayor(double[] ventas) {
        double mayor = 0;
        // for each
        for (int i = 0; i < ventas.length; i++) {
            if (ventas[i] >= mayor) {
                mayor = ventas[i];
            }

        }
        return mayor;
    }

    public static int mesMayor(double[] ventas, double mayor) {
        for (int i = 0; i < ventas.length; i++) {
            if (mayor == ventas[i]) {
                return i + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        double mayorVenta;
        int mes;
        double[] ventas = new double[12];

        for (int i = 0; i < ventas.length; i++) {
            ventas[i] = Utils.leerDoble("Cuanto se vendio en colones en el mes " + (i + 1) + " ");
        }
        mayorVenta = ventaMayor(ventas);
        mes = mesMayor(ventas, ventaMayor(ventas));
        System.out.println(
                "El mes con mayor ventas fue el nunero " + mes + " con un valor de " + mayorVenta + " colones.");
    }
}
