import java.util.Scanner;

public class Ejercicio3 {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Circumference();
    }

    public static void  Circumference(){

        System.out.println("\nIngrese 5 radios de circulos");

        double[] values = new double[5];

        for (int i = 0; i < 5; i++) {
            System.out.print("\nIngrese el radio " + (i + 1)+ ":");
            values[i] = sc.nextDouble();
        }

        System.out.println("\nLos valores de los radios ingresados son: ");

        for (int i = 0; i < 5; i++) {
            System.out.println("| Valor "+ (i+1)+":" + values[i] + "| Diametro:" + (values[i] * 2) + "| Circunferencia: " +  ((values[i] * 2) * 3.1416) + "|");
        }

    }
}
