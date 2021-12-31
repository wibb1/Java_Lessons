import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Button btnPrint = new Button("Print");

    public static void main(String[] args) {
//        Local class example
//        class ClickListener implements Button.OnClickListener {
//            public ClickListener() {
//                System.out.println("I've been attached");
//            }
//
//            @Override
//            public void onClick(String title) {
//                System.out.println(title + " was clicked");
//            }
//        }
//
//        btnPrint.setOnClickListener(new ClickListener());
        
        btnPrint.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(String title) {
                System.out.println(title + " was clicked");
            }
        });
        listen();

        /*
        Gearbox mcLaren = new Gearbox(6);
        mcLaren.operateClutch(true);
        mcLaren.changeGear(1);
        mcLaren.operateClutch(false);
        System.out.println(mcLaren.wheelSpeed(1000));
        mcLaren.changeGear(2);
        System.out.println(mcLaren.wheelSpeed(1000));
        mcLaren.operateClutch(true);
        mcLaren.changeGear(3);
        mcLaren.operateClutch(false);
        System.out.println(mcLaren.wheelSpeed(6000));

        /* used before making the Gear class private - Gear should be private if it is made inside another class
        Gearbox.Gear first = mcLaren.new Gear(1,12.3);
        * Following will not work:
        * Gearbox.Gear second = new Gearbox.Gear(2,15.4);
        * Gearbox.Gear second = new mcLaren.Gear(2,15.4);
        *
        Gearbox.Gear second = mcLaren.new Gear(2,15.4);
        Gearbox.Gear third = mcLaren.new Gear(3,17.8);
        Gearbox.Gear fourth = mcLaren.new Gear(4,12.3);
        Gearbox.Gear fifth = mcLaren.new Gear(5,12.3);
        Gearbox.Gear sixth = mcLaren.new Gear(6,12.3);
        System.out.println(first.driveSpeed(1000));
        */


    }

    public static void listen() {
        boolean quit = false;
        while (!quit) {
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    btnPrint.onClick();

            }
        }
    }
}
