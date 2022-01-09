package com.willcampbell._static;

public class ExtendedPassord extends Password {
    private int decryptedPassword;

    public ExtendedPassord(int password) {
        super(password);
        this.decryptedPassword = password;
    }

//    @Override - prevented by adding final to the class in Password class
//    public void storePassword() {
//        System.out.println("Saving password as " + this.decryptedPassword);
//    }
}
