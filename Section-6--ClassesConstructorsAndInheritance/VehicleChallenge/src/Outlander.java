public class Outlander extends Car {
  private int roadServiceMonths;

  public Outlander(int roadServiceMonths) {
    super("Outlander", "4WD", 4, 4, 5, false);
    this.roadServiceMonths = roadServiceMonths;
  }

  public int getRoadServiceMonths() {
    return roadServiceMonths;
  }

  public void setRoadServiceMonths(int roadServiceMonths) {
    this.roadServiceMonths = roadServiceMonths;
    System.out.println("Outlander.setRoadServiceMonths(): Resetting road service months to " + roadServiceMonths);
  }

  
}
