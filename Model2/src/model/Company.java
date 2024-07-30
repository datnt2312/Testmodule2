package model;

import java.io.Serializable;
import java.util.Scanner;

public class Company implements Serializable {
    private String companyID;
    private String companyName;
    private String address;
    private String phoneNumber;
    private String faxNumber;

    public Company() {
    }

    public Company(String companyID, String companyName, String address, String phoneNumber, String faxNumber) {
        this.companyID = companyID;
        this.companyName = companyName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.faxNumber = faxNumber;
    }

    // Getters and setters
    public String getCompanyID() {
        return companyID;
    }

    public void setCompanyID(String companyID) {
        this.companyID = companyID;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFaxNumber() {
        return faxNumber;
    }

    public void setFaxNumber(String faxNumber) {
        this.faxNumber = faxNumber;
    }

    @Override
    public String toString() {
        return "Company{" +
                "companyID='" + companyID + '\'' +
                ", companyName='" + companyName + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", faxNumber='" + faxNumber + '\'' +
                '}';
    }

    public String[] toCSV() {
        return new String[]{companyID, companyName, address};
    }


    public void scan() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Company ID: ");
        companyID = sc.nextLine();
        System.out.print("Name: ");
        companyName = sc.nextLine();
        System.out.print("Address: ");
        address = sc.nextLine();
        System.out.print("Phone number: ");
        phoneNumber = sc.nextLine();
        System.out.print("Fax number: ");
        faxNumber = sc.nextLine();
    }
}
