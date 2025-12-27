package bai1;

public class Main {
    public static void main(String[] args) {
        System.out.println("Initial count: " + Student.getStudentCount());

        Student student1 = new Student("S001", "John Doe", 8.5);
        Student student2 = new Student("S002", "Alice Smith", 9.0);
        Student student3 = new Student("S003", "Bob Johnson", 7.5);

        System.out.println("Created: " + student1.getName());
        System.out.println("Created: " + student2.getName());
        System.out.println("Created: " + student3.getName());

        System.out.println("Total students: " + Student.getStudentCount());
    }
}