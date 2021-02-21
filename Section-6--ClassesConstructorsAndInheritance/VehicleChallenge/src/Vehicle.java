public class Vehicle {
  private String name;
  private String size;
  private int currentSpeed;
  private int currentDirection;

  public Vehicle(String name, String size) {
    this.name = name;
    this.size = size;
    this.currentSpeed = 0;
    this.currentDirection = 0;
  }

  public void setCurrentSpeed(String speedChange) {
    if (speedChange.equals("slower")) {
      currentSpeed -= 10;
    } else if (speedChange.equals("stop")) {
      currentSpeed = 0;
    } else if (speedChange.equals("faster")) {
      currentSpeed += 10;
    } else {
      System.out.println("Vehicle.setCurrentSpeed: Incorrect request: requests can only include 'slower', 'faster', or 'stop'");
    }
    System.out.println("Vehicle.setCurrentSpeed: Speed set to " + currentSpeed);
  }

  public void setCurrentSpeed(int speed) {
    currentSpeed = speed;
    System.out.println("Vehicle.setCurrentSpeed(): setting speed to " + currentSpeed);
  }

  public void steering(int degrees) {
    int newdirection = getCurrentDirection() + degrees;
    currentDirection = (newdirection > 360) ? (newdirection - 360) : (newdirection);
    System.out.println("Vehicle.steering(): Steering at " + currentDirection + " degrees");
  }

  public void steering(int degrees, char direction) {
    int newDirection;
    if (direction == 'r' || direction == 'R') {
      newDirection = currentDirection + degrees;
      currentDirection = (newDirection > 360) ? (newDirection - 360) : (newDirection);
    } else if (direction == 'l' || direction == 'L') {
      newDirection = currentDirection - degrees;
      currentDirection = (newDirection < 0) ? (newDirection + 360) : (newDirection);
    } else {
      System.out.println("Incorrect direction: Right(R or r) and Left(L or l) only");
    }
    System.out.println("Vehicle.steering(): Steering at " + currentDirection + " degrees");
  }

  public void move(int speed, int degrees){
    currentSpeed = speed;
    currentDirection = degrees;
    System.out.println("Vehicle.move(): Moving at " + currentSpeed + " in direction " + currentDirection);
  }
  
  public String getName() {
    return name; 
  }
  
  public String getSize() {
    return size; 
  }

  public int getCurrentSpeed() {
    return currentSpeed;
  }

  public int getCurrentDirection() {
    return currentDirection;
  }

}
