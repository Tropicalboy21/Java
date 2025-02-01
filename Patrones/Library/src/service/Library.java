package service;

import model.*;

import java.util.ArrayList;

public class Library {

    private ArrayList<Book> books;

    private ArrayList<User> users;

    public Library() {books = new ArrayList<>(); users = new ArrayList<>();}

    public String addBook(String title, String author, String category, boolean availability){
         Book newBook = new Book(title ,author, category, availability);
         books.add(newBook);

        return
                "\nEl Libro "+ title + " fue añadido con exito";
    }

    public ArrayList<String> showBooks() {
        ArrayList<String> booksCollection = new ArrayList<>();
        for (Book tempBook : books) {
            booksCollection.add(tempBook.toString());
        }
        return booksCollection;
    }

    public String addUser(String name, String id){
        User newUser = new User(name ,id);
        users.add(newUser);

        return
                "\nUsario añadido con exito";
    }

    public ArrayList<String> showUsers() {
        ArrayList<String> usersInfo = new ArrayList<>();
        for (User tempUser : users) {
            usersInfo.add(tempUser.toString());
        }
        return usersInfo;
    }

    public String borrowBook(String bookName, String userName) {
        Book book = searchBook(bookName);
        if (book != null) {
            if (!book.isAvailability()) {
                return "El libro " + book.getTitle() + " no se encuentra disponible.";
            }

            book.setAvailability(false);
            User user = searchUser(userName);
            user.addBorrowedBook(book);

            return "El vecino " + userName + " ha prestado el libro " + book.getTitle() + " con éxito.";
        } else {
            return "El libro con el nombre " + bookName + ", no existe en el sistema!";
        }
    }

    public String showBorrowBooksByUser(String userName) {
        User user = searchUser(userName);
        ArrayList<Book> borrowedBooks = user.getBorrowedBooks();

        if (borrowedBooks.isEmpty()) {
            return "El usuario " + userName + " no ha prestado libros.";
        }

        StringBuilder borrowedBooksList = new StringBuilder();
        borrowedBooksList.append("Libros prestados por " + userName + ":\n");

        for (Book book : borrowedBooks) {
            borrowedBooksList.append("- " + book.getTitle() + "\n");
        }

        return borrowedBooksList.toString();
    }

    public User searchUser(String userName){
        for (User userFound:users) {
            if(userFound.getName().equals(userName))
                return userFound;
        }
        return null;
    }

    public Book searchBook(String bookName){
        for (Book bookFound:books) {
            if(bookFound.getTitle().equals(bookName))
                return bookFound;
        }
        return null;
    }

}

