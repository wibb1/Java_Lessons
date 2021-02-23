public class Ford extends Car{
    
  public Ford(int cylinders, String name) {
    super(cylinders, name);
  }

  public String startEngine(){
    String text = "Ford -> startEngine()";
    return text;
  }

  public String accelerate(){
    String text = "Ford -> accelerate()";
    return text;
  }

  public String brake(){
    String text = "Ford -> brake()";
    return text;
  }
}
