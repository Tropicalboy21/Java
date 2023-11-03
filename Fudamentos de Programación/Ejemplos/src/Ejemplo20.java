public class Ejemplo20 {

    static int numeroMayor(int a, int b, int c) {
        int mayor = a;

        if (a > b) {
            if (a > c) {
                System.out.println("\nEl Mayor numero es: " + a);
                mayor = a;
            } else {
                System.out.println("\nEl Mayor numero es: " + c);
                mayor = c;
            }
        } else if (b > c) {
            System.out.println("\nEl Mayor numero es: " + b);
            mayor = b;
        } else {
            System.out.println("\nEl Mayor numero es: " + c);
            mayor = c;
        }

        return mayor;
    }

    public static void main(String[] args) {
        numeroMayor(222, 720, 110);
    }
}
