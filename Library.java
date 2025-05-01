package school.sorokin.javacore.oop.Modul_OOP;

import java.sql.Array;
import java.util.ArrayList;
import java.util.*;

public class Library {

    private List<Publication> publications = new ArrayList<>();


    public void addPublication(Publication pub) { //добавление публикации в каталог (не забудьте увеличить счетчик публикаций в абстрактном классе).
        publications.add(pub);
    }

    public void listPublications() { //вывод всех публикаций (используйте метод toString()
        for (Publication pub : publications) {
            System.out.println(pub);
        }
    }

    public void searchByAuthor(String author) { // создаем метод в котором он будет искать переменную типа стринг автор
        if (publications.isEmpty()) { // проверяем если публикации пусты, то
            System.out.println("Список публикаций  отсутствует");// выдаем команду
            return;
        }
        boolean found = false;// создаем логическое выражение которое изначально ложь
        for (Publication pub : publications) { // создаем цикл, в котором мы проходимся по всем индекс массива публикации
            if (pub.getAuthor().equalsIgnoreCase(author)) { // если гетАвтор равен автору

                System.out.println(pub);// и выводим нужный индекс массива
                found = true;// тем самым выходим из цикла
            }
        }
        if (!found) {//не понимаю что это?
            System.out.println(author + " - Автор не найден");
        }
    }

    public void searchByTitle(String title) { // создаем метод в котором он будет искать переменную типа стринг автор
        if (publications.isEmpty()) { // проверяем если публикации пусты, то
            System.out.println("Список публикаций  отсутствует");// выдаем команду
            return;
        }
        boolean found = false;// создаем логическое выражение которое изначально ложь
        for (Publication pub : publications) { // создаем цикл, в котором мы проходимся по всем индекс массива публикации
            if (pub.getTitle().equalsIgnoreCase(title)) { // если гетАвтор равен автору, то выдаем команду

                System.out.println(pub);// и выводим нужный индекс массива
                found = true;// тем самым выходим из цикла
            }
        }
        if (!found) {
            System.out.println(title + " - Публикация с таким наименованием не найдена.");
        }
    }


    public void showStatistics() {
        System.out.println("Количество публикаций Книг: " + Book.getBookCount());
        System.out.println("Количество публикаций Журналов: " + Magazine.getMagazineCount());
        System.out.println("Количество публикаций Газет: " + Newspaper.getNewspaperCount());
        System.out.println("Всего количество публикаций: " + Publication.getPublicationCount());
    }


    public void delPublication(String title, String type_del) {
        if (publications.isEmpty()) {
            System.out.println("Список публикаций отсутствуют");
            return;
        }
        boolean isDeleted = false;
        for (int i = 0; i < publications.size(); i++) { //  мы проходимся по всему массуву, где i - является элементом массива
            Publication pub = publications.get(i); // здесь мы говорим, объект pub класса публикации, это все объекты массива, но со своим индексом i,
            if (pub.getTitle().equalsIgnoreCase(title) && pub.getType().equalsIgnoreCase(type_del)) { // здесь мы говорим, если переменная title, кого то объекта массива, равна нашему будущей переменной поиска title
                System.out.println("Вы успешно удалили " + pub.toString());
                publications.remove(i);// то мы удаляем объект безопасно, компилятор сам сместит объект и уменьшит элементы массива и количество объектов в массиве
                pub.decreaseCount();// мы создали метод, который уменьшает счетчик, так как переменная счетчика приватная
                switch (type_del.toLowerCase()) {
                    case "книга": {
                        Book.decreaseBookCount();
                        break;
                    }
                    case "журнал": {
                        Magazine.decreaseMagazineCount();
                        break;
                    }
                    case "газета": {
                        Newspaper.decreaseNewspaperCount();
                        break;
                    }
                }
                isDeleted = true;
                break;
            }
        }
        if (!isDeleted) {
            System.out.println("Публикация с таким названием и типом не найдена.");

        }
    }
}






