package school.sorokin.javacore.oop.Modul_OOP;

public class Magazine extends Publication implements Printable {
    private int issueNumber;

    private static int MagazineCount = 0;// создаем счетчик, где наше значение равно 0

    public static int getMagazineCount() { //создаем геттер счетчика, так как счетчик приватный
        return MagazineCount; // тепере мне     нужно понять, как этот счетчик будет работать, я думаю, что после создания дочернего класс
        // он должен расти, только где мы должны поставить ++?
    }

    public Magazine(String title, String author, int year, int issueNumber) {
        super(title, author, year);
        this.issueNumber = issueNumber;
        MagazineCount++;
    }

    public static void decreaseMagazineCount() {
        if (MagazineCount > 0) {
            MagazineCount--;
        }
    }

    public int getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(int issueNumber) {
        this.issueNumber = issueNumber;
    }


    public String getType() {
        return "Журнал";
    }

    @Override
    public void printDetails() {

        System.out.println(toString() + " Номер выпуска: " + issueNumber);

    }

    @Override
    public boolean equals(Object obj) { //
        if (this == obj) return true; //

        if (obj == null || getClass() != obj.getClass())
            return false; // если объект не null или getClass() не равен геттеру классу obj, о

        Magazine magz = (Magazine) obj; //ты пытаешься привести obj (который может быть объектом другого класса) к типу Magazine.
        return (getTitle() != null ? getTitle().equals(magz.getTitle()) : magz.getTitle() == null) &&
                //Если у текущего объекта (в контексте this) есть title (не null), то ты сравниваешь его с title из объекта magz.
//Если у текущего объекта title нет (это null), ты проверяешь, что у объекта magz тоже нет title.

                (getAuthor() != null ? getAuthor().equals(magz.getAuthor()) : magz.getAuthor() == null) &&
                (this.getYear() == magz.getYear()) &&
                (this.issueNumber == magz.issueNumber);
    }

    @Override
    public int hashCode() {
        int result = (getTitle() != null ? getTitle().hashCode() : 0); // если название не равно нулю
        result = 31 * result + (getAuthor() != null ? getAuthor().hashCode() : 0);
        result = 31 * result + (getYear());
        result = 31 * result + (getIssueNumber());

        // equals
        return result;
    }
}
