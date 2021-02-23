public class App {
    public static void main(String[] args) {
        Printer printer1 = new Printer(false);
        System.out.println("\n");
        printer1.printPages(50);
        printer1.fillToner();
        printer1.printPages(10100);
        System.out.println("\n");
    }
}
