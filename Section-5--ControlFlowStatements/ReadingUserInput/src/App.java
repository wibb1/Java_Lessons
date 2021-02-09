import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        boolean hasNextInt = false;
        int number = 0;
        int i = 0;
        do {
            System.out.println("\nEnter a number");
            hasNextInt = keyboard.hasNextInt();
            if (hasNextInt) {
                number += keyboard.nextInt();
                keyboard.nextLine();
                i++;
            } else {
                keyboard.nextLine();
            }
        } while (i < 10);
        System.out.println("Your total is " + number);
        keyboard.close();
    }
}
