
import java.util.Arrays;
import java.util.Comparator;

public class App2 {

    // Arreglos de los medalleros
    static String[] paises = null;
    static int[] oros = null;
    static int[] platas = null;
    static int[] bronces = null;
    static int[] puntajesTotal = null;

    // Número de países en el torneo
    static int numPaises = 0;

    static public void inicializarMedallero() {
        // Se inicializa el medallero
        numPaises = Utils.leerEntero("\nNúmero de países del torneo: ");
        paises = new String[numPaises];
        oros = new int[numPaises];
        platas = new int[numPaises];
        bronces = new int[numPaises];
        puntajesTotal = new int[numPaises];

        leerPuntajes();
    }

    // Retorna false si el medallero no está inicializado
    // Retorna true de caso contrario
    static public boolean confirmarMedalleroInicializado() {
        if (paises == null || paises[0] == null) {
            System.out.println("El medallero no se ha inicializado.");
            Utils.leerString("");
            return false;
        } else {
            return true;
        }
    }

    static public void tablaPuntajes() {

        // Validar que el medallero esté inicializado
        if (!confirmarMedalleroInicializado()) {
            return;
        }

        int l = paises.length;

        System.out.printf("\n ");
        System.out.printf("Juegos Olímpicos de Tokio 2020%n");
        System.out.printf("\n Tabla de posiciones %n");
        System.out.printf("\n %-8s  %-8s %n", "Pais", "Puntaje Total");

        for (int i = 0; i < l; i++) {
            System.out.printf(" %-10s  %-8s %n", paises[i], puntajesTotal[i]);
        }
        Utils.leerString("");

    }

    static public void medalleroInformativo() {

        // Validar que el medallero esté inicializado
        if (!confirmarMedalleroInicializado()) {
            return;
        }

        int l = oros.length;

        System.out.printf("\n ");
        System.out.printf("Juegos Olímpicos de Tokio 2020%n");
        System.out.printf("\n Medallero informativo %n");
        System.out.printf("\n %-10s  %-8s  %-8s  %-8s %n", "Pais", "Oro", "Plata",
                "Bronce");

        for (int i = 0; i < l; i++) {
            System.out.printf(" %-10s  %-8s %-8s  %-8s %n", paises[i], oros[i], platas[i], bronces[i]);
        }
        Utils.leerString("");

    }

    static public void tablaPosiciones() {
        // Validar que el medallero esté inicializado
        if (!confirmarMedalleroInicializado()) {
            return;
        }

        int l = puntajesTotal.length;
        Integer[] indices = new Integer[l];

        for (int i = 0; i < l; i++) {
            indices[i] = i;
        }

        Arrays.sort(indices, Comparator.comparing(i -> puntajesTotal[i], Comparator.reverseOrder()));

        System.out.printf("%nJuegos Olímpicos de Tokio 2020%n");
        System.out.printf("%nTabla de posiciones %n");
        System.out.printf("%n %-15s  %-15s%n", "Pais", "Puntaje Total");

        for (int i : indices) {
            System.out.printf(" %-15s  %-15s %n", paises[i], puntajesTotal[i]);

        }
        Utils.leerString("");

    }

    // Lector
    static public void leerPuntajes() {

        // Validar que se haya ingresado la cantidad de países
        if (numPaises == 0) {
            System.out.println("El medallero no se ha inicializado.");
            Utils.leerString("");
            return;
        }

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
        Utils.leerString("");

    }

    static public void obtenerPaisConMasMedallas(String tipoMedalla, int[] arregloMedallas) {
        // Validar que el medallero esté inicializado
        if (!confirmarMedalleroInicializado()) {
            return;
        }

        int mayor = arregloMedallas[0];
        String paisMayor = paises[0];
        for (int i = 0; i < arregloMedallas.length; i++) {
            if (arregloMedallas[i] >= mayor) {
                mayor = arregloMedallas[i];
                paisMayor = paises[i];
            }
        }

        System.out.println("El país con más medallas de " + tipoMedalla + " es: " + paisMayor);
        Utils.leerString("");
    }

    public static void main(String[] args) {

        int opcion = 0;
        do {
            Utils.limpiar();
            System.out.println("***********************************************************");
            System.out.println("******Medallero de los Juegos Olímpicos de Tokio 2020******");
            System.out.println("***********************************************************\n\n");
            System.out.println("Eliga la opción deseada:");
            System.out.println("1. Inicializar el medallero. Ingresar la información de cada uno de los países"); // Esto
                                                                                                                  // incluye
                                                                                                                  // puntos
                                                                                                                  // 1 y
                                                                                                                  // 2
                                                                                                                  // del
                                                                                                                  // documento
            System.out.println("2. Imprimir el puntaje total de todos los países participantes."); // Esto incluye
                                                                                                   // puntos 3 y 4 del
                                                                                                   // documento
            System.out.println("3. Imprimir el país con más medallas de oro"); // Agregado por nosotros
            System.out.println("4. Imprimir el país con más medallas de plata");
            System.out.println("5. Imprimir el país con más medallas de bronce.");
            System.out.println("6. Mostrar la tabla del medallero completo.");
            System.out.println("7. Mostrar los países en order descendente según su puntaje."); // Esto incluye puntos 8
                                                                                                // y 9 del document
            System.out.println("8. Salir\n");
            opcion = Utils.leerEntero("Opción: ");

            switch (opcion) {
                case 1:
                    inicializarMedallero();
                    break;
                case 2:
                    tablaPuntajes();
                    break;
                case 3:
                    obtenerPaisConMasMedallas("oro", oros);
                    break;
                case 4:
                    obtenerPaisConMasMedallas("plata", platas);
                    break;
                case 5:
                    obtenerPaisConMasMedallas("bronce", bronces);
                    break;
                case 6:
                    medalleroInformativo();
                    break;
                case 7:
                    tablaPosiciones();
                    break;
            }

        } while (opcion != 8);

        Utils.leerString("\n¡Esperamos verte pronto!");

    }
}
