package view;

import model.*;

import java.util.ArrayList;
import java.util.Scanner;

public class BookStoreView {
    private Scanner sc = new Scanner(System.in);

    public void displayMenu() {
        System.out.println("1. Add Book");
        System.out.println("2. Drop Book");
        System.out.println("3. Add Company");
        System.out.println("4. Drop Company");
        System.out.println("5. Add Input Bill");
        System.out.println("6. Add Output Bill");
        System.out.println("7. Display Books");
        System.out.println("8. Display Companies");
        System.out.println("9. Exit");
        System.out.print("Choose an option: ");
    }

    public Book inputBook() {
        System.out.print("Enter book ID: ");
        String bookID = sc.nextLine();
        System.out.print("Enter book name: ");
        String bookName = sc.nextLine();
        System.out.print("Enter author: ");
        String author = sc.nextLine();
        System.out.print("Enter publisher: ");
        String publisher = sc.nextLine();
        System.out.print("Enter company ID: ");
        String companyID = sc.nextLine();
        System.out.print("Enter price: ");
        float price = sc.nextFloat();
        sc.nextLine(); // Consume the newline
        return new Book(bookID, bookName, author, publisher, companyID, price);
    }

    public Company inputCompany() {
        System.out.print("Enter company ID: ");
        String companyID = sc.nextLine();
        System.out.print("Enter company name: ");
        String companyName = sc.nextLine();
        System.out.print("Enter address: ");
        String address = sc.nextLine();
        System.out.print("Enter phone number: ");
        String phoneNumber = sc.nextLine();
        System.out.print("Enter email: ");
        String email = sc.nextLine();
        return new Company(companyID, companyName, address, phoneNumber, email);
    }

    public InputBill inputInputBill() {
        InputBill bill = new InputBill();
        bill.scan();
        return bill;
    }

    public OutputBill inputOutputBill() {
        OutputBill bill = new OutputBill();
        bill.scan();
        return bill;
    }

    public int getInputInt() {
        while (!sc.hasNextInt()) {
            System.out.print("Invalid input. Please enter a number: ");
            sc.next();
        }
        int number = sc.nextInt();
        sc.nextLine(); // Consume the newline
        return number;
    }

    public String getInputString() {
        return sc.nextLine();
    }

    public void displayBooks(ArrayList<Book> books) {
        if (books.isEmpty()) {
            System.out.println("No books available.");
        } else {
            System.out.println("Books:");
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    public void displayCompanies(ArrayList<Company> companies) {
        if (companies.isEmpty()) {
            System.out.println("No companies available.");
        } else {
            System.out.println("Companies:");
            for (Company company : companies) {
                System.out.println(company);
            }
        }
    }
}
