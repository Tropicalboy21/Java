import java.util.Arrays;
import java.util.Random;

public class Practica04 {

    public static void removerAtipicos(double[] arreglo) {

        int l = arreglo.length;

        double valoresAtipicos = l * 0.05;

        int elementosAremover = (int) Math.round(valoresAtipicos);

        double[] removerMenores = Arrays.copyOfRange(arreglo, elementosAremover, arreglo.length);

        double[] removerMayores = Arrays.copyOf(removerMenores, removerMenores.length - elementosAremover);

        System.out.println("\n" + Arrays.toString(removerMayores));

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
        System.out.println("\n" + Arrays.toString(numeros));

    }
}
