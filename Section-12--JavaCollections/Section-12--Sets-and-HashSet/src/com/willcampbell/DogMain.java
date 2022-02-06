package com.willcampbell;

public class DogMain {
    public static void main(String[] args) {
        Labrador rover = new Labrador("Rover");
        Dog rover2 = new Dog("Rover");


        System.out.println(rover2.equals(rover)); // step 1
        System.out.println(rover.equals(rover2)); // step 2

        // when the euqlas method is not final in Dog and it is overridden in Labrador
        // you get the following results
        //      violates the rules for equals because they do not return the same value
        //      step 1 = true - Labrador is an instance of Dog
        //      step 2 = false - Dog is not an instance of Labrador

        // without overriding the equals method in Labrador you get the following results
        //      step 1 = true - Dog (Labrador) is an instance of Dog
        //      step 2 = true - Dog is not an instance of Dog (Labrador)

        // to ensure the equals cannot be overwritten it should be designated as final in Dog
    }
}
