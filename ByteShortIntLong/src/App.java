public class App {
    public static void main(String[] args) {
        int myValue = 10000;

        int myMinIntValue = Integer.MIN_VALUE;
        int myMaxIntValue = Integer.MAX_VALUE;
        System.out.println("Integer minimum value = " + myMinIntValue);
        System.out.println("Integer maximum value = " + myMaxIntValue);
        System.out.println("Busted MIN value = " + (myMinIntValue - 1));
        System.out.println("Busted MAX value = " + (myMaxIntValue + 1));
        
        int myMaxIntTest = 2_147_483_647; //Acceptable method to input a number
        System.out.println("myMaxIntTest = " + myMaxIntTest);

        byte myMinByteValue = Byte.MIN_VALUE;
        byte myMaxByteValue = Byte.MAX_VALUE;
        System.out.println("Byte minimum value = " + myMinByteValue);
        System.out.println("Byte maximum value = " + myMaxByteValue);

        short myMinShortValue = Short.MIN_VALUE;
        short myMaxShortValue = Short.MAX_VALUE;
        System.out.println("Short minimum value = " + myMinShortValue);
        System.out.println("Short maximum value = " + myMaxShortValue);

        long myLongValue = 2_147_483_648L;
        System.out.println("myLongValue = " + myLongValue);

        long myMinLongValue = Long.MIN_VALUE;
        long myMaxLongValue = Long.MAX_VALUE;
        System.out.println("Long minimum value = " + myMinLongValue);
        System.out.println("Long maximum value = " + myMaxLongValue);

        int myNewTotal = (myMinIntValue / 2);

        byte myNewByteValue = (byte)(myMinByteValue / 2);

        short myNewMinShortValue = (short) (myMinShortValue / 2);
    }
}
