public class Holden extends Car{
    
  public Holden(int cylinders, String name) {
    super(cylinders, name);
  }

  public String startEngine(){
    String text = "Holden -> startEngine()";
    return text;
  }

  public String accelerate(){
    String text = "Holden -> accelerate()";
    return text;
  }

  public String brake(){
    String text = "Holden -> brake()";
    return text;
  }
}
