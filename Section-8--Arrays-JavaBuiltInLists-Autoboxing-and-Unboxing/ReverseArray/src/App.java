import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        int[] array = new int[] { 6, 5, 8, 9, 10, 39 };
        reverse(array);
    }

    private static void reverse(int[] array) {
        System.out.println("Array = " + Arrays.toString(array));
        for (int i = 0; i < array.length / 2; i++) {
            int swap = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = swap;
        }
        System.out.println("Reversed Array = " + Arrays.toString(array));
    }
}