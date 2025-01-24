import java.util.Scanner;

public class Ejercicio4 {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int numero = 0;

        System.out.print("\nIngrese un numero: ");
        numero = sc.nextInt();

        boolean primo = esPrimo(numero);
        boolean fibonacci = esFibonacci(numero);
        boolean par = esPar(numero);

        StringBuilder resultado = new StringBuilder();
        resultado.append(numero);

        if (primo) {
            resultado.append(" es primo,");
        } else {
            resultado.append(" no es primo");
        }
        if (fibonacci) {
            resultado.append(" es fibonacci,");
        } else {
            resultado.append(" no es fibonacci");
        }
        if (par) {
            resultado.append(" y es par.");
        } else {
            resultado.append(" y es impar.");
        }

        System.out.println(resultado);
    }

    public static boolean esPrimo(int num){
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean esPar(int num){
        return num % 2 == 0;
    }

    public static boolean esFibonacci(int num) {
        return isPerfectSquare(5 * num * num + 4) || isPerfectSquare(5 * num * num - 4);
    }

    public static boolean isPerfectSquare(int num) {
        int sqrt = (int) Math.sqrt(num);
        return (sqrt * sqrt == num);
    }

}
