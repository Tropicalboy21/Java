public class Ejemplo29 {
    public static int contarPositivos(int arr[]) {
        int contador = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 1) {
                contador += 1;
            }
        }

        return contador;
    }

    public static int contarNegativos(int arr[]) {
        int contador = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                contador += 1;
            }
        }

        return contador;
    }

    public static int contarCeros(int arr[]) {
        int contador = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                contador += 1;
            }
        }

        return contador;
    }

    public static void main(String[] args) {
        int arr[] = { -3, -2, -1, 0, 1, 2, 3 };
        int numPositivos, numNegativos, numCeros;

        numPositivos = contarPositivos(arr);
        numNegativos = contarNegativos(arr);
        numCeros = contarCeros(arr);

        System.out.println(
                "\nnumeros Positivos: " + numPositivos + "\nnumeros Negativos: " + numNegativos + "\nnumero de Ceros: "
                        + numCeros);
    }
}
