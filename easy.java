import java.util.*;

class Employee {
    String name;
    int age;
    double salary;

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{name='" + name + "', age=" + age + ", salary=" + salary + "}";
    }
}

public class easy {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Vivek Garg", 21, 60000));
        employees.add(new Employee("Mayank Sharma", 20, 55000));
        employees.add(new Employee("Kushan Jigyasu", 21, 50000));

        employees.sort(Comparator.comparing(emp -> emp.name));
        System.out.println("Sorted by Name:");
        printEmployees(employees);

        employees.sort(Comparator.comparingInt(emp -> emp.age));
        System.out.println("\nSorted by Age:");
        printEmployees(employees);

        employees.sort(Comparator.comparingDouble(emp -> emp.salary));
        System.out.println("\nSorted by Salary:");
        printEmployees(employees);
    }

    private static void printEmployees(List<Employee> employees) {
        for (Employee emp : employees) {
            System.out.println(emp);
        }
    }
}
