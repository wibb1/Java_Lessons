import java.util.*;

public class Main {
    public static void main(String[] args) {

        Employee john = new Employee("John", 15);
        Employee tim = new Employee("Tim", 200);
        Employee jack = new Employee("Jack", 12);
        Employee jill = new Employee("Jill", 12);

        List<Employee> employees = new ArrayList<>();
        employees.add(jack);
        employees.add(jill);
        employees.add(john);
        employees.add(tim);

        employees.forEach(employee -> {
            System.out.println(employee.getName());
            System.out.println(employee.getAge());
        });
//
//        for (Employee employee : employees) {
//            System.out.println(employee.getName());
//            new Thread(() -> System.out.println(employee.getAge())).start();
//        }
//
//        System.out.println("******************************************");
//
//        for (int i = 0; i < employees.size(); i++) {
//            System.out.println(employees.get(i).getName());
//            // have to set the employee instance to ensure it does not change =>
//            // can't use employees.get(i).getAge() within the Lambda
//            Employee employee = employees.get(i);
//            new Thread(() -> System.out.println(employee.getAge())).start();
//        }
    }

    public final static String doStringStuff(UpperConcat uc, String s1, String s2) {
        return uc.upperAndConcat(s1, s2);
    }
}

class Employee {
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

interface UpperConcat {
    public String upperAndConcat(String s1, String s2);
}

class AnotherClass {
    public String doSomething() {
        int i = 0;

        UpperConcat uc = (s1, s2) -> {
            System.out.println("The Lambdas expression's name is: " + getClass().getSimpleName());
            System.out.format("i in the lambda expression is: %d\n\n", i);
            String result = s1.toUpperCase(Locale.ROOT) + s2.toUpperCase(Locale.ROOT);
            return result;
        };

        System.out.println("The AnotherClass class's name is: " + getClass().getSimpleName());
        return Main.doStringStuff(uc, "String1", "String 2");

    }


}
