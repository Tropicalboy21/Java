import java.util.Arrays;
import java.util.Random;

public class Practica04 {

    public static void invertir(double arr[]) {
        int n = arr.length;

        for (int i = 0; i < n / 2; i++) {
            double temp = arr[i];
            arr[i] = arr[n - 1 - i];
            arr[n - 1 - i] = temp;
        }

        System.out.println("\n" + Arrays.toString(arr));

        System.out.println("\nTop n son igual a : ");
        for (int i = 0; i <= 5; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void mediana(double[] validos) {
        double mediana = 0;
        int n = validos.length;

        if (n % 2 == 0) {
            mediana = (validos[n / 2] + validos[n / 2 - 1]) / 2;
        } else {
            mediana = validos[n / 2];
        }

        System.out.println("\nLa mediana es igual a : " + mediana);
    }

    public static void promedio(double[] validos) {

        int n = validos.length;

        double suma = Arrays.stream(validos).sum();

        double promedio = Math.round(suma / n);

        System.out.println("\nEl promedio es: " + promedio);

    }

    public static void maximo(double[] validos) {

        int l = validos.length - 1;

        double numeroMaximo = validos[l];

        System.out.println("\nEl número Máximo es: " + numeroMaximo);

    }

    public static void minimo(double[] validos) {

        double numeroMinimo = validos[0];

        System.out.println("\nEl número Mínimo es: " + numeroMinimo);

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
        promedio(removerMayores);
        mediana(removerMayores);
        invertir(removerMayores);
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

        int size = 0;

        size = Utils.leerEntero("\nIngrese el Tamaño del Arreglo: ");

        double[] numeros = new double[size];
        llenarNumeroAleatorios(numeros, 100, 500);
        ordenar(numeros);
        System.out.println("\n" + Arrays.toString(numeros));

        removerAtipicos(numeros);

    }
}
