public class Car {
  private boolean engine;
  private int cylinders; 
  private String name;
  private int wheels;

  public Car(int cylinders, String name){
    this.cylinders = cylinders;
    this.name = name;
    this.wheels = 4;
    this.engine = true;
  }

  public int getCylinders() {
    return cylinders;
  }

  public String getName() {
    return name;
  }

  public String startEngine(){
    String text = "Car -> startEngine()";
    return text;
  }

  public String accelerate(){
    String text = "Car -> accelerate()";
    return text;
  }

  public String brake(){
    String text = "Car -> brake()";
    return text;
  }
}
