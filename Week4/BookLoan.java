class Book {
    private String title;
    private String author;
    private String bookCode;
    private boolean loaned;

    Book(String title, String author, String bookCode) {

        if (title == null || title.trim().isEmpty()) {
            System.out.println("Title cannot be blank");
        }

        if (author == null || author.trim().isEmpty()) {
           System.out.println("Author cannot be blank");
        }

        if (bookCode == null || bookCode.trim().isEmpty()) {
            System.out.println("Book code cannot be blank");
        }

        this.title = title;
        this.author = author;
        this.bookCode = bookCode;
        this.loaned = false;
    }

    boolean borrowBook() {
        if (loaned == false) {
            loaned = true;
            return true;
        }

        return false;
    }

    boolean returnBook() {
        if (loaned == true) {
            loaned = false;
            return true;
        }

        return false;
    }

    boolean isAvailable() {
        return loaned == false;
    }

    String getTitle() {
        return title;
    }

    String getAuthor() {
        return author;
    }

    String getBookCode() {
        return bookCode;
    }

    public String toString() {
        return "Book [Title=" + title +
               ", Author=" + author +
               ", Code=" + bookCode +
               ", Available=" + isAvailable() + "]";
    }
}


public class BookLoan {
    public static void main(String[] args) {
        Book book1 = new Book(
                "The Alchemist",
                "Paulo Coelho",
                "B101"
        );

        Book book2 = new Book(
                "Harry Potter",
                "J.K. Rowling",
                "B102"
        );

        System.out.println(book1);
        System.out.println(book2);

        System.out.println("\nBorrow book1: "  + book1.borrowBook());
        System.out.println(book1);
        System.out.println("Borrow book1 again: "+ book1.borrowBook());
        System.out.println(book1);
        System.out.println("Return book1: " + book1.returnBook());
        System.out.println(book1);
        System.out.println("Return book1 again: "+ book1.returnBook());
        System.out.println(book1);
        System.out.println("\nBook2 is independent:");
        System.out.println(book2);
        book2.borrowBook();
        System.out.println("After borrowing book2:");
        System.out.println(book2);
        System.out.println("Book1 is still:");
        System.out.println(book1);
    }
}
