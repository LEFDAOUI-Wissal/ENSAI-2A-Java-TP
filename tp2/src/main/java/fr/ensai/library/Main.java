package fr.ensai.library;

public class Main {

    public static void main(String[] args) {

        Author tolkien = new Author("J.R.R. Tolkien", 81, "UK");

        Book fellowshipOfTheRing = new Book(
                "978-0-618-26025-6",
                "The Fellowship of the Ring",
                tolkien,
                1954,
                423);

        System.out.println(fellowshipOfTheRing.toString());

        Library library = new Library("My Library");
        library.loadBooksFromCSV("/home/onyxia/work/ENSAI-2A-Java-TP/tp2/src/main/resources/books.csv");
        library.displayBooks();


        Library library = new Library("My Library");
        library.loadBooksFromCSV("books.csv");

        Magazine mag1 = new Magazine("Tech Today", 2024, 50, "1234-5678", 10);
        Magazine mag2 = new Magazine("Science Weekly", 2023, 40, "8765-4321", 5);
        
        library.addItem(mag1);
        library.addItem(mag2);
        
        library.displayItems();
    }
}