public class Ventas {
    public static double ventaMayor(double arr[]) {

        // Initialize maximum element
        double max = arr[0];

        // Traverse array elements from second and
        // compare every element with current max
        for (int i = 1; i < arr.length; i++)
            if (arr[i] > max)
                max = arr[i];

        return max;
    }

    public static void main(String[] args) {

        double mayorVenta;
        int mes;
        double[] ventas = new double[12];

        for (int i = 0; i < ventas.length; i++) {
            ventas[i] = Utils.leerDoble("\nDigite las ventas del mes " + (i + 1) + ":");
        }

        mayorVenta = ventaMayor(ventas);

        System.out.printf("\nEl mes con mayores ventas fue " + mes + " : ₡" + mayorVenta + " Colones.");
    }
}
