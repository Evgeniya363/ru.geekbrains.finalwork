package service.exception;

import java.time.format.DateTimeParseException;
import java.util.Date;

public class IllegalDateException extends RuntimeException {
    public IllegalDateException(String birthday) {
        super("Дата рождения не может быть больше текущей. Вы ввели: " + birthday);
    }
}
