public class App {
    public static void main(String[] args) {
        String pais;
        int oro, plata, bronce, puntaje;
        int contador = 3;

        for (int i = 1; i <= contador; i++) {
            pais = Utils.leerString("\nNombre del país " + i + ": ");
            oro = Utils.leerEntero("Número de medallas de oro: ");
            plata = Utils.leerEntero("Número de medallas de plata: ");
            bronce = Utils.leerEntero("Número de medallas de bronce: ");

            puntaje = (oro * 3) + (plata * 2) + (bronce * 1);

            System.out.println("\nEl puntaje total de " + pais + " es: " + puntaje);
        }

    }
}
