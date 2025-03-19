import java.util.*;
import java.util.stream.Collectors;

class Student {
    private String name;
    private double marks;

    public Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public double getMarks() {
        return marks;
    }
}

public class medium {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Vivek Garg", 85));
        students.add(new Student("Mayank Sharma", 70));
        students.add(new Student("Kushan Jigyasu", 88));
        students.add(new Student("Ansh Panwar", 60));
        students.add(new Student("Kamal Sharma", 80));

        List<String> filteredStudentNames = students.stream()
            .filter(student -> student.getMarks() > 75)
            .sorted(Comparator.comparingDouble(Student::getMarks).reversed())
            .map(Student::getName)
            .collect(Collectors.toList());

        System.out.println("Students scoring above 75% sorted by marks:");
        for (String name : filteredStudentNames) {
            System.out.println(name);
        }
    }
}
