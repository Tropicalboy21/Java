public class Ejemplo21 {

    public static int generarNumeroAleatorio() {
        int numero = 0;
        do {
            numero = (int) Math.round(Math.random() * 9999);
            if (numero >= 1000)
                System.out.println(numero);
        } while (numero < 1000);
        return numero;
    }

    static int obtenerMillares(int x) {
        return x / 1000;
    }

    static int obtenerCentenas(int x) {
        x = x - (obtenerMillares(x));
        return x / 100;
    }

    static int obtenerDecenas(int x) {
        x = x - (1000 * obtenerCentenas(x));
        x = x - (100 * obtenerCentenas(x));
        return x / 10;
    }

    static int obtenerUnidades(int x) {
        double y = x / 10.0;
        y = y - (int) y;
        return (int) (y * 10);
    }

    static boolean validarNumero(int x) {
        int m = 0, c = 0, d = 0, u = 0;
        m = x / 1000;
        x = x % 1000;
        c = x / 100;
        x = x % 100;
        d = x / 10;
        u = x % 10;
        return !(m == c || m == d || m == u || c == d || c == u || d == u);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(generarNumeroAleatorio());
        }
        validarNumero(8987);
    }
}
