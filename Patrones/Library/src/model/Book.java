package model;

public class Book {
    private String title;

    private String author;

    private String category;

    private boolean Availability;

    public Book(String title, String author, String category, boolean availability) {
        this.title = title;
        this.author = author;
        this.category = category;
        Availability = availability;
    }

}
