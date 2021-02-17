public class Wall {
  private double width;
  private double height;

  public Wall() {
    this.height = 0;
    this.width = 0;
  }

  public Wall(double width, double height) {
    this.width = width > 0 ? width : 0;
    this.height = height > 0 ? height : 0;
  }

  public void setHeight(double number) {
    height = (number > 0) ? number : 0;
  }

  public void setWidth(double number) {
    width = (number > 0) ? number : 0;
  }

  public double getHeight() {
    return height;
  }

  public double getWidth() {
    return width;
  }

  public double getArea() {
    return this.width * this.height;
  }
}
