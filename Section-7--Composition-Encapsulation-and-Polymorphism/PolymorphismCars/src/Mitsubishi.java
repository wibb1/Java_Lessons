public class Mitsubishi extends Car{
  
  public Mitsubishi(int cylinders, String name) {
    super(cylinders, name);
  }

  public String startEngine(){
    String text = "Mitsubishi -> startEngine()";
    return text;
  }

  public String accelerate(){
    String text = "Mitsubishi -> accelerate()";
    return text;
  }

  public String brake(){
    String text = "Mitsubishi -> brake()";
    return text;
  }
}
