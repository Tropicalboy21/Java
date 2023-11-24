public class Ejemplo28 {

    public static void main(String[] args) {

        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8 };

        int n = arr.length;

        for (int i = 0; i < n; i++) {
            arr[n - 1] = arr[i];

        }

        for (int j = 0; j < arr.length; j++) {
            System.out.println(arr[j]);
        }

    }
}
