package org.example;

// Library.java
import java.util.*;

public class Library {
    private Map<Integer, Book> books = new HashMap<>();
    private Map<Integer, User> users = new HashMap<>();
    private Map<Integer, Integer> issuedBooks = new HashMap<>();
    // bookId -> userId

    public void addBook(Book book) {
        books.put(book.getId(), book);
    }

    public void addUser(User user) {
        users.put(user.getUserId(), user);
    }

    public void issueBook(int bookId, int userId) {
        Book book = books.get(bookId);
        User user = users.get(userId);

        if (book == null) {
            System.out.println("Book not found!");
            return;
        }
        if (user == null) {
            System.out.println("User not found!");
            return;
        }
        if (book.isIssued()) {
            System.out.println("Book already issued!");
            return;
        }

        book.issued();
        issuedBooks.put(bookId, userId);
        System.out.println(user.getName() + " issued " + book.getTitle());
    }

    public void returnBook(int bookId) {
        Book book = books.get(bookId);

        if (book == null) {
            System.out.println("Book not found!");
            return;
        }
        if (!book.isIssued()) {
            System.out.println("Book was not issued!");
            return;
        }

        int userId = issuedBooks.get(bookId);
        book.returned();
        issuedBooks.remove(bookId);

        System.out.println("Book returned: " + book.getTitle() + " by User ID " + userId);
    }

    public void showBooks() {
        for (Book book : books.values()) {
            System.out.println(book);
        }
    }
}
