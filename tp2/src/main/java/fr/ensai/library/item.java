import java.io.*;
import java.util.*;
package fr.ensai.library;

abstract class Item {
    protected String title;
    protected int year;
    protected int pageCount;

    public Item(String title, int year, int pageCount) {
        this.title = title;
        this.year = year;
        this.pageCount = pageCount;
    }

    @Override
    public String toString() {
        return title + " (" + year + ", " + pageCount + " pages)";
    }
}

