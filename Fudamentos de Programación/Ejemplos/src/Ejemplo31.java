import java.util.Arrays;

public class Ejemplo31 {
    public static int Mediana(int[] edades) {
        int mediana = 0;
        int calc = 0;

        int n = edades.length;

        calc = (edades[n / 2] + edades[n / 2 - 1]) / 2;

        System.out.println(calc);

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

        System.out.println(Arrays.toString(edades));
        System.out.println(Arrays.toString(compras));

        Mediana(edades);
    }
}
