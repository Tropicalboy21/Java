import java.util.Arrays;

public class Ejemplo31 {
    public static double medianaReales(double[] compras) {
        double mediana = 0;

        int n = compras.length;

        mediana = (compras[n / 2] + compras[n / 2 - 1]) / 2;

        return mediana;
    }

    public static int medianaEnteros(int[] edades) {
        int mediana = 0;

        int n = edades.length;

        mediana = (edades[n / 2] + edades[n / 2 - 1]) / 2;

        return mediana;
    }

    public static void ordenar(int[] edades, double[] compras) {
        Arrays.sort(edades);
        Arrays.sort(compras);
    }

    public static void main(String[] args) {
        int[] edades = { 25, 45, 32, 82, 18, 70, 65, 46, 17, 20 };
        double[] compras = { 125.0, 125.81, 450.2, 125.2, 140.9, 250.4, 380.5, 145.11, 780.0, 450.4 };

        ordenar(edades, compras);

        System.out.println("\n" + Arrays.toString(edades));
        System.out.println("\n" + Arrays.toString(compras));

        System.out.println("\n" + medianaEnteros(edades));
        System.out.println("\n" + medianaReales(compras));
    }
}
