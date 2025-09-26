package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== Library Menu =====");
            System.out.println("1. Add Book");
            System.out.println("2. Add User");
            System.out.println("3. Show All Books");
            System.out.println("4. Issue Book");
            System.out.println("5. Return Book");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    try {
                        System.out.print("Enter Book ID: ");
                        int bookId = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter Title: ");
                        String title = sc.nextLine();
                        System.out.print("Enter Author: ");
                        String author = sc.nextLine();
                        library.addBook(new Book(bookId, title, author));
                        break;
                    }  catch (Exception e) {
                        System.out.println("Error , Try Again!");
                        sc.nextLine();
                    }

                case 2:
                    try {
                        System.out.print("Enter User ID: ");
                        int userId = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter User Name: ");
                        String name = sc.nextLine();
                        library.addUser(new User(userId, name));
                        break;
                    }  catch (Exception e) {
                        System.out.println("Error , Try Again!");
                        sc.nextLine();
                    }

                case 3:
                    library.showBooks();
                    break;

                case 4:
                    try{
                        System.out.print("Enter Book ID to issue: ");
                        int issueBookId = sc.nextInt();
                        System.out.print("Enter User ID: ");
                        int issueUserId = sc.nextInt();
                        library.issueBook(issueBookId, issueUserId);
                        break;
                    }
                    catch (Exception e) {
                        System.out.println("Error , Try Again!");
                        sc.nextLine();
                    }

                case 5:
                    try {
                        System.out.print("Enter Book ID to return: ");
                        int returnBookId = sc.nextInt();
                        library.returnBook(returnBookId);
                        break;
                    }
                    catch (Exception e) {
                        System.out.println("Error , Try Again!");
                        sc.nextLine();
                    }

                case 6:
                    System.out.println("Exiting... Goodbye!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
