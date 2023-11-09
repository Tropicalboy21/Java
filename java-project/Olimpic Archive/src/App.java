public class App {
    // Metodo para calcular el puntaje total.
    static int calcularPuntajeTotal(int oro, int plata, int bronce) {
        return (oro * 3) + (plata * 2) + bronce;
    }

    public static void main(String[] args) {
        String paisGanador = "";
        int maxPuntaje = Integer.MIN_VALUE;

        // Leer el numero de pais en el torneo.
        int numPaises = Utils.leerEntero("\nNúmero de países del torneo: ");

        // Leer numero de medallas y calcular el total de puntos de cada pais.
        for (int i = 0; i < numPaises; i++) {
            String pais = Utils.leerString("\nNombre del país " + (i + 1) + ": ");
            int oro = Utils.leerEntero("Número de medallas de oro: ");
            int plata = Utils.leerEntero("Número de medallas de plata: ");
            int bronce = Utils.leerEntero("Número de medallas de bronce: ");

            int puntajeTotal = calcularPuntajeTotal(oro, plata, bronce);
            System.out.println("\nEl puntaje total de " + pais + " es: " + puntajeTotal);

            // Validar si es el pais con mayor puntaje total.
            if (puntajeTotal > maxPuntaje) {
                maxPuntaje = puntajeTotal;
                paisGanador = pais;
            }
        }
        // Imprimir el pais con mayor puntaje.
        System.out.println("\nEl pais con mayor puntaje total es: " + paisGanador);
    }
}
