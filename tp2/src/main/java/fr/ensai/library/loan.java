package fr.ensai.library;
import java.io.*;
import java.util.*;

class Loan {
    private Student student;
    private Item item;
    private Date startDate;
    private Date returnDate;

    public Loan(Student student, Item item) {
        this.student = student;
        this.item = item;
        this.startDate = new Date();
        this.returnDate = null;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "Item " + item + " borrowed by " + student + (returnDate == null ? " (Active)" : " (Returned)");
    }
}