public class Car extends Vehicle {
  private int wheels;
  private int doors;
  private int gears;
  private boolean isManual;

  private char currentGear = 'p';

  public Car(String name, String size, int wheels, int doors, int gears, boolean isManual) {
    super(name, size);
    this.wheels = wheels;
    this.doors = doors;
    this.gears = gears;
    this.isManual = isManual;
    this.currentGear = 'p';
  }

  public void move(int speed, int degrees){
    setCurrentSpeed(speed);
    steering(degrees);
    changeGear(speed);
    System.out.println("Car.move(): Moving at " + getCurrentSpeed() + " in direction " + getCurrentDirection() + " and current gear is " + getCurrentGear());
  }

  public void accelerate(int speed) {
    setCurrentSpeed(speed);
    changeGear(speed);
    System.out.println("Car.accelerate(): Current speed = " + getCurrentSpeed() + " and Current gear = " + getCurrentGear());
  }
  public void accelerate(String speed){
    setCurrentSpeed(speed);
    changeGear(getCurrentSpeed());
    System.out.println("Car.accelerate(): Current speed = " + getCurrentSpeed() + " and Current gear = " + getCurrentGear());
  }
  private void changeGear(char gear) {
    char[] charArray = new char[] { '1', '2', '3', '4', '5', 'r', 'p' };
    if (new String(charArray).indexOf(gear) == -1) {
      System.out.println("Incorrect Gear Input");
    } else {
      currentGear = gear;
      if (currentGear == '1') {
        setCurrentSpeed(20);
      } else if (currentGear == '2') {
        setCurrentSpeed(30);
      } else if (currentGear == 'r') {
        setCurrentSpeed(0);
      } else if (currentGear == '3') {
        setCurrentSpeed(40);
      } else if (currentGear == '4') {
        setCurrentSpeed(50);
      } else if (currentGear == '5') {
        setCurrentSpeed(60);
      } else if (currentGear == 'p') {
        setCurrentSpeed(0);
      } else {
        System.out.println("Error: Incorrect Gear Input");
      }
    }
    System.out.println("Car.setCurrentGear(): Changed gear to " + this.currentGear);
  }

  private void changeGear(int currentSpeed) {
    if (currentSpeed > 0 && currentSpeed <= 15) {
      currentGear = '1';
    } else if (currentSpeed > 15 && currentSpeed <= 30) {
      currentGear = '2';
    } else if (currentSpeed > 30 && currentSpeed <= 45) {
      currentGear = '3';
    } else if (currentSpeed > 45 && currentSpeed <= 55) {
      currentGear = '4';
    } else if (currentSpeed > 55) {
      currentGear = '5';
    } else if (currentSpeed < 0) {
      currentGear = 'r';
    } else {
      currentGear = 'p';
    }
    System.out.println("Car.setCurrentGear(): Changed gear to " + currentGear);
  }

  public char getCurrentGear() {
    return currentGear;
  }

  public int getWheels() {
    return wheels;
  }

  public int getDoors() {
    return doors;
  }

  public int getGears() {
    return gears;
  }

  public boolean getIsManual() {
    return isManual;
  }
}
