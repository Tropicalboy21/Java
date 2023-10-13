public class Ejemplo14 {
    public static void main(String[] args) {
        int n;

        n = Utils.leerEntero("\nPorfavor Ingrese un numero entero Positivo: ");

        System.out.println("\nLos números pares entre 1 y " + n + " son:");

        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
    }
}
