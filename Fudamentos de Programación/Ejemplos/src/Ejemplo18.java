public class Ejemplo18 {
    public static void main(String[] args) {
        int numPapitas = 0;
        int numPlatanitos = 0;
        int precioPapitasCompra = 500;
        int precioPlatanitosCompra = 600;
        int precioPapitasVenta = 0;
        int precioPlatanitosVenta = 0;
        int promo = 0;
        int i = 1;

        numPapitas = Utils.leerEntero("\nPorfavo ingrese el numero de papitas a comprar: ");
        numPlatanitos = Utils.leerEntero("\nPorfavo ingrese el numero de platanitos a comprar: ");

        promo = Math.round(numPapitas / 12);

        numPapitas += promo;

        System.out
                .println("\nnumero total de papitas: " + numPapitas + "\nnumero total de platanitos: " + numPlatanitos);

        System.out.println("\nBienvenido al nuevo edificio universitario");

        do {
            System.out.println("\npiso " + i);
            int j = 1;
            do {
                System.out.println("aula " + j);
                j++;
            } while (j < 5);

            i++;

        } while (i < 4);
    }
}
