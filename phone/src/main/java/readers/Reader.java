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

    public void takeBooks(String...booksTitle ) {
        System.out.println(fio + "Взял книги" + Arrays.toString(booksTitle));
    }

    public void returnBook () {

    }
    public void takeBooks(Book...books) {

    }

    public Reader(int dateOfBirth, String faculty, String fio, String phoneNumber, int readersNum) {
        this.dateOfBirth = dateOfBirth;
        this.faculty = faculty;
        this.fio = fio;
        this.phoneNumber = phoneNumber;
        this.readersNum = readersNum;
    }


     class Book {
private String title;
private String author;

         public Book(String author, String title) {
             this.author = author;
             this.title = title;
         }
         @Override
         public String toString() {
             return title + author;
         }
     }

    public void main(String[] args) {
        Reader Igor = new Reader(1985,"Eng", "Петров В.В", "89654", 7);

        Book book1 = new Book("Автор1", "Приключения");

    }
}


