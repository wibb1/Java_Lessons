public class Carpet {
  private double cost;

  public Carpet(double number){
    cost = (number<0)?0:number;
  }

  public double getCost() {
    return cost;
  }
}
