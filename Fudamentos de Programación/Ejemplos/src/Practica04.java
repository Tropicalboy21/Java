import java.util.Arrays;
import java.util.Random;

public class Practica04 {
    public static void llenarNumeroAleatorios(double[] datos, int min, int max) {
        long semilla = 1234567890l;
        Random random = new Random(semilla);
        for (int i = 0; i < datos.length; i++) {
            datos[i] = random.nextLong(min, max);
        }
    }

    public static void main(String[] args) {
        double[] numeros = new double[20];
        llenarNumeroAleatorios(numeros, 100, 500);
        System.out.println(Arrays.toString(numeros));
    }
}
