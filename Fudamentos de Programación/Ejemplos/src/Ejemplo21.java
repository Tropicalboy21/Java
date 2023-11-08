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

    public static void probar(int x) {
        int m = 0, c = 0, d = 0, u = 0;
        m = x / 1000;
        x = x % 1000;
        c = x / 100;
        x = x % 100;
        d = x / 10;
        u = x % 10;
        System.out.println("m:%d c:%d d:%d u:%d" + m, c, d, u);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(generarNumeroAleatorio());
        }
        probar(8987);
    }
}
