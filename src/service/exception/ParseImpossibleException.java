package service.exception;

import java.io.IOException;

public class ParseImpossibleException extends IOException {
    public ParseImpossibleException(String list1, String list2) {
        super("Некорректный ввод. Данные " + list1 +
                " не были распознаны. \nОжидаемый формат: " +list2);
    }
}
