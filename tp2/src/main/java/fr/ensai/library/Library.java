package fr.ensai.library;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

/**
 * Represents a library.
 */


public class Library {
    private String name;
    private List<Item> items;
    private List<Loan> activeLoans;
    private List<Loan> completedLoans;

    public Library(String name) {
        this.name = name;
        this.items = new ArrayList<>();
        this.activeLoans = new ArrayList<>();
        this.completedLoans = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void displayItems() {
        if (items.isEmpty()) {
            System.out.println("The library has no items.");
        } else {
            for (Item item : items) {
                System.out.println(item);
            }
        }
    }

    public Loan findActiveLoanForItem(Item item) {
        for (Loan loan : activeLoans) {
            if (loan.getItem().equals(item)) {
                return loan;
            }
        }
        return null;
    }

    public List<Book> getBooksByAuthor(Author author) {
        List<Book> booksByAuthor = new ArrayList<>();
        for (Item item : items) {
            if (item instanceof Book && ((Book) item).getAuthor().equals(author)) {
                booksByAuthor.add((Book) item);
            }
        }
        return booksByAuthor;
    }

    public boolean loanItem(Item item, Student student) {
        if (findActiveLoanForItem(item) == null) {
            Loan loan = new Loan(student, item);
            activeLoans.add(loan);
            System.out.println("Loan created: " + loan);
            return true;
        }
        System.out.println("Item is already loaned.");
        return false;
    }


    public boolean returnItem(Item item) {
        Loan loan = findActiveLoanForItem(item);
        if (loan != null) {
            loan.setReturnDate(new Date());
            activeLoans.remove(loan);
            completedLoans.add(loan);
            System.out.println("Item returned: " + loan);
            return true;
        }
        System.out.println("No active loan found for this item.");
        return false;
    }

    public void displayActiveLoans() {
        if (activeLoans.isEmpty()) {
            System.out.println("No active loans.");
        } else {
            for (Loan loan : activeLoans) {
                System.out.println(loan);
            }
        }
    }

    

    public void loadBooksFromCSV(String filePath) {

        URL url = getClass().getClassLoader().getResource(filePath);

        try (BufferedReader br = new BufferedReader(new FileReader(url.getFile()))) {
            Map<String, Author> authors = new HashMap<>();
            String line;
            br.readLine(); // Skip the header line

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                if (data.length == 5) {
                    String isbn = data[0].trim();
                    String title = data[1].trim();
                    String authorName = data[2].trim();
                    int year = Integer.parseInt(data[3].trim());
                    int pageCount = Integer.parseInt(data[4].trim());

                    // Check if author already exists in the map
                    Author author = authors.get(authorName);
                    if (author == null) {
                        author = new Author(authorName);
                        authors.put(authorName, author);
                        System.out.println(author.toString());
                    }
                    Item item = new Item(isbn, title, author, year, pageCount);

                    this.addItem(item);
                }
            }
        } catch (

        IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}