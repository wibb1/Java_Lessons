public class App {
    public static void main(String[] args) {
        printAnswer("**First Interest Calculation**");
        printAnswer("10,000 at 2% interest = " + calculateIntres(10000, 2.0));
        printAnswer("10,000 at 3% interest = " + calculateIntres(10000, 3.0));
        printAnswer("10,000 at 4% interest = " + calculateIntres(10000, 4.0));
        printAnswer("10,000 at 5% interest = " + calculateIntres(10000, 5.0));
        printAnswer("10,000 at 6% interest = " + calculateIntres(10000, 6.0));
        printAnswer("**Second Interest Calculation**");
        for (int i = 0; i < 5; i++) {
            printAnswer("Loop " + i + " hello");
        }
        printAnswer("**Third Inerest Calculation**");
        for (int i = 2; i < 9; i++) {
            printAnswer("10,000 at " + i + "% interest = " + String.format("%.2f", calculateIntres(10000, 6.0)));
        }
        printAnswer("**Fourth Interest Calculation**");
        for (int i = 8; i > 1; i--) {
            printAnswer("10,000 at " + i + "% interest = " + String.format("%.2f", calculateIntres(10000, 6.0)));
        }
        printAnswer("**Prime Number Calculation**");
        int number = 50;
        int start = 10;
        int countTimes = 10;
        int count = 0;
        for (int i = start; i < number; i++) {
            if (isPrime(i)) {
                count++;
                printAnswer(i + " is a prime number!");
                if (count >= countTimes) {
                    printAnswer("Found " + start + " prime numbers, exiting loop.");
                    break;
                }
            }
        }
    }

    public static boolean isPrime(int n) {
        if (n == 1) {
            return false;
        }
        for (int i = 2; i <= (long) Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static double calculateIntres(double amount, double interestRate) {
        return (amount * (interestRate / 100));
    }

    public static void printAnswer(String answer) {
        System.out.println(answer);
    }

}
