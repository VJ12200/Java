package org.example;

// Book.java
public class Book {
    private int id;
    private String title;
    private String author;
    private boolean isIssued;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }


    //Getters
    public int getId() { return id; }
    public String getTitle() { return title; }
    public boolean isIssued() { return isIssued; }


    //Methods that set the state of the isIssued field
    public void issued() { this.isIssued = true; }
    public void returned() { this.isIssued = false; }


    //Override the toString() method to print
    @Override
    public String toString() {
        return "[" + id + "] " + title + " by " + author +
                (isIssued ? " (Issued)" : " (Available)");
    }
}

