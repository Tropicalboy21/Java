import java.util.Arrays;
import java.util.Random;

public class Practica04 {

    public static void removerAtipicos(double[] arreglo) {

        int l = arreglo.length;

        double valoresAtipicos = l * 0.05;

        int elementosAremover = (int) Math.round(valoresAtipicos);

        double[] nuevoArreglo = Arrays.copyOfRange(arreglo, elementosAremover, arreglo.length);

        System.out.println("\n" + Arrays.toString(nuevoArreglo));

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
        System.out.println(Arrays.toString(numeros));
        removerAtipicos(numeros);
        System.out.println();

    }
}
