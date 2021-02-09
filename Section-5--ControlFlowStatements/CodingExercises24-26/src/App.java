public class App {
    public static void main(String[] args) {
        /*
         * if (canPack(1, 2, 6)) { System.out.println("True"); } else {
         * System.out.println("false"); }
         * 
         * printAnswer("largest prime: " + getLargestPrime(21));
         * printAnswer("largest prime: " + getLargestPrime(217));
         * printAnswer("largest prime: " + getLargestPrime(7));
         * printAnswer("largest prime: " + getLargestPrime(45));
         */
        printSquareStar(8);
    }

    /*
     * public static boolean canPack(int bigCount, int smallCount, int goal) { if
     * (bigCount * 5 + smallCount == goal) { return true; } else if (bigCount < 0 ||
     * smallCount < 0 || goal < 0) { return false; } else if (bigCount * 5 +
     * smallCount < goal) { return false; } else { for (int i = 0; i <= bigCount;
     * i++) { for (int j = 0; j <= smallCount; j++) { int total = 5 * i + j; if
     * (total == goal) { return true; } }
     * 
     * } return false; } }
     */
    public static int getLargestPrime(int number) {
        if (number < 2) {
            return -1;
        } else {
            int largestPrime = -1;
            int div = 2;
            while (number != 0) {
                if (number % div != 0) {
                    div++;
                } else {
                    int maxFact = number;
                    number = number / div;
                    if (number == 1) {
                        return maxFact;
                    }
                }
            }

            return largestPrime;
        }

    }

    public static void printSquareStar(int number) {
        int rowCount = number;
        int currentRow = 0;
        if (number < 5) {
            System.out.println("Invalid Value");
        } else {
            for (int i = 0; i < number; i++) {
                if (i == 0 || i == number - 1) {
                    for (int j = 0; j < number; j++) {
                        System.out.print("*");
                    }
                    System.out.println();
                    currentRow++;
                } else {
                    for (int j = 0; j < number; j++) {
                        if (j == 0 || j == currentRow || j == number - currentRow - 1 || j == number - 1) {
                            System.out.print("*");
                        } else {
                            System.out.print(" ");
                        }
                    }
                    System.out.println();
                    currentRow++;
                }
            }
        }

    }

    public static void printAnswer(String answer) {
        System.out.println(answer);
    }
}
