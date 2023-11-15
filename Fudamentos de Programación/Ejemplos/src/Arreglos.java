public class Arreglos {

    public static int sumar(int[] valores) {
        int contador = 0;

        for (int i = 0; i < valores.length; i++) {
            contador += valores[i];
        }

        return contador;
    }

    public static void main(String[] args) {
        int edades[] = new int[4];
        edades[0] = 17;
        edades[1] = 27;
        edades[2] = 37;
        edades[3] = 100;
        System.out.println(sumar(edades));
    }
}
