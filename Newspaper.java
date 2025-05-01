package school.sorokin.javacore.oop.Modul_OOP;

public class Newspaper extends Publication implements Printable {
    private String publicationDay;


    private static int NewspaperCount = 0;

    public static int getNewspaperCount() {
        return NewspaperCount;
    }

    public Newspaper(String title, String author, int year, String publicationDay) {
        super(title, author, year);
        this.publicationDay = publicationDay;
        NewspaperCount++;
    }

    public static void decreaseNewspaperCount() {
        if (NewspaperCount > 0) {
            NewspaperCount--;
        }
    }

    public String getPublicationDay() {
        return publicationDay;
    }

    public void setPublicationDay(String publicationDay) {
        this.publicationDay = publicationDay;
    }

    public String getType() {
        return "Газета";
    }

    @Override
    public void printDetails() {
        System.out.println("Вы создали тип публикации 'Газета'");
        System.out.println(toString() + " Дата выпуска: " + publicationDay);
    }

    @Override
    public boolean equals(Object obj) { //создаем логическое выражение boolean, где сравниваем его с объектом obj
        if (this == obj) return true; // и говорим если этот объект равен, другому объекту то тру

        if (obj == null || getClass() != obj.getClass())// если сравниваемой объект равен нулю или не принадлежит этому классу то ЛОЖЬ
            return false; // ЗАВЕРШИТЬ МЕТОД
// ДАЛЬШЕ ВЫПОЛНЯЕМ МЕТОД ТРУ, ТАК КАК МЫ ЕГО НЕ ЗАКРЫЛИ, ЧТО ДЕЛАЕМ ЕСЛИ этот объект РАВЕН сравниваемого объекту
        Newspaper nwsp = (Newspaper) obj; // здесь мы говорим, что объект nwsp равне сравнивамому объекту
        return (getTitle() != null ? getTitle().equals(nwsp.getTitle()) : nwsp.getTitle() == null) &&
//если значение не пустое не ноль,  возвращаем значение сравнения названия объекта класса ГАЗЕТА с названием объекта obj (nwsp),
                // если не выполняется то название пустое ТО ЕСТЬ НОЛЬ
                (getAuthor() != null ? getAuthor().equals(nwsp.getAuthor()) : nwsp.getAuthor() == null) &&
                (this.getYear() == nwsp.getYear()) &&
                (publicationDay != null ? publicationDay.equals(nwsp.getPublicationDay()) : nwsp.getPublicationDay() == null);
    }

    @Override
    public int hashCode() {
        int result = (getTitle() != null ? getTitle().hashCode() : 0);
        result = 31 * result + (getAuthor() != null ? getAuthor().hashCode() : 0);
        result = 31 * result + (getYear());
        result = 31 * result + (getPublicationDay() != null ? getPublicationDay().hashCode() : 0);
        return result;
    }
}