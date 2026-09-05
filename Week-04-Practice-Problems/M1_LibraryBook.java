class LibraryBook {

    String title;
    String isbn;

    // Constructor with title and ISBN
    LibraryBook(String title, String isbn) {
        this.title = title;
        this.isbn = isbn;
    }

    // Constructor chaining using this()
    LibraryBook(String title) {
        this(title, "PENDING");
    }

    // Display book details
    void printDetails() {
        System.out.println(
            title + " | " + isbn + " | Catalogued: true"
        );
    }
}

public class M1_LibraryBook {

    public static void main(String[] args) {

        String[] titles = {
            "Clean Code",
            "Untitled Draft",
            "1984",
            "Notes"
        };

        String[] isbns = {
            "978-0132350884",
            "",
            "9780451524935",
            ""
        };

        // Process all books in a single pass
        for (int i = 0; i < titles.length; i++) {

            LibraryBook book;

            if (isbns[i].equals("")) {
                book = new LibraryBook(titles[i]);
            } else {
                book = new LibraryBook(titles[i], isbns[i]);
            }

            book.printDetails();
        }
    }
}