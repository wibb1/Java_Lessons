public class App {
    public static void main(String[] args) throws Exception {
        byte byteOne = 10;
        short shortOne = 20;
        int intOne = 50;
        long longOne = (50000 + 10 * (byteOne + shortOne + intOne));
        short shortTotal = (short)(longOne);
        System.out.println("Byte value = " + byteOne);
        System.out.println("Short value = " + shortOne);
        System.out.println("Int value = " + intOne);
        System.out.println("Long value = " + longOne);
        System.out.println("ShortTotal value = " + shortTotal);
    }
}
