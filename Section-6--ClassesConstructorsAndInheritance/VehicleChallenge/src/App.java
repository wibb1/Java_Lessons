public class App {
    public static void main(String[] args) {
        Outlander outlander = new Outlander(36);
        System.out.println("\noutlander.accelerate(30)");
        outlander.accelerate(30);
        System.out.println("\noutlander.move(50,30)");
        outlander.move(50,30);
        System.out.println("\noutlander.steering(50)");
        outlander.steering(50);
        System.out.println("\noutlander.steering(10, 'l')");
        outlander.steering(10, 'l');
        System.out.println("\noutlander.steering(90,'l');");
        outlander.steering(90,'l');
        System.out.println("\noutlander.accelerate('faster');");
        outlander.accelerate("faster");
        System.out.println("\noutlander.accelerate('stop');");
        outlander.accelerate("stop");
        System.out.println("");
    }
}
