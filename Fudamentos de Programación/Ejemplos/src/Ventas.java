public class Ventas {
    public static double ventaMayor(double arr[]) {

        // Initialize maximum element
        double max = arr[0];

        // Traverse array elements from second and
        // compare every element with current max
        for (int i = 1; i < arr.length; i++)
            if (arr[i] >= max)
                max = arr[i];

        return max;
    }

    public static int mesMayor(double[] ventas, double max) {
        for (int i = 0; i < ventas.length; i++) {
            if (max == ventas[i]) {
                return i + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        double mayorVenta;
        String mayorMes;
        int mes;
        String[] meses = { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre",
                "Octubre", "Noviembre", "Diciembre" };

        double[] ventas = new double[12];

        for (int i = 0; i < meses.length; i++) {
            ventas[i] = Utils.leerDoble("\nDigite las ventas del mes " + meses[i + 1] + ":");
        }

        mayorVenta = ventaMayor(ventas);
        mes = mesMayor(ventas, ventaMayor(ventas));
        mayorMes = meses[mes];

        System.out.println("\nEl mes con mayores ventas fue " + mayorMes + " con un total de ₡" + mayorVenta
                + " Colones en ingresos.");
    }
}
