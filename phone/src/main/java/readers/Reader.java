package readers;


import java.util.Arrays;

public class Reader {

    private String fio;
    private int readersNum;
    private String faculty;
    private int dateOfBirth;
    private String phoneNumber;


    public void takeBook(int numBooks) {
        System.out.println(fio + "Взял " + numBooks);
    }

    public void takeBooks(String... booksTitle) {
        System.out.println(fio + "Взял книги" + Arrays.toString(booksTitle));
    }

    public void returnBook(String... booksTitle) {
        System.out.println(fio + "Вернул Книги " + Arrays.toString(booksTitle));

    }

    public void returnBook(int numsOfBooks) {
        System.out.println(fio + "Вернул " + numsOfBooks);
    }

    public void takeBooks(Book... books) {
        System.out.println(fio + "Взял Книги ");
        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i]);

        }
    }

    public Reader(int dateOfBirth, String faculty, String fio, String phoneNumber, int readersNum) {
        this.dateOfBirth = dateOfBirth;
        this.faculty = faculty;
        this.fio = fio;
        this.phoneNumber = phoneNumber;
        this.readersNum = readersNum;
    }


    static class Book {
        private final String title;
        private final String author;

        public Book(String author, String title) {
            this.author = author;
            this.title = title;
        }

        @Override
        public String toString() {
            return title + author;
        }
    }

    public static class Main {

        public static void main(String[] args) {
            Reader Igor = new Reader(1985, "Eng", "Петров В.В", "89654", 7);

            Book book1 = new Book("Автор1", "Приключения");
            Book book2 = new Book("Автор2", "Словарь");
            Book book3 = new Book("Автор3", "Энциклопедия");

            Igor.takeBook(3);
            Igor.takeBooks("Приключения", "Словарь", "Энциклопедия");
            Igor.takeBooks(book1, book2, book3);

            Igor.returnBook("Приключения", "Словарь", "Энциклопедия");
            Igor.returnBook(3);
        }
    }

}


