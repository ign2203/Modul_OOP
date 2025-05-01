package school.sorokin.javacore.oop.Modul_OOP;

public class Book extends Publication implements Printable {
    private String ISBN;
    private static int bookCount = 0;

    public static int getBookCount() {
        return bookCount;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public Book(String title, String author, int year, String ISBN) {
        super(title, author, year);
        this.ISBN = ISBN;
        bookCount++;
    }
public static void decreaseBookCount() {
    if (bookCount > 0) {
        bookCount--;
    }
}

    @Override
    public String getType() {
        return "Книга";
    }

    @Override
    public void printDetails() {

        System.out.println(toString() + " ISBN: " + ISBN);
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // говорим что ЭТОТ объект равне обекту obj

        if (obj == null || getClass() != obj.getClass())
            return false; // если объект не null или getClass() не равен геттеру классу obj, о

        Book book = (Book) obj;
        return (getTitle() != null ? getTitle().equals(book.getTitle()) : book.getTitle() == null) && // здесь мы возвращаем какое то значение, как я понял если переменная объекта не ноль толь, переменная теперь равна переменной объекта
                (getAuthor() != null ? getAuthor().equals(book.getAuthor()) : book.getAuthor() == null) &&
                (this.getYear() == book.getYear()) &&
                (ISBN != null ? ISBN.equals(book.getISBN()) : book.getISBN() == null);
    }
    @Override
    public int hashCode() {
        int result = (getTitle() != null ? getTitle().hashCode() : 0); // если название не равно нулю
        result = 31 * result + (getAuthor() != null ? getAuthor().hashCode() : 0);
        result = 31 * result + getYear();
        result = 31 * result + (ISBN != null ? ISBN.hashCode() : 0 );
        // equals
        return result;


    }

}