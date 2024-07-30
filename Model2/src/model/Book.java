package model;

import java.io.Serializable;
import java.util.Scanner;
import common.IOStream;
import java.io.IOException;

public class Book implements Serializable {
    private String bookID;
    private String bookName;
    private String author;
    private String category;
    private String companyID;
    private float price;

    public Book() {
    }

    public Book(String bookID, String bookName, String author, String category, String companyID, float price) {
        this.bookID = bookID;
        this.bookName = bookName;
        this.author = author;
        this.category = category;
        this.companyID = companyID;
        this.price = price;
    }

    // Getters and setters
    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
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

    public String getCompanyID() {
        return companyID;
    }

    public void setCompanyID(String companyID) {
        this.companyID = companyID;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookID='" + bookID + '\'' +
                ", bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", category='" + category + '\'' +
                ", companyID='" + companyID + '\'' +
                ", price=" + price +
                '}';
    }

    public void scan() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Book ID: ");
        bookID = sc.nextLine();
        System.out.print("Name: ");
        bookName = sc.nextLine();
        System.out.print("Author: ");
        author = sc.nextLine();
        System.out.print("Category: ");
        category = sc.nextLine();
        System.out.print("Company ID: ");
        companyID = sc.nextLine();
        System.out.print("Price: ");
        price = sc.nextFloat();
    }

    public void save(String filename) {
        IOStream ioStream = new IOStream();
        try {
            ioStream.writeCSV(filename, this.toCSV());
        } catch (IOException e) {
            System.out.println("Error saving Book: " + e.getMessage());
        }
    }
    public String toCSV() {
        return String.format("%s,%s,%s,%s,%s,%.2f", bookID, bookName, author, category, companyID, price);
    }

}
