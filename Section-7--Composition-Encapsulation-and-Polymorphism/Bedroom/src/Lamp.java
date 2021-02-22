public class Lamp {
  private String style;
  private boolean battery;
  private int globRating;

  public Lamp(String style, boolean battery, int globRating) {
    this.battery = battery;
    this.globRating = globRating;
    this.style = style;
  }

  public void turnOn() {
    System.out.println("Lamp => turning on");
  }

  public int getGlobRating() {
    return globRating;
  }

  public String getStyle() {
    return style;
  }

  public boolean isBattery() {
    return battery;
  }

}
