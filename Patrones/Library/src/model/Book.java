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


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isAvailability() {
        return Availability;
    }

    public void setAvailability(boolean availability) {
        Availability = availability;
    }
    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", category='" + category + '\'' +
                ", Availability=" + Availability +
                '}';
    }
}
