
import java.util.Arrays;
import java.util.Comparator;

public class test2 {

    static public void calcularPuntajeTotal(String[] paises, int[] puntajesTotal) {
        Integer[] indices = new Integer[puntajesTotal.length];

        // Create an array of indices
        for (int i = 0; i < indices.length; i++) {
            indices[i] = i;
        }

        // Sort indices based on puntajesTotal in descending order
        Arrays.sort(indices, Comparator.comparing(i -> puntajesTotal[i], Comparator.reverseOrder()));

        System.out.printf("\n ");
        System.out.printf("Juegos Olímpicos de Tokio 2020%n");
        System.out.printf("\n Tabla de posiciones %n");
        System.out.printf("\n %-8s  %-8s %n", "Pais", "Puntaje Total");

        // Print countries and values in sorted order
        for (int i : indices) {
            System.out.printf(" %-10s  %-8s %n", paises[i], puntajesTotal[i]);
        }
    }

    public static void main(String[] args) {
        // Example data
        String[] paises = { "Panma", "cuba", "italia", "Canada" };
        int[] puntajesTotal = { 10, 5, 15, 8 };

        // Calculate and print in descending order
        calcularPuntajeTotal(paises, puntajesTotal);
    }
}
