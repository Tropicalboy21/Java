public class Exercise08 {
    public static void main(String[] args) {
        double numero;
        double cuadrado;

        numero = Utils.leerDoble("\nPorfavor ingrese un numero: ");

        cuadrado = Math.pow(numero, 2);

        System.out.println("\nEl numero elevado al cuadrado es igual a : " + cuadrado);
    }
}