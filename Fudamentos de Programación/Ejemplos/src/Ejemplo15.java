public class Ejemplo15 {
    public static void main(String[] args) {
        int n;

        n = Utils.leerEntero("\nPorfavor Ingrese un número entero Positivo: ");

        System.out.println("\nLos números desde " + n + " hasta 1, son:");

        for (int i = n + 1; i > 1; i--) {
            System.out.println(i - 1);
        }
    }
}
