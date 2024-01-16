import java.util.Scanner;

/**
 * Класс View представляет интерфейс пользователя
 */
public class View {
    Scanner scanner = new Scanner(System.in);
    Presenter presenter = new Presenter(this);

    /**
     * Метод View циклически запрашивает ввод
     * данных с клавиатуры
     */
    public void menu() {

        greeting();
        while (true) {
            System.out.println("\nВведите данные:");
            String string = scanner.nextLine();
            if (string.equals("x")) {
                break;
            }
            presenter.processingString(string);
        }
    }

    /**
     * Метод вывода в консоль строк приветствия
     */
    private void greeting() {
        System.out.println("\nПриложение \"Телефонная книга\"");
        System.out.println("-".repeat(100));
        System.out.println("Введите Ф.И.О. (Буквы), дату рождения " +
                "(дд.мм.гггг), номер телефона (цифры) и пол (f или m),");
        System.out.println("разделенные пробелами, например: \"21.11.2001 89106451201 " +
                "Белова Ольга Владимировна f\". Выод - x) ");
        System.out.println("-".repeat(100));
    }

    /**
     * Метод взаимодействия с пользователем через консоль
     * @param string сообщение пользователю
     */
    public void answer(String string){
        System.out.println(string);
    }

}
