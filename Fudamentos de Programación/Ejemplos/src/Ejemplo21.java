public class Ejemplo21 {

    static int generarNumeroAleatorioValido() {
        int numero = 0;
        do {
            numero = generarNumeroAleatorio();
        } while (!validarNumero(numero));
        return numero;
    }

    static int generarNumeroAleatorio() {
        int numero = 0;
        do {
            numero = (int) Math.round(Math.random() * 9999);
        } while (numero < 1000);
        return numero;
    }

    static int obtenerMillares(int x) {
        return x / 1000;
    }

    static int obtenerCentenas(int x) {
        x = x - (1000 * obtenerMillares(x));
        return x / 100;
    }

    static int obtenerDecenas(int x) {
        x = x - (1000 * obtenerMillares(x));
        x = x - (100 * obtenerCentenas(x));
        return x / 10;
    }

    static int obtenerUnidades(int x) {
        x = x - (1000 * obtenerMillares(x));
        x = x - (100 * obtenerCentenas(x));
        x = x - (10 * obtenerDecenas(x));
        return x;
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
        int numero = generarNumeroAleatorioValido();
        int m, c, d, u;
        m = obtenerMillares(numero);
        c = obtenerCentenas(numero);
        d = obtenerDecenas(numero);
        u = obtenerUnidades(numero);
        System.out.println(numero);
        System.out.printf("%d %d %d %d", m, c, d, u);
    }
}
