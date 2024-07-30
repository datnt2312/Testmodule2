package controller;

import model.*;
import view.BookStoreView;
import common.IOStream;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BookStoreController {
    private BookStoreView view;
    private ArrayList<Book> books;
    private ArrayList<Company> companies;
    private IOStream ioStream;

    public BookStoreController() {
        view = new BookStoreView();
        books = new ArrayList<>();
        companies = new ArrayList<>();
        ioStream = new IOStream();
        loadData();
    }

    private void loadData() {
        try {
            // Đọc dữ liệu sách từ tệp CSV
            List<String[]> bookData = ioStream.readCSV("books.csv");
            for (String[] data : bookData) {
                // Giả sử dữ liệu CSV theo thứ tự: bookID, bookName, author, category, companyID, price
                books.add(new Book(data[0], data[1], data[2], data[3], data[4], Float.parseFloat(data[5])));
            }

            // Đọc dữ liệu công ty từ tệp CSV
            List<String[]> companyData = ioStream.readCSV("companies.csv");
            for (String[] data : companyData) {
                // Giả sử dữ liệu CSV theo thứ tự: companyID, companyName, address
                companies.add(new Company(data[0], data[1], data[2]));
            }
        } catch (IOException e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
    }

    private void saveData() {
        try {
            ioStream.writeCSV("books.csv", books.stream().map(Book::toCSV).toArray(String[][]::new));
            ioStream.writeCSV("companies.csv", companies.stream().map(Company::toCSV).toArray(String[][]::new));
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    public void start() {
        while (true) {
            view.displayMenu();
            int option = view.getInputInt();
            switch (option) {
                case 1:
                    addBook();
                    break;
                case 2:
                    dropBook();
                    break;
                case 3:
                    addCompany();
                    break;
                case 4:
                    dropCompany();
                    break;
                case 5:
                    addInputBill();
                    break;
                case 6:
                    addOutputBill();
                    break;
                case 7:
                    displayBooks();
                    break;
                case 8:
                    displayCompanies();
                    break;
                case 9:
                    saveData();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private void addBook() {
        Book book = view.inputBook();
        books.add(book);
        System.out.println("Book added successfully.");
        saveData();
    }

    private void dropBook() {
        System.out.print("Enter book ID to delete: ");
        String bookID = view.getInputString();
        Book bookToRemove = null;
        for (Book book : books) {
            if (book.getBookID().equals(bookID)) {
                bookToRemove = book;
                break;
            }
        }
        if (bookToRemove != null) {
            books.remove(bookToRemove);
            System.out.println("Book removed successfully.");
            saveData();
        } else {
            System.out.println("Book ID not found...");
        }
    }

    private void addCompany() {
        Company company = view.inputCompany();
        companies.add(company);
        System.out.println("Company added successfully.");
        saveData();
    }

    private void dropCompany() {
        System.out.print("Enter company ID to delete: ");
        String companyID = view.getInputString();
        Company companyToRemove = null;
        for (Company company : companies) {
            if (company.getCompanyID().equals(companyID)) {
                companyToRemove = company;
                break;
            }
        }
        if (companyToRemove != null) {
            companies.remove(companyToRemove);
            System.out.println("Company removed successfully.");
            saveData();
        } else {
            System.out.println("Company ID not found...");
        }
    }

    private void addInputBill() {
        InputBill bill = view.inputInputBill();
        bill.save("InputBill");
        System.out.println("Input Bill added successfully.");
    }

    private void addOutputBill() {
        OutputBill bill = view.inputOutputBill();
        bill.save("OutputBill");
        System.out.println("Output Bill added successfully.");
    }

    private void displayBooks() {
        view.displayBooks(books);
    }

    private void displayCompanies() {
        view.displayCompanies(companies);
    }
}
