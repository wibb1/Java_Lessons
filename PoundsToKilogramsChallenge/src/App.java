public class App {
    public static void main(String[] args) {
        double lbToKg = 0.45359237d;
        double startingPounds = 200d;
        double endingKilos = startingPounds * lbToKg;
        System.out.println("Ending kilograms = " + endingKilos);

        double pi = 3.1415927d;
        double anotherNumber = 3_000_000.4_567_890d;
        System.out.println(pi);
        System.out.println(anotherNumber);

        // when big numbers are calculated float and double should not be used - BigDecimal will be taught later which will be how we calculate very large numbers
    }
}
