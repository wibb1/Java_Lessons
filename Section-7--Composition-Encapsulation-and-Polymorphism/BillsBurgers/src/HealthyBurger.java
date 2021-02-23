public class HealthyBurger extends Hamburger {
  private String healthyExtra1Name = "";
  private double healthyExtra1Price = 0;
  private String healthyExtra2Name = "";
  private double healthyExtra2Price = 0;

  public HealthyBurger(String meat, double price){
    super("Healthy", meat, price, "Brown rye");
    this.healthyExtra1Name = "";
    this.healthyExtra1Price = 0;
    this.healthyExtra2Name = "";
    this.healthyExtra2Price = 0;
  }
  
  public void addHealthyAddition1(String name, double price) {
    healthyExtra1Name = name;
    healthyExtra1Price = price;
    if (!healthyExtra1Name.equals("") && healthyExtra1Price != 0) {
      System.out.println("Added " + healthyExtra1Name + " for an extra " + healthyExtra1Price);
    }
  }
 
  public void addHealthyAddition2(String name, double price) {
    healthyExtra2Name = name;
    healthyExtra2Price = price;
    if (!healthyExtra2Name.equals("") && healthyExtra2Price != 0) {
      System.out.println("Added " + healthyExtra2Name + " for an extra " + healthyExtra2Price);
    }
  }

  @Override
  public double itemizeHamburger() {
    return super.itemizeHamburger() + healthyExtra1Price + healthyExtra2Price;
  }
}
