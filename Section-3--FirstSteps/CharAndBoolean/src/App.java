public class App {
    public static void main(String[] args) {
        char myChar = 'D'; //char cannot use "" it must use '' - can only store a single character or ';' '\n' '0'
        char myUnicodeCharacter = '\u0044';
        System.out.println(myChar);
        System.out.println(myUnicodeCharacter);
        char myCopywriteCharacter = '\u00A9';
        System.out.println(myCopywriteCharacter);

        boolean myTrueBool = true;
        boolean myFalseBool = false;

        boolean isCustomerOverTwentyOne = true;
    }
}
