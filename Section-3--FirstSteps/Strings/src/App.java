public class App {
    public static void main(String[] args) {
        //btye
        //short
        //int
        //long
        //short
        //double
        //float
        //char
        //boolean
        String myString = "This is a string";
        System.out.println("myString is equal to " + myString);
        myString = myString + ", and this is more.";
        System.out.println("myString is equal to " + myString);
        myString = myString + " \u00A9 2019";
        System.out.println("myString is equal to " + myString);
        String numberString = "250.55";
        numberString = numberString + "49.95";
        System.out.println("myString is equal to " + numberString);
        String lastString = "10";
        int myInt = 50;
        lastString = lastString + myInt;
        System.out.println("lastString is equal to " + lastString);
        double myDouble = 120.47d;
        lastString = lastString + myDouble;
        System.out.println("lastString is equal to " + lastString);

        // Strings in java are a class and are immutable -- when changing a string above you are using the existing value of the string adding to it then saving the entire new string to the variable -- this is ineffiecient appending values is better which will be shown ater in the course
    }
}
