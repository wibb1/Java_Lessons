public class Floor {
  private double width;
  private double length;

  public Floor(double number1,double number2) {
    this.length=(number1<0) ? 0 : number1;
    this.width=(number2<0) ? 0 : number2;
  }

  public double getArea(){
    return width * length;
  }
}
