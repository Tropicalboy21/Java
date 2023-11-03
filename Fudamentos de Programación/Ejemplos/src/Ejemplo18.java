public class Ejemplo18 {
    public static void main(String[] args) {
        int numPapitas = 0;
        int numPlatanitos = 0;
        int precioPapitasCompra = 250;
        int precioPlatanitosCompra = 400;
        int precioPapitasVenta = 500;
        int precioPlatanitosVenta = 600;
        int numPapitasVenta = 0;
        int numPlatanitosVenta = 0;
        boolean guarda = false;
        int promo = 0;
        int i = 1;
        int ganancias = 0;

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
                int numInteresados = 0;
                System.out.println("\naula " + j);

                numInteresados = Utils.leerEntero("\nCuantos interesados en comprar hay?: ");

                for (int y = 1; y <= numInteresados; y++) {
                    numPapitasVenta = Utils.leerEntero("\ncuantas papitas desea el interesado  #" + y + " : ");
                    numPlatanitosVenta = Utils.leerEntero("cuantos platatinos desea el interesado  #" + y + " : ");
                }
                guarda = Utils.leerBoolean("\nhay algun guarda al salir del aula " + j);

                if (guarda == true) {
                    System.out.println("\nRique ha sido atrapado por seguridad");
                    j = 100;
                }
                j++;
            } while (j < 5);

            i++;

        } while (i < 4 && guarda == false);

        ganancias = (numPapitasVenta * precioPapitasVenta) + (numPlatanitosVenta * precioPlatanitosVenta);

        System.out.println("\nnumero de papitas vendidas: " + numPapitasVenta + "\nnumero de platanitos vendidos: "
                + numPlatanitosVenta + "\nGanancias totales: " + ganancias);

    }
}
