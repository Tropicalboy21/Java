public class Ejemplo25 {
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
    // public static int mesMayor(double[] ventas) {
    // int mayor = 0;
    // double ciclo=0;
    // for (int i = 0; i < ventas.length; i++) {
    // if (i==0 && ventas[i]>=ciclo) {
    // ciclo=ventas[i];
    // mayor=1;

    // } else {
    // if (ventas[i]>=ciclo) {
    // ciclo=ventas[i];
    // mayor=i+1;
    // }
    // }

    // }

    // return mayor;
    // }

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
