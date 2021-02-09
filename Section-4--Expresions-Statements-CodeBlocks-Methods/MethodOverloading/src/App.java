public class App {
    public static void main(String[] args) {
        System.out.println(calcFeetAndInchesToCentimeters(12));
        System.out.println(calcFeetAndInchesToCentimeters(13, 13));
        System.out.println(calcFeetAndInchesToCentimeters(-1, 2));
        System.out.println(calcFeetAndInchesToCentimeters(0, 0));
        System.out.println(calcFeetAndInchesToCentimeters(1, -12));
    }

    public static double calcFeetAndInchesToCentimeters(double feet, double inches) {
        double answer = -1;
        if (inches <= 12 && inches >= 0 && feet >= 0) {
            answer = (feet * 12 + inches) * 2.54;
        }
        return answer;
    }

    public static double calcFeetAndInchesToCentimeters(double inches) {
        double feet = inches / 12;
        double remainingInches = inches % 12;
        return calcFeetAndInchesToCentimeters(feet, remainingInches);
    }
}
