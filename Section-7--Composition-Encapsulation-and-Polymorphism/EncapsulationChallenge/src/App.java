public class App {
    public static void main(String[] args) {
        Printer printer1 = new Printer(false);
        System.out.println("***********************");
        printer1.printPages(50);
        printer1.fillToner();
        printer1.printPages(10100);
        System.out.println("***********************");

        Printer printer2 = new Printer(true);
        System.out.println("***********************");
        printer2.printPages(50);
        printer2.fillToner();
        printer2.printPages(10100);
        System.out.println("***********************");
    }
}
