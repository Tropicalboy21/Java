public class Ejemplo19 {

    static double metrosApulgadas(double metros) {
        double pulgada = 39.37;

        double nuevoValor = 0;

        nuevoValor = metros * (pulgada / 1);

        System.out.println("\n" + metros + " metros es igual a " + nuevoValor + " pulgadas");

        return nuevoValor;
    }

    static double metrosApies(double metros) {
        double pie = 3.28;

        double nuevoValor = 0;

        nuevoValor = metros * (pie / 1);

        System.out.println("\n" + metros + " metros es igual a " + nuevoValor + " pies");

        return nuevoValor;
    }

    public static void main(String[] args) {

        metrosApulgadas(4.6);
        metrosApies(15);
    }
}
