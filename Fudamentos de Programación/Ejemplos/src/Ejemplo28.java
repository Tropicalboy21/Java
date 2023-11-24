public class Ejemplo28 {
    public static void main(String[] args) {

        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8 };

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == arr[0]) {
                arr[i] = arr[7];
                arr[7] = arr[0];
            }

        }

        for (int j = 0; j < arr.length; j++) {
            System.out.println(arr[j]);
        }

    }
}
