import java.util.Arrays;

public class App {

    static public void tablaPuntajes(String[] paises) {

        int l = paises.length;

        System.out.printf("\n ");
        System.out.printf("Juegos Olímpicos de Tokio 2020%n");
        System.out.printf("\n Tabla de posiciones %n");
        System.out.printf("\n %-8s  %-8s %n", "Pais", "Puntaje Total");

        for (int i = 0; i < l; i++) {
            System.out.printf("\n %-8s  %-8s %n", paises[i], "Puntaje Total");

        }

    }

    static public void medalleroInformativo() {

    }

    static public void tablaPosiciones() {

    }

    // Metodo para calcular el puntaje total.
    static public void calcularPuntajeTotal(String[] paises, int[] puntajesTotal) {

        int maxPuntaje = Integer.MIN_VALUE;
        String pais = "";

        for (int i = 0; i < puntajesTotal.length; i++) {
            if (puntajesTotal[i] > maxPuntaje) {
                maxPuntaje = puntajesTotal[i];
                pais = paises[i];
            }
        }

        // System.out.println("\nEl pais con mayor puntaje total es: " + pais);
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

        calcularPuntajeTotal(paises, puntajesTotal);
        tablaPuntajes(paises);

        // System.out.println("\nArray paises: " + Arrays.toString(paises));
        // System.out.println("Array paises: " + Arrays.toString(oros));
        // System.out.println("Array paises: " + Arrays.toString(platas));
        // System.out.println("Array paises: " + Arrays.toString(bronces));
        // System.out.println("Array paises: " + Arrays.toString(puntajesTotal));
    }

    public static void main(String[] args) {

        // Leer el numero de paises en el torneo.
        final int numPaises = Utils.leerEntero("\nNúmero de países del torneo: ");

        // Leer Puntajes de los paises participantes
        leerPuntajes(numPaises);

    }
}
