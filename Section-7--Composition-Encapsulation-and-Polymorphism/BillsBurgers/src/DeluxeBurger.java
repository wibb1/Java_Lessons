public class DeluxeBurger extends Hamburger {
  private static final String DELUXE_TEXT = "Cannot add additional items to a deluxe burger";

  public DeluxeBurger() {
    super("Deluxe", "Sausage and Bacon", 19.10, "White");
  }

  @Override
  public void addHamburgerAddition1(String name, double price) {
    System.out.println(DELUXE_TEXT);
  }

  @Override
  public void addHamburgerAddition2(String name, double price) {
    System.out.println(DELUXE_TEXT);
  }

  @Override
  public void addHamburgerAddition3(String name, double price) {
    System.out.println(DELUXE_TEXT);
  }

  @Override
  public void addHamburgerAddition4(String name, double price) {
    System.out.println(DELUXE_TEXT);
  }
}
