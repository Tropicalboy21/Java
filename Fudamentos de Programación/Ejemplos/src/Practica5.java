
import java.util.Arrays;
import java.util.Random;

public class Practica5 {

    public static void llenarNumeroAleatorios(double[] datos, int min, int max) {
        long semilla = 1234567890l;
        Random random = new Random(semilla);
        for (int i = 0; i < datos.length; i++) {
            datos[i] = (int) (random.nextInt(max));
        }
    }

    public static void ordenarNumeros(double[] numeros) {
        Arrays.sort(numeros);
        System.out.println("Array original ordenado: " + Arrays.toString(numeros));
    }

    public static double[] obtenerNumerosValidos(double[] numeros) {
        final double MARGEN_DE_ERROR = 0.05;
        int cantidadPorRemover = (int) Math.round(numeros.length * MARGEN_DE_ERROR);
        System.out.println("Removiendo " + cantidadPorRemover + " números");
        double[] newArray = Arrays.copyOfRange(numeros, cantidadPorRemover, (numeros.length - cantidadPorRemover));
        System.out.println("Lista de números válidos: " + Arrays.toString(newArray));
        return newArray;
    }

    public static void obtenerMayor(double[] numeros) {
        System.out.println("Número mayor: " + numeros[numeros.length - 1]);
    }

    public static void obtenerMenor(double[] numeros) {
        System.out.println("Número menor: " + numeros[0]);
    }

    public static void obtenerPromedio(double[] numeros) {
        double sumaTotal = 0;
        for (int i = 0; i < numeros.length; i++) {
            sumaTotal += numeros[i];
        }
        System.out.println("Promedio: " + (sumaTotal / numeros.length));
    }

    public static void obtenerMediana(double[] numeros) {
        double mediana = 0;
        if (numeros.length % 2 == 0) {
            mediana = (numeros[numeros.length / 2] + (numeros[(numeros.length / 2) - 1])) / 2;

        } else {
            mediana = numeros[numeros.length / 2];
        }
        System.out.println("Mediana: " + mediana);
    }

    public static void obtenerTop(double[] numeros) {
        int top = Utils.leerEntero("Digite el top de numeros que desea ver: ");
        System.out.println("Top " + top + " numbers: ");
        for (int i = numeros.length - 1; i >= numeros.length - top; i--) {
            System.out.println(numeros[i]);
        }
    }

    public static void main(String[] args) {

        final int MIN = 100;
        final int MAX = 500;
        final double MARGEN_DE_ERROR = 0.05;

        // Usuario elige la cantidad de números aleatorios a generar
        int totalNumeros = Utils.leerEntero("¿Cuantos números aleatorios desea? ");
        double[] numeros = new double[totalNumeros];
        llenarNumeroAleatorios(numeros, MIN, MAX);
        System.out.println("Array original: " + Arrays.toString(numeros));

        // Ordenar el array
        ordenarNumeros(numeros);

        // Eliminar valores inválidos
        double[] newArray = obtenerNumerosValidos(numeros);

        // Obtener el mayor y el menor
        obtenerMayor(newArray);
        obtenerMenor(newArray);

        // Calcular el promedio
        obtenerPromedio(newArray);

        // Calcular la mediana dependiendo de si es una cantidad par o impar de
        // elementos
        obtenerMediana(newArray);

        // Mostrar el top de números elegidos por el usuario
        obtenerTop(newArray);

    }
}
