package model;

import common.IOStream;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.IOException;

public class InputBill extends Bill {
    public InputBill() {
        super();
    }

    public InputBill(int billID, String bookID, int quantity, double price) {
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
    public void save(String filename) {
        IOStream ioStream = new IOStream();
        try {
            ArrayList<InputBill> bills = (ArrayList<InputBill>) ioStream.readFile(filename);
            bills.add(this);
            ioStream.writeFile(filename, bills);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error saving InputBill: " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "InputBill{" +
                "billID=" + getBillID() +
                ", bookID='" + getBookID() + '\'' +
                ", quantity=" + getQuantity() +
                ", price=" + getPrice() +
                '}';
    }
}
