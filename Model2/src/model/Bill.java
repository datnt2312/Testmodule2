package model;

import common.IOStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.io.IOException;

public abstract class Bill implements Serializable {
    private int billID;
    private String bookID;
    private int quantity;
    private double price;

    public Bill() {}

    public Bill(int billID, String bookID, int quantity, double price) {
        this.billID = billID;
        this.bookID = bookID;
        this.quantity = quantity;
        this.price = price;
    }

    public int getBillID() {
        return billID;
    }

    public void setBillID(int billID) {
        this.billID = billID;
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "billID=" + billID +
                ", bookID='" + bookID + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }

    public void save(String filename) {
        IOStream ioStream = new IOStream();
        try {
            ArrayList<Bill> bills = (ArrayList<Bill>) ioStream.readFile(filename);
            bills.add(this);
            ioStream.writeFile(filename, bills);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error saving Bill: " + e.getMessage());
        }
    }
}
