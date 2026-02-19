import java.io.*;

public class Student implements Serializable {
    int rollNo;
    String name;
    int marks[] = new int[5];
    int total;
    double average;
    String grade;

    Student(int rollNo, String name, int marks[]) {
        this.rollNo = rollNo;
        this.name = name;
        this.marks = marks;
        calculateResult();
    }

    void calculateResult() {
        total = 0;
        for(int i=0;i<5;i++)
            total += marks[i];

        average = total / 5.0;

        if(average >= 90)
            grade = "A";
        else if(average >= 75)
            grade = "B";
        else if(average >= 50)
            grade = "C";
        else
            grade = "Fail";
    }

    void display() {
        System.out.println(rollNo + " " + name + " " + total + " " + average + " " + grade);
    }

    void display(boolean failedOnly) {
        if(grade.equals("Fail"))
            display();
    }
}
