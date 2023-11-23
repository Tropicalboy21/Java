public class Ejemplo26 {
    public static void main(String[] args) {
        int[] arreglo1 = { 1, 2, 3, 4 };
        int[] arreglo2 = { 1, 2, 3, 4 };

        boolean resultado = comparadorDeArreglos(arreglo1, arreglo2);
        System.out.println(resultado);
    }

    public static boolean comparadorDeArreglos(int[] arreglo1, int[] arreglo2) {
        int i = 0;
        boolean resultado = true;
        for (i = 0; i < arreglo1.length; i++) {
            if (arreglo1[i] != arreglo2[i]) {
                resultado = false;
            }
        }
        return resultado;
    }
}
