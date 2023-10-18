public class Ejemplo17 {
    public static void main(String[] args) {
        int numero, acumulador = 0;

        do {
            numero = Utils.leerEntero("Digite la cantidad para acumular: ");

            System.out.printf("Usted digito $%4d\n", numero);
            acumulador += numero;
        } while (acumulador < 1000);

        System.out.printf("El total acumulado es de $%4d\n", acumulador);
    }
}
