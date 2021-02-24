import java.util.ArrayList;

public class GroceryList {
  private ArrayList<String> groceryList = new ArrayList<>();

  public void addGroceryItem(String item) {
    groceryList.add(item);
  }

  public ArrayList<String> getGroceryList(){
    return groceryList;
  }

  public void printGroceryList() {
    System.out.println("You have " + groceryList.size() + " items in your grocery list");
    for (int i = 0; i < groceryList.size(); i++) {
      System.out.println((i + 1 + ". " + groceryList.get(i)));
    }
  }

  public void modifyGroceryItem(String currentItem, String newItem) {
    int position = findItem(currentItem);
    if (position >= 0) {
      modifyGroceryItem(position, newItem);
      System.out.println(currentItem + " has been removed and replaced with " + newItem);
    } else {
      System.out.println(currentItem + " is not on your list");
    }
  }

  private void modifyGroceryItem(int position, String newItem) {
    groceryList.set(position, newItem);
  }

  public void removeGroceryItem(String item) {
    int position = findItem(item);
    if (position >= 0) {
      removeGroceryItem(position);
    } else {
      System.out.println("Item not on your list");
    }
  }

  private void removeGroceryItem(int position) {
    String theItem = groceryList.get(position);
    groceryList.remove(position);
    System.out.println(theItem + " was removed from the list.");
  }

  public int findItem(String searchItem) {
    return groceryList.indexOf(searchItem);
  }

  public boolean onFile(String searchItem) {
    int position = findItem(searchItem);
    return position >= 0;
  }
}