import java.util.Arrays;
import java.util.Random;

public class Practica04 {

    public static void maximo(double[] validos) {

        int l = validos.length - 1;

        double numeroMaximo = validos[l];

        System.out.println("\nEl numero Máximo es: " + numeroMaximo);

    }

    public static void minimo(double[] validos) {

        double numeroMinimo = validos[0];

        System.out.println("\nEl numero Mínimo es: " + numeroMinimo);

    }

    public static void removerAtipicos(double[] arreglo) {

        int l = arreglo.length;

        double valoresAtipicos = l * 0.05;

        int elementosAremover = (int) Math.round(valoresAtipicos);

        double[] removerMenores = Arrays.copyOfRange(arreglo, elementosAremover, arreglo.length);

        double[] removerMayores = Arrays.copyOf(removerMenores, removerMenores.length - elementosAremover);

        int n = removerMayores.length;

        System.out.println("\n" + Arrays.toString(removerMayores));

        System.out.println("\nEl número de datos válidos es: " + n);

        minimo(removerMayores);
        maximo(removerMayores);
    }

    public static void ordenar(double[] arreglo) {
        Arrays.sort(arreglo);
    }

    public static void llenarNumeroAleatorios(double[] datos, int min, int max) {
        long semilla = 1234567890l;
        Random random = new Random(semilla);
        for (int i = 0; i < datos.length; i++) {
            datos[i] = (int) (random.nextInt(max));
        }
    }

    public static void main(String[] args) {

        double[] numeros = new double[60];
        llenarNumeroAleatorios(numeros, 100, 500);
        ordenar(numeros);
        System.out.println("\n" + Arrays.toString(numeros));

        removerAtipicos(numeros);

    }
}
