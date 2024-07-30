package model;

import common.IOStream;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.IOException;

public class OutputBill extends Bill {
    public OutputBill() {
        super();
    }

    public OutputBill(int billID, String bookID, int quantity, double price) {
        super(billID, bookID, quantity, price);
    }

    public void scan() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter bill ID: ");
        setBillID(sc.nextInt());
        sc.nextLine();  // consume the leftover newline
        System.out.print("Enter book ID: ");
        setBookID(sc.nextLine());
        System.out.print("Enter quantity: ");
        setQuantity(sc.nextInt());
        System.out.print("Enter price: ");
        setPrice(sc.nextDouble());
    }

    @Override
    public String toString() {
        return "OutputBill{" +
                "billID=" + getBillID() +
                ", bookID='" + getBookID() + '\'' +
                ", quantity=" + getQuantity() +
                ", price=" + getPrice() +
                '}';
    }

    public void save(String filename) {
        IOStream ioStream = new IOStream();
        try {
            ArrayList<OutputBill> bills = (ArrayList<OutputBill>) ioStream.readFile(filename);
            bills.add(this);
            ioStream.writeFile(filename, bills);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error saving OutputBill: " + e.getMessage());
        }
    }
}
