public class Lamp {
  private String style;
  private boolean battery;
  private int globeRating;

  public Lamp(String style, boolean battery, int globeRating) {
    this.battery = battery;
    this.globeRating = globeRating;
    this.style = style;
  }

  public void turnOn() {
    System.out.println("Lamp => turning on");
  }

  public int getGlobeRating() {
    return globeRating;
  }

  public String getStyle() {
    return style;
  }

  public boolean isBattery() {
    return battery;
  }

}
