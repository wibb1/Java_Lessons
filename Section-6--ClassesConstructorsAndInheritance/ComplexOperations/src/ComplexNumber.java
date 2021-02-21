import javax.security.sasl.RealmCallback;

public class ComplexNumber {
  private double real;
  private double imaginary;

  public ComplexNumber(double number1, double number2) {
    real = number1;
    imaginary = number2;
  }

  public double getReal(){
    return real;
  }

  public double getImaginary() {
    return imaginary;
  }

  public void add(double real, double imaginary){
    this.real += real;
    this.imaginary += imaginary;
  }

  public void add(ComplexNumber complex){
    this.real += complex.real;
    this.imaginary += complex.imaginary;
  }

  public void subtract(double real, double imaginary){
    this.real -= real;
    this.imaginary -= imaginary;
  }

  public void subtract (ComplexNumber complex){
    this.real -= complex.real;
    this.imaginary -= complex.imaginary;
  }

}
