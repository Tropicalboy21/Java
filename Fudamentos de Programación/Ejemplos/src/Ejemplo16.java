public class Ejemplo16 {
    public static void main(String[] args) {
        int n;

        n = Utils.leerEntero("\nPorfavor Ingrese un número entero Positivo: ");

        System.out.println("\nLos múltiplos de " + n + ", entre 1 y " + n + " son:");

        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                System.out.println(i);
            }
        }
    }
}
