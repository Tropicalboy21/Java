import java.util.Scanner;

public class Examples {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        run();
    }

    public static void run() {

        int[] numbers = new int[3];

        System.out.println("\nIngrese tres numeros: ");

        for (int i = 0; i <= 2; i++) {

            System.out.print("\nNumero " + (i + 1) + ": ");
            numbers[i] = sc.nextInt();
        }

        print(numbers);
    }

    public static void suma(int[] numbers){

        int suma = 0;

        for (int i = 0; i <= 2; i++) {

            suma += numbers[i];
        }
        System.out.println("\nLa suma de los tres numeros ingresados es: ");
        System.out.print(suma);
    }

    public static void promedio(int[] numbers){

        double promedio = 0;
        int suma = 0;

        for (int i = 0; i <= 2; i++) {

            suma += numbers[i];
        }

        promedio = (double) suma / 3;

        System.out.println("\nEl promedio de los tres numeros ingresados es: ");
        System.out.print(promedio);
    }

    public static void producto(int[] numbers){

        int producto = 0;

        int initpro = numbers[0] * numbers[1];

        producto = initpro * numbers[2];

        System.out.println("\nEl producto de los tres numeros ingresados es: ");
        System.out.print(producto);

    }

    public static void menor(int[] numbers){

        int menor = 0;

        for (int i = 0; i < 1; i++) {

            if (numbers[i] <= numbers[i + 1] && numbers[i] <= numbers[i + 2]){
                menor = numbers[i];
            } else if (numbers[i + 1] <= numbers[i] && numbers[i+ 1] <= numbers[i+ 2]) {
                menor = numbers[i + 1];
            } else {
                menor = numbers[i + 2];
            }
        }

        System.out.println("\nEl menor de los tres numeros ingresados es: ");
        System.out.print(menor);
    }


    public static void print(int[] numbers){
        System.out.println("\nLos tres numeros ingresados son: ");

        for (int i = 0; i <= 2; i++) {
            System.out.print(numbers[i] + ", ");
        }

        suma(numbers);
        promedio(numbers);
        producto(numbers);
        menor(numbers);
    }
}
