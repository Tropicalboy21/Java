public class App {
    public static void main(String[] args) {
        String pais = "";
        String pais1 = "";
        String pais2 = "";
        String pais3 = "";
        int oro = 0;
        int plata = 0;
        int bronce = 0;
        int puntaje = 0;
        int puntaje1 = 0;
        int puntaje2 = 0;
        int puntaje3 = 0;
        int contador = 3;

        for (int i = 1; i <= contador; i++) {
            pais = Utils.leerString("\nNombre del país " + i + ": ");
            oro = Utils.leerEntero("Número de medallas de oro: ");
            plata = Utils.leerEntero("Número de medallas de plata: ");
            bronce = Utils.leerEntero("Número de medallas de bronce: ");

            puntaje = (oro * 3) + (plata * 2) + (bronce * 1);

            if (i == 1) {
                pais1 = pais;
                puntaje1 = puntaje;
            } else if (i == 2) {
                pais2 = pais;
                puntaje2 = puntaje;
            } else if (i == 3) {
                pais3 = pais;
                puntaje3 = puntaje;
            }

        }

        System.out.println("\nEl puntaje total de " + pais1 + " es: " + puntaje1);
        System.out.println("El puntaje total de " + pais2 + " es: " + puntaje2);
        System.out.println("El puntaje total de " + pais3 + " es: " + puntaje3);

        if (puntaje1 > puntaje2) {
            if (puntaje1 > puntaje3) {
                System.out.println("\nEl pais que obtuvo mayor puntaje es: " + pais1);
            } else {
                System.out.println("\nEl pais que obtuvo mayor puntaje es: " + pais3);
            }
        } else if (puntaje2 > puntaje3) {
            System.out.println("\nEl pais que obtuvo mayor puntaje es: " + pais2);
        } else {
            System.out.println("\nEl pais que obtuvo mayor puntaje es: " + pais3);
        }
    }
}
