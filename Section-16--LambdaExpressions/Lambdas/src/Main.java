public class Main {
    public static void main(String[] args) {
        // Thread is a "functional interface" - interface with only one method that has to be implemented
        // First attempt with secondary function
        new Thread((new CodeToRun())).start();
        // Second with function inside Thread
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Printing from the Runnable #2");
            }
        }).start();
        // Lambda expression
        new Thread(()-> {
            System.out.println("Printing from the runnable #3");
        }).start();
    }
}

class CodeToRun implements Runnable {
    @Override
    public void run() {
        System.out.println("From Runnable #1");
    }
}
