import java.util.Arrays;

public class App {

    // Metodo para calcular el puntaje total.
    static int calcularPuntajeTotal(int oro, int plata, int bronce) {
        return (oro * 3) + (plata * 2) + bronce;
    }

    public static void main(String[] args) {
        String paisGanador = "";
        int maxPuntaje = Integer.MIN_VALUE;

        // Leer el numero de paises en el torneo.
        final int numPaises = Utils.leerEntero("\nNúmero de países del torneo: ");

        String[] paises = new String[numPaises];
        int[] oros = new int[numPaises];
        int[] platas = new int[numPaises];
        int[] bronces = new int[numPaises];
        int[] puntajesTotal = new int[numPaises];

        // Leer numero de medallas y calcular el total de puntos de cada pais.
        for (int i = 0; i < numPaises; i++) {
            String pais = Utils.leerString("\nNombre del país " + (i + 1) + ": ");
            paises[i] = pais;
            int oro = Utils.leerEntero("Número de medallas de oro: ");
            oros[i] = oro;
            int plata = Utils.leerEntero("Número de medallas de plata: ");
            platas[i] = plata;
            int bronce = Utils.leerEntero("Número de medallas de bronce: ");
            bronces[i] = bronce;

            int puntajeTotal = calcularPuntajeTotal(oro, plata, bronce);

            puntajesTotal[i] = oros[i] * 3 + platas[i] * 2 + bronces[i];

            System.out.println("\nEl puntaje total de " + pais + " es: " + puntajeTotal);

            // Validar si es el pais con mayor puntaje total.
            if (puntajeTotal > maxPuntaje) {
                maxPuntaje = puntajeTotal;
                paisGanador = pais;
            }
        }

        // Imprimir el pais con mayor puntaje.
        System.out.println("\nEl pais con mayor puntaje total es: " + paisGanador);
        System.out.println("Array paises: " + Arrays.toString(paises));
        System.out.println("Array paises: " + Arrays.toString(oros));
        System.out.println("Array paises: " + Arrays.toString(platas));
        System.out.println("Array paises: " + Arrays.toString(bronces));
        System.out.println("Array paises: " + Arrays.toString(puntajesTotal));
    }
}
