package school.sorokin.javacore.oop.Modul_OOP;

public abstract class Publication {
    private String title;// создаем приватные переменные
    private String author; // создаем приватные переменные
    private int year;// создаем приватные переменные

    private static int publicationCount = 0;// создаем счетчик, где наше значение равно 0

    public static int getPublicationCount() { //создаем геттер счетчика, так как счетчик приватный
        return publicationCount; // тепере мне нужно понять, как этот счетчик будет работать, я думаю, что после создания дочернего класс
        // он должен расти, только где мы должны поставить ++?
    }

    public static void decreaseCount() { // создаем метод для уменьшения счетчика, так как publicationCount - приватный
        if (publicationCount > 0) {
            publicationCount--;
        }
    }

    public Publication(String title, String author, int year) {
        this.title = title; // Инициализирует поля говорим, что указанная переменная равна ссылки другой переменной
        this.author = author;
        this.year = year;
        publicationCount++;
    }


    public String getTitle() { // создаем геттер, так как поле приватное, без него работать не будет компилятор не разрешит
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getAuthor() { // создаем геттер, так как поле приватное, без него работать не будет компилятор не разрешит
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() { // создаем геттер, так как поле приватное, без него работать не будет компилятор не разрешит
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public abstract String getType(); // создаем абстрактный метод, что он делает пока не понимаю, но так так требует ТЗ


    @Override
    public String toString() { // переопределяем метод toSting, он нужен для правильного вывода объектов, без него он будет выдавать Hashcode
        return "Тип публикации: " + getType() + " Название: " + title + " Автор: " + author + " Год: " + year;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // говорим что ЭТОТ объект равне обекту obj

        if (obj == null || getClass() != obj.getClass())
            return false; // если объект не null или getClass() не равен геттеру классу obj, откуда здесь появился getClass зачем он?

        Publication pub = (Publication) obj;
        return (title != null ? title.equals(pub.title) : pub.title == null) && // здесь мы возвращаем какое то значение, как я понял если переменная объекта не ноль толь, переменная теперь равна переменной объекта
                (author != null ? author.equals(pub.author) : pub.author == null) &&
                (this.year == pub.year);

    }

    @Override // это переопределение HashCode - (условный id в памяти для объекта )
    public int hashCode() {
        int result = (title != null ? title.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + year;
        // equals
        return result;
    }
}