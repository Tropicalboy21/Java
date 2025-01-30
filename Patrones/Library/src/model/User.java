package model;

import java.util.ArrayList;

public class User {

    private String name;

    private String id;

    private ArrayList<Book> BorrowedBooks;

    public User(String name, String id) {
        this.name = name;
        this.id = id;
        this.BorrowedBooks = new ArrayList<>();
    }


}
