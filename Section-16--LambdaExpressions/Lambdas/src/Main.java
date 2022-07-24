import java.util.*;

public class Main {
    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println("Printing from the runnable");
            System.out.println("Line 2");
            System.out.format("This is line %d\n\n", 3);
        }).start();

        List<Employee> employees = new ArrayList<>();

        Employee john = new Employee("John", 15);
        Employee tim = new Employee("Tim", 200);
        Employee jack = new Employee("Jack", 12);
        Employee jill = new Employee("Jill", 12);

        employees.add(jack);
        employees.add(jill);
        employees.add(john);
        employees.add(tim);

//        Full Code Expression
//        Collections.sort(employees, new Comparator<Employee>() {
//            @Override
//            public int compare(Employee employee1, Employee employee2) {
//                return employee1.getName().compareTo(employee2.getName());
//            }
//        });
//      Lambda Expression - with inferred type (don't need to use Employee)
        Collections.sort(employees, (employee1, employee2) -> employee1.getName().compareTo(employee2.getName()));

//      Further simplification using just Comparator
//      Collections.sort(employees, Comparator.comparing(Employee::getName));

        for (Employee employee : employees) {
            System.out.println(employee.getName());
        }

//        String sillyString = doStringStuff(new UpperConcat() {
//            @Override
//            public String upperAndConcat(String s1, String s2) {
//                return s1.toUpperCase() + s2.toUpperCase();
//            }
//        }, employees.get(0).getName(), employees.get(1).getName());
//        System.out.println(sillyString);

        UpperConcat uc = (String s1, String s2) -> s1.toUpperCase(Locale.ROOT) + s2.toUpperCase(Locale.ROOT);
        String sillyString = doStringStuff(uc, employees.get(0).getName(), employees.get(1).getName());
        System.out.println(sillyString);
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
