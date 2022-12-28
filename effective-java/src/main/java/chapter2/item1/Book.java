package chapter2.item1;

public class Book {
    private String author;
    private String name;

    public Book() {
    }

    public Book(String name) {
        this.name = name;
    }
//    public Book(String author) {
//        this.author = author;
//    }

    public String getAuthor() {
        return author;
    }

    public String getName() {
        return name;
    }

    public static Book createBookWithName(String name) {
        Book book = new Book();
        book.name = name;
        return book;
    }

    public static Book createBookWithAuthor(String author) {
        Book book = new Book();
        book.author = author;
        return book;
    }
}
