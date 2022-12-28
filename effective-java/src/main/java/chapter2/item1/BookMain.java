package chapter2.item1;

public class BookMain {
    public static void main(String[] args) {
        Book withName = Book.createBookWithName("effective-java");
        Book withAuthor = Book.createBookWithAuthor("joshua Bloch");

//        new Book("effective-java");
//        new Book("joshua Bloch");
        System.out.println("withName.getName() = " + withName.getName());
        System.out.println("withAuthor.getAuthor() = " + withAuthor.getAuthor());
    }
}
