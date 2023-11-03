public class Ejemplo19 {

    static double metrosApulgadas(double metros) {

        double nuevoValor = metros * 39.37;

        System.out.println("\n" + metros + " metros es igual a " + nuevoValor + " pulgadas");

        return nuevoValor;
    }

    static double metrosApies(double metros) {

        double nuevoValor = metros * 3.28;

        System.out.println("\n" + metros + " metros es igual a " + nuevoValor + " pies");

        return nuevoValor;
    }

    public static void main(String[] args) {

        metrosApulgadas(4.6);
        metrosApies(15);
    }
}
