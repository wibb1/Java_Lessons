public class App {
    public static void main(String[] args) {
        //all points made to this point were the same as other languages
        // bitwise vs logical operators && and || are logical operators and function the same as other languages
        // & and | are bitwise operators which are different and will be discussed later
        double variable1 = 20.00;
        double variable2 = 80.00;
        double variable3 = (variable1 + variable2) * 100;
        System.out.println("varable3 is " + variable3);
        double variable4 = variable3 % 40.00;
        boolean boolVariable = (variable4 == 0);
        System.out.println("boolVariable is " + boolVariable);
        if (!boolVariable) {
            System.out.println("Got some remainder");
        }
    }
}
