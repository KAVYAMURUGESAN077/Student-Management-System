package com.driver;

import java.util.List;
import java.util.Scanner;

import com.DAO.MethodsImplementation;
import com.DTO.Student;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        MethodsImplementation m = new MethodsImplementation();

        while (true) {

            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");

            System.out.println("1. Get all student details");
            System.out.println("2. Get one student details");
            System.out.println("3. Insert student");
            System.out.println("4. Update student");
            System.out.println("5. Delete student");
            System.out.println("6. Search student by name");
            System.out.println("7. Count total students");
            System.out.println("8. Exit");

            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {

            case 1:

                List<Student> students = m.getstu();

                if (students.isEmpty()) {

                    System.out.println("No students found.");

                } else {

                    for (Student s : students) {

                        System.out.println(s);
                    }
                }

                break;

            case 2:

                System.out.print("Enter student ID: ");

                int id = sc.nextInt();

                Student student = m.getid(id);

                if (student != null) {

                    System.out.println("Student details:");
                    System.out.println(student);

                } else {

                    System.out.println("Student not found.");
                }

                break;

            case 3:

                System.out.print("Enter student ID: ");

                int sid = sc.nextInt();

                System.out.print("Enter student name: ");

                String name = sc.next();

                System.out.print("Enter phone number: ");

                long phone = sc.nextLong();

                boolean inserted =
                        m.insert(sid, name, phone);

                if (inserted) {

                    System.out.println(
                            "Student inserted successfully!");

                } else {

                    System.out.println(
                            "Student insertion failed.");
                }

                break;

            case 4:

                System.out.print("Enter student ID: ");

                int updateId = sc.nextInt();

                System.out.print("Enter new student name: ");

                String newName = sc.next();

                System.out.print("Enter new phone number: ");

                long newPhone = sc.nextLong();

                Student s =
                        new Student(updateId, newName, newPhone);

                boolean updated = m.update(s);

                if (updated) {

                    System.out.println(
                            "Student updated successfully!");

                } else {

                    System.out.println(
                            "Student update failed.");
                }

                break;

            case 5:

                System.out.print(
                        "Enter student ID to delete: ");

                int deleteId = sc.nextInt();

                boolean deleted = m.delete(deleteId);

                if (deleted) {

                    System.out.println(
                            "Student deleted successfully!");

                } else {

                    System.out.println(
                            "Student deletion failed.");
                }

                break;

            case 6:

                System.out.print(
                        "Enter student name to search: ");

                String searchName = sc.next();

                List<Student> result =
                        m.searchByName(searchName);

                if (result.isEmpty()) {

                    System.out.println(
                            "No student found.");

                } else {

                    System.out.println(
                            "Search results:");

                    for (Student st : result) {

                        System.out.println(st);
                    }
                }

                break;

            case 7:

                int count = m.countStudents();

                System.out.println(
                        "Total students: " + count);

                break;

            case 8:

                System.out.println(
                        "Exited successfully!");

                sc.close();

                return;

            default:

                System.out.println(
                        "Invalid choice!");
            }
        }
    }
}