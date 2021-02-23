import java.util.Scanner;
import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("The lowest value is " + findMin(readElements(readInteger())));
    }

    private static int readInteger() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of elements: ");
        int value = scanner.nextInt();
        return value;
    }

    private static int[] readElements(int number) {
        Scanner scanner = new Scanner(System.in);
        int[] values = new int[number];
        for (int i = 0; i < number; i++) {
            System.out.println("Enter number " + (1+i));
            values[i] = scanner.nextInt();
        }
        return values;
    }

    private static int findMin(int[] values){
        Arrays.sort(values);
        int value = values[0];
        return value;
    }
}
/* 
 * And finally, write a method called findMin() with one parameter of type
 * int[]. The method needs to return the minimum value in the array.
 * 
 * The scenario is:
 * 
 * 1. readInteger() is called.
 * 
 * 2. The number returned by readInteger() is then used to call readElements().
 * 
 * 3. The array returned from readElements() is used to call findMin().
 * 
 * 4. findMin() returns the minimum number.
 * 
 * [Do not try and implement this. It is to give you an idea of how the methods
 * will be used]
 * 
 * TIP: Assume that the user will only enter numbers, never letters.
 * 
 * TIP: Instantiate (create) the Scanner object inside the method. There are two
 * scanner objects, one for each of the two methods that are reading in input
 * from the user.
 * 
 * TIP: Be extremely careful about spaces in the printed message.
 * 
 * NOTE: All methods should be defined as private static.
 * 
 * NOTE: Do not add a main method to the solution code.
 * 
 */