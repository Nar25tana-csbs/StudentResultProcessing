import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int n = sc.nextInt();  // Number of students
        sc.nextLine(); // consume leftover newline

        Student[] students = new Student[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for student " + (i + 1) + ":");

            System.out.print("Roll No: ");
            int rollNo = sc.nextInt();
            sc.nextLine(); // consume newline

            System.out.print("Name: ");
            String name = sc.nextLine();

            int[] marks = new int[5];
            for (int j = 0; j < 5; j++) {
                System.out.print("Enter marks for subject " + (j + 1) + ": ");
                marks[j] = sc.nextInt();
            }
            sc.nextLine(); // consume leftover newline

            students[i] = new Student(rollNo, name, marks);
        }

        System.out.println("\n************ STUDENT RESULTS ************\n");
        for (Student s : students) {
            s.displayResult();
        }

        sc.close();
    }
}