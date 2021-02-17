public class Point {
  private int x;
  private int y;

  public Point() {
    setX(0);
    setY(0);
  }

  public Point(int number1, int number2) {
    setX(number1);
    setY(number2);
  }

  public void setX(int number) {
    this.x = number;
  }

  public void setY(int number) {
    this.y = number;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public double distance() {
    return Math.sqrt(getX() * getX() + getY() * getY());
  }

  public double distance(int number1, int number2) {
    return Math.sqrt(Math.pow((getX() - number1), 2) + Math.pow((getY() - number2), 2));
  }

  public double distance(Point point) {
    return Math.sqrt(Math.pow((getX() - point.getX()), 2) + Math.pow((getY() - point.getY()), 2));
  }
}
