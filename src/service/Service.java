package service;

import model.Human;
import service.exception.ParseImpossibleException;
import service.parsers.ParserList;
import service.saving.Formatter;

import java.io.IOException;
import java.util.List;

/**
 * Класс Servise переадресует методы распознавания и сохранения
 * в классы их осуществляющие
 */
public class Service {
    private Human human;

    /**
     * Метод пробует распарсить строку в класс Human,
     * предварительно сравнив число аргументов с заявленным
     * @param string строка введенных данных
     * @return код ошибки: 0 - успех, -1 - параметров меньше, чем заявлено
     * 1 - параметров больше, чем заявлено
     * @throws ParseImpossibleException исключение при передаче значений,
     * не соответствующих формату или условию (дата должна быть реальной)
     */
    public int createHuman(String string) throws ParseImpossibleException {

        List<String> list;
        list = List.of(string.split(" "));

        int size = ParserList.size();
        if (list.size() == size) {
            human = Builder.CreateHuman(list);
        }
        return Integer.compare(list.size(), size);
    }

    /**
     * Сохранение данных в файл
     * @param formatter формат файла
     * @param path путь к файлу
     * @return результат сохранения: true - успех, false -неудача
     */
    public boolean savingData(Formatter formatter, String path) throws IOException {
        return formatter.save(human, path);
    }
}
