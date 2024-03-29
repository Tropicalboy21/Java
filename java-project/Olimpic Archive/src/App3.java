import java.util.Arrays;
import java.util.Comparator;

public class App3 {

    static public void tablaPuntajes(String[] paises, int[] puntajesTotal) {

        int l = paises.length;

        System.out.printf("\n ");
        System.out.printf("Juegos Olímpicos de Tokio 2020%n");
        System.out.printf("\n Tabla de posiciones %n");
        System.out.printf("\n %-8s  %-8s %n", "Pais", "Puntaje Total");

        for (int i = 0; i < l; i++) {
            System.out.printf(" %-10s  %-8s %n", paises[i], puntajesTotal[i]);
        }

    }

    static public void medalleroInformativo(String[] paises, int[] oros, int[] platas, int[] bronces) {
        int l = oros.length;

        System.out.printf("\n ");
        System.out.printf("Juegos Olímpicos de Tokio 2020%n");
        System.out.printf("\n Medallero informativo %n");
        System.out.printf("\n %-10s  %-8s  %-8s  %-8s %n", "Pais", "Medallas de oro", "Medallas de plata",
                "Medallas de bronce");

        for (int i = 0; i < l; i++) {
            System.out.printf(" %-10s  %-8s %-8s  %-8s %n", paises[i], oros[i], platas[i], bronces[i]);
        }

    }

    static public void tablaPosiciones(String[] paises, int[] puntajesTotal) {
        int l = puntajesTotal.length;
        Integer[] indices = new Integer[l];

        for (int i = 0; i < l; i++) {
            indices[i] = i;
        }

        Arrays.sort(indices, Comparator.comparing(i -> puntajesTotal[i], Comparator.reverseOrder()));

        System.out.printf("%nJuegos Olímpicos de Tokio 2020%n");
        System.out.printf("%n Tabla de posiciones %n");
        System.out.printf("%n %-15s  %-15s %n", "Pais", "Puntaje Total");

        for (int i : indices) {
            System.out.printf(" %-15s  %-15s%n", paises[i], puntajesTotal[i]);

        }

    }

    // Lector
    static public void leerPuntajes(int numPaises) {
        String[] paises = new String[numPaises];
        int[] oros = new int[numPaises];
        int[] platas = new int[numPaises];
        int[] bronces = new int[numPaises];
        int[] puntajesTotal = new int[numPaises];

        for (int i = 0; i < numPaises; i++) {
            String pais = Utils.leerString("\nNombre del país " + (i + 1) + ": ");
            paises[i] = pais;
            int oro = Utils.leerEntero("Número de medallas de oro: ");
            oros[i] = oro;
            int plata = Utils.leerEntero("Número de medallas de plata: ");
            platas[i] = plata;
            int bronce = Utils.leerEntero("Número de medallas de bronce: ");
            bronces[i] = bronce;

            puntajesTotal[i] = oros[i] * 3 + platas[i] * 2 + bronces[i];

            System.out.println("\nEl puntaje total de " + pais + " es: " + puntajesTotal[i]);
        }

        tablaPuntajes(paises, puntajesTotal);
        medalleroInformativo(paises, oros, platas, bronces);
        tablaPosiciones(paises, puntajesTotal);

    }

    public static void main(String[] args) {

        // Leer el numero de paises en el torneo.
        final int numPaises = Utils.leerEntero("\nNúmero de países del torneo: ");

        // Leer Puntajes de los paises participantes
        leerPuntajes(numPaises);

    }
}
