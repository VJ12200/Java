package org.example.srms;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

//Important to use nexline after nextint because nextint leaves a /n

public class Main {
    private static final ArrayList<Student> students = new ArrayList<>();
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Find Student by Name");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> viewStudents();
                case 3 -> updateStudent();
                case 4 -> deleteStudent();
                case 5 -> findByName();
                case 6 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Error , Try Again!");
            }
        }
    }
    private static void addStudent() {
        try {
            System.out.print("Enter ID: ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Marks: ");
            int marks = sc.nextInt();
            sc.nextLine();
            if(marks >= 0 && marks <= 100){
                students.add(new Student(id, name, marks));
                System.out.println("Student added successfully!");
            }else{
                System.out.println("Marks Should be between 0 and 100");
            }
        } catch (InputMismatchException e) {
            System.out.println("Enter the values in the correct format!");
            //Clearing the bad input from the scanner
            sc.nextLine();
        }
    }

    private static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            System.out.println("---- Student Records ----");
            for (Student s : students) {
                System.out.println(s);
            }
        }
    }

    private static void findByName(){
        System.out.println("Enter the Name to search: ");
        String find = sc.nextLine();
        ArrayList<Student> found = new ArrayList<>();

        for(Student s : students){
            if(s.getName().equalsIgnoreCase(find)) found.add(s);
        }
        if(!found.isEmpty()){
            System.out.println("---------Found---------");
            System.out.println(found);
        }else{
            System.out.println("Student Not found");
        }
    }

    private static void updateStudent() {
        System.out.print("Enter ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Student s : students) {
            if (s.getId() == id) {
                System.out.print("Enter new Name: ");
                String newName = sc.nextLine();
                System.out.print("Enter new Marks: ");
                int newMarks = sc.nextInt();
                sc.nextLine();

                s.setName(newName);
                s.setMarks(newMarks);
                System.out.println("Student updated successfully!");
                return;
            }
        }
        System.out.println("Student not found");
    }

    private static void deleteStudent() {
        System.out.print("Enter ID of student to delete: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Student s : students) {
            if (s.getId() == id) {
                students.remove(s);
                System.out.println("Student deleted successfully!");
                return;
            }
        }
        System.out.println("Student not found!");
    }
}

class Student{
    //Fields
    private int id;
    private int marks;
    private String name;

    //Constructor
    public Student(int studentId, String studentName, int studentMarks) {
        id = studentId;
        name = studentName;
        marks = studentMarks;
    }


    //Getters and Setters
    public int getId() { return id; }
    public String getName() { return name; }
    public double getMarks() { return marks; }

    public void setName(String name) { this.name = name; }
    public void setMarks(int marks) { this.marks = marks; }


    //Override the inbuilt toString method to show a more readable version
    @Override
    public String toString(){
        return "ID: " +id+ ", Name: " +name+ ", Marks: " +marks;
    }



}

