package com.willcampbell._static;

public class Main {
    public static int multiplier = 7;

    public static void main(String[] args) {
//        StaticTest firstInstance = new StaticTest("1st instance");
//        System.out.println(firstInstance.getName() + " created.  There are " + firstInstance.getNumInstances() + " total instances");
//        StaticTest secondInstance = new StaticTest("2nd instance");
//        System.out.println(secondInstance.getName() + " created.  There are " + secondInstance.getNumInstances() + " total instances");
//        // because this getNumInstances refers to the total instances and there is only one instance variable per class you can call any class to get the value.
//        StaticTest thirdInstance = new StaticTest("3rd instance");
//        System.out.println(thirdInstance.getName() + " created.  There are " + StaticTest.getNumInstances() + " total instances");
//        // by changing the method to public static int getNumInstances() from public int getNumInstances() you can use the class name and method which is clearer.
//        int answer = multiply(6); // non-static methods cannot be referenced from a static field without a class because static methods are built with the compiler non-static methods are built with the class
        SomeClass one = new SomeClass("one");
        SomeClass two = new SomeClass("two");
        SomeClass three = new SomeClass("three");

        System.out.println(one.getInstanceNumber());
        System.out.println(two.getInstanceNumber());
        System.out.println(three.getInstanceNumber());

//        one.instanceNumber = 4; // cannot do this even though the value is public when variable is set to final
        System.out.println(Math.PI); // this is a static final double
//        package constants use "public static final"
//        Math m = new Math() // can't do this because the class itself is marked final and the constructor is private
        int pw = 674312;
        Password password = new ExtendedPassord(pw);
        password.storePassword();

        password.letMeIn(0);
        password.letMeIn(-1);
        password.letMeIn(849578);
        password.letMeIn(674312);

        System.out.println("Main method called");
        SIBTest test = new SIBTest();
        test.someMethod();
        System.out.println("Owner is " + SIBTest.owner);
    }

    public static int multiply(int number) {
        return number * multiplier;
    }
}
