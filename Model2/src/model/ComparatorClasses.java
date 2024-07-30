package model;

import java.util.Comparator;

public class ComparatorClasses {
    public static class BookComparator {
        public static final Comparator<Book> ID = Comparator.comparing(Book::getBookID);
    }

    public static class CompanyComparator {
        public static final Comparator<Company> ID = Comparator.comparing(Company::getCompanyID);
    }

    public static class InputBillComparator {
        public static final Comparator<InputBill> ID = Comparator.comparingInt(InputBill::getBillID);
    }

    public static class OutputBillComparator {
        public static final Comparator<OutputBill> ID = Comparator.comparingInt(OutputBill::getBillID);
    }
}
