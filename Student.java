import java.io.*;

public class Student implements Serializable {
    int rollNo;
    String name;
    int[] marks;     // marks of subjects
    int total;
    double average;
    String grade;

    // Constructor
    public Student(int rollNo, String name, int[] marks) {
        this.rollNo = rollNo;
        this.name   = name;
        this.marks  = marks.clone();  // safe copy
        calculateResult();            // automatically calculate when object is created
    }

    // Calculate total, average, grade
    void calculateResult() {
        total = 0;
        for (int m : marks) {
            total += m;
        }

        average = total / (double) marks.length;   // use marks.length for flexibility

        // Grading logic
        if (average >= 90) grade = "A+";
        else if (average >= 80) grade = "A";
        else if (average >= 70) grade = "B";
        else if (average >= 60) grade = "C";
        else if (average >= 50) grade = "D";
        else grade = "F";
    }
        public void displayResult() {
        System.out.println("=====================================");
        System.out.println("          STUDENT RESULT");
        System.out.println("=====================================");
        System.out.println("Roll No   : " + rollNo);
        System.out.println("Name      : " + name);
        System.out.println("Marks     : ");
        for (int i = 0; i < marks.length; i++) {
            System.out.println("  Subject " + (i+1) + " : " + marks[i]);
        }
        System.out.println("-------------------------------------");
        System.out.println("Total     : " + total);
        System.out.println("Average   : " + String.format("%.2f", average));
        System.out.println("Grade     : " + grade);
        System.out.println("=====================================\n");
    }
}