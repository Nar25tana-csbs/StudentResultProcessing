import java.io.*;
import java.util.*;

public class Main {

    static ArrayList<Student> list = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String args[]) {

        int choice;

        do {

            System.out.println("\n1.Add Student");
            System.out.println("2.Display All");
            System.out.println("3.Display Failed");
            System.out.println("4.Save to File");
            System.out.println("5.Read from File");
            System.out.println("6.Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch(choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    displayAll();
                    break;

                case 3:
                    displayFailed();
                    break;

                case 4:
                    saveToFile();
                    break;

                case 5:
                    readFromFile();
                    break;

            }

        } while(choice != 6);
    }

    static void addStudent() {

        System.out.print("Roll No: ");
        int roll = sc.nextInt();

        sc.nextLine();

        System.out.print("Name: ");
        String name = sc.nextLine();

        int marks[] = new int[5];

        for(int i=0;i<5;i++) {
            System.out.print("Mark " + (i+1) + ": ");
            marks[i] = sc.nextInt();
        }

        Student s = new Student(roll,name,marks);
        list.add(s);
    }

    static void displayAll() {

        for(Student s : list)
            s.display();
    }

    static void displayFailed() {

        for(Student s : list)
            s.display(true);
    }

    static void saveToFile() {

        try {

            ObjectOutputStream out =
            new ObjectOutputStream(
            new FileOutputStream("students.dat"));

            out.writeObject(list);

            out.close();

            System.out.println("Saved successfully");

        } catch(Exception e) {
            System.out.println(e);
        }
    }

    static void readFromFile() {

        try {

            ObjectInputStream in =
            new ObjectInputStream(
            new FileInputStream("students.dat"));

            list =
            (ArrayList<Student>) in.readObject();

            in.close();

            System.out.println("Read successfully");

        } catch(Exception e) {
            System.out.println(e);
        }
    }
}
