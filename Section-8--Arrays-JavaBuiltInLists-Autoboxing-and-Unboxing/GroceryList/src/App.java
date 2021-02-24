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

    public static void addItem(){
        System.out.println("Please enter the grocery item");
        groceryList.addGroceryItem(scanner.nextLine());
    }

    public static void modifyItem(){
        System.out.println("Enter item number");
        int itemNumber = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter replacement item: ");
        String itemName = scanner.nextLine();
        groceryList.modifyGroceryItem(itemNumber-1, itemName);
    }

    public static void removeItem() {
        System.out.println("Which item would you like to remove: ");
        int itemNumber = scanner.nextInt();
        scanner.nextLine();
        groceryList.removeGroceryItem(itemNumber-1);
    }

    public static void searchForItem(){
        System.out.println("Enter the item name: ");
        String searchItem = scanner.nextLine();
        if(groceryList.findItem(searchItem) != null){
            System.out.println("Found " + searchItem + " in your shopping list");
        } else {
            System.out.println(searchItem + " is not in the shopping list.");
        }
    }
}
