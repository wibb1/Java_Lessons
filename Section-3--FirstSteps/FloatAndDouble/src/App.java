public class App {
    public static void main(String[] args) {
        float myFloatValue = 10000F;
        System.out.println("Raw Float Value = " + myFloatValue);

        float myMinFloatValue = Float.MIN_VALUE;
        System.out.println("Min Float Value = " + myMinFloatValue);

        float myMaxFloatValue = Float.MAX_VALUE;
        System.out.println("Max Float Value = " + myMaxFloatValue);

        double myDoubleValue = 10000D;
        System.out.println(myDoubleValue);

        double myMinDoubleValue = Double.MIN_VALUE;
        System.out.println("Min Double Value = " + myMinDoubleValue);

        double myMaxDoubleValue = Double.MAX_VALUE;
        System.out.println("Max Double Value = " + myMaxDoubleValue);

        int myIntValue = 5 / 3;
        // float myFloatValue2 = (float) 5 / 2;// don't use
        float myFloatValue2 = 5f / 3f; // use this but floats are not used much anymore
        double myDoubleValue2 = 5d / 3d; // good practice to put the d after even if it is not required
        System.out.println("MyIntValue = " + myIntValue);
        System.out.println("MyFloatValue = " + myFloatValue2);
        System.out.println("MyDoubleValue = " + myDoubleValue2);
    }
}
