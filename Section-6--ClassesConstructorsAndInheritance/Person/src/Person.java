public class Person {
  private String firstName;
  private String lastName;
  private int age;

  public void setFirstName(String name) {
    firstName = name;
  }

  public void setLastName(String name) {
    lastName = name;
  }

  public void setAge(int number) {
    if (number < 0 || number > 100 ) {
      age=0;
    } else {
      age = number;
    }
  }

  public int getAge() {
    return age;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getFullName() {
    if (firstName.isEmpty() && lastName.isEmpty()) {
      return "";
    } else if (firstName.isEmpty()) {
      return lastName;
    } else if (lastName.isEmpty()) {
      return firstName;
    } else {
      return firstName + " " + lastName;
    }
  }

  public boolean isTeen() {
    return (age > 12 && age < 20);
  }
}