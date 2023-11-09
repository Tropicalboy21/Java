public class App {
    public static void main(String[] args) {

        String pais = "";
        int oro = 0;
        int plata = 0;
        int bronce = 0;
        String paisGanador = "";
        int maxPuntaje = Integer.MIN_VALUE;
        int numPaises = 0;

        numPaises = Utils.leerEntero("\nNúmero de países del torneo: ");

        for (int i = 0; i <= numPaises; i++) {
            pais = Utils.leerString("\nNombre del país " + (i + 1) + ": ");
            oro = Utils.leerEntero("Número de medallas de oro: ");
            plata = Utils.leerEntero("Número de medallas de plata: ");
            bronce = Utils.leerEntero("Número de medallas de bronce: ");

            int puntajeTotal = (oro * 3) + (plata * 2) + (bronce * 1);

            // if (i == 1) {
            // pais1 = pais;
            // puntaje1 = puntaje;
            // } else if (i == 2) {
            // pais2 = pais;
            // puntaje2 = puntaje;
            // } else if (i == 3) {
            // pais3 = pais;
            // puntaje3 = puntaje;
            // }

            System.out.println("\nEl puntaje total de " + pais + " es: " + puntajeTotal);

            // validar si es el pais con mayor puntaje total.

            if (puntajeTotal > maxPuntaje) {
                maxPuntaje = puntajeTotal;
                paisGanador = pais;
            }

        }

        System.out.println("\nEl pais que obtuvo mayor puntaje es: " + paisGanador);

        // System.out.println("\nEl puntaje total de " + pais1 + " es: " + puntaje1);
        // System.out.println("El puntaje total de " + pais2 + " es: " + puntaje2);
        // System.out.println("El puntaje total de " + pais3 + " es: " + puntaje3);

        // if (puntaje1 > puntaje2) {
        // if (puntaje1 > puntaje3) {
        // System.out.println("\nEl pais que obtuvo mayor puntaje es: " + pais1);
        // } else {
        // System.out.println("\nEl pais que obtuvo mayor puntaje es: " + pais3);
        // }
        // } else if (puntaje2 > puntaje3) {
        // System.out.println("\nEl pais que obtuvo mayor puntaje es: " + pais2);
        // } else {
        // System.out.println("\nEl pais que obtuvo mayor puntaje es: " + pais3);
        // }
    }
}
