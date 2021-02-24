import java.util.Scanner;

public class App {
    private static Scanner scanner = new Scanner(System.in);
    private static GroceryList groceryList = new GroceryList();

    public static void main(String[] args) {
        boolean quit = false;
        int choice = 0;
        printInstructions();
        while (!quit) {
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    printInstructions();
                    break;
                case 1:
                    groceryList.printGroceryList();
                    break;
                case 2:
                    addItem();
                    break;
                case 3:
                    modifyItem();
                    break;
                case 4:
                    removeItem();
                    break;
                case 5:
                    searchForItem();
                    break;
                case 6:
                    quit = true;
                    break;
                default:
                    System.out.println("Error");
            }
        }
    }

    public static void printInstructions() {
        System.out.println("\nPress ");
        System.out.println("\t 0 - To print choice options.");
        System.out.println("\t 1 - To print the list of grocery items.");
        System.out.println("\t 2 - To add a grocery item.");
        System.out.println("\t 3 - To change a grocery item.");
        System.out.println("\t 4 - To remove a grocery item.");
        System.out.println("\t 5 - To serach for a grocery item.");
        System.out.println("\t 6 - To quit the application.");
    }

    public static void addItem() {
        System.out.println("Enter the grocery item name:");
        groceryList.addGroceryItem(scanner.nextLine());
    }

    public static void modifyItem() {
        System.out.println("Enter current item name:");
        String itemName = scanner.nextLine();
        System.out.println("Enter replacement item name: ");
        String replacementName = scanner.nextLine();
        groceryList.modifyGroceryItem(itemName, replacementName);
    }

    public static void removeItem() {
        System.out.println("What item name would you like to remove: ");
        String itemName = scanner.nextLine();
        groceryList.removeGroceryItem(itemName);
    }

    public static void searchForItem() {
        System.out.println("Enter the item name: ");
        String itemName = scanner.nextLine();
        if (groceryList.onFile(itemName)) {
            System.out.println("Found " + itemName + " in your shopping list");
        } else {
            System.out.println(itemName + " is not in the shopping list.");
        }
    }
}
