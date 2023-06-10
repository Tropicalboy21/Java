import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        // Ejercicios

        // Ejercicio 1
        System.out.println("\n| Suma de dos numeros |");
        System.out.println("\nIngrese el primer valor:");
        int valor1 = sc.nextInt();
        System.out.println("\nIngrese el segundo valor:");
        int valor2 = sc.nextInt();
        int suma = valor1 + valor2;
        System.out.println("la suma de ambos valores es igual a " + suma);

        // Ejercicio 2
        System.out.println("\n| Area de un Circulo |");
        System.out.println("\nIngrese el radio del circulo:");
        double radio = sc.nextDouble();
        double area = Math.PI * radio * radio;
        System.out.println("El area del Circulo es igual: " + area);

        // Ejercicio 3
        System.out.println("\n| Modificar el valor de una variable |");
        System.out.println("\nIngrese la variable 1: ");
        int variable1 = sc.nextInt();
        System.out.println("\nIngrese la variable 2");
        int variable2 = sc.nextInt();
        int aux = variable1;
        variable1 = variable2;
        variable2 = aux;
        System.out.println("\nNuevos valores");
        System.out.println("variable 1 = " + variable1);
        System.out.println("variable 2 = " + variable2);

        // Ejercicio 4
        System.out.println("\n | Distancia entre dos puntos | ");
        System.out.println("\nIngrese X1: ");
        int x1 = sc.nextInt();
        System.out.println("\nIngrese X2: ");
        int x2 = sc.nextInt();
        System.out.println("\nIngrese Y1: ");
        int y1 = sc.nextInt();
        System.out.println("\nIngrese Y2: ");
        int y2 = sc.nextInt();

        int catetoOpuesto = y2 - y1;
        int catetoAdyasente = x2 - x1;

        double hipotenusa = Math.sqrt(Math.pow(catetoOpuesto, 2) +
                Math.pow(catetoAdyasente, 2));
        System.out.println("\nLa distancia entre los dos puntos es igual a: " +
                hipotenusa);

        // Ejercicio 5
        System.out.println("\n | Total Pago de Empleados |");
        System.out.println("\nIngrese el número de directores: ");
        int directores = sc.nextInt();
        System.out.println("\nIngrese el numero de inspectores: ");
        int inspectores = sc.nextInt();
        System.out.println("\n Ingrese el numero de obreros: ");
        int obreros = sc.nextInt();
        int pagoBase = 500;
        int total = 5 * pagoBase * directores + 2 * pagoBase * inspectores + 1 * pagoBase * obreros;
        System.out.println("Total a pagar: " + total);
    }
}

