import service.Service;
import service.exception.IllegalDateException;
import service.exception.ParseImpossibleException;
import service.parsers.ParserList;
import service.saving.TextFormat;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Класс Presenter служит для взаимосвязи пользовательского
 * интерфейса и сервера обработки
 */
public class Presenter {
    private final View view;
    private final Service service;
    private final TextFormat textFormat;
    private final int listSize;
    public Presenter(View view) {
        this.view = view;
        service = new Service();
        this.textFormat = new TextFormat();
        listSize = ParserList.size();
    }

    /**
     * Метод processingString запускает процедуру распазнавания строки и,
     * в случае удачи, пытается осуществить запись данных в файл.
     * При выпадании исключений ParseImpossibleException и ReadWriteFileException
     * или числовых кодов ошибок, обрабатывает их, запуская метод уведомления
     * пользователя
     * @param string строка данных, разделенных пробелом
     */
    public void processingString(String string){
        try{
            int errorCode = service.createHuman(string);
            if (errorCode == 1)
                view.answer("Число параметров больше ожидаемых " + listSize);
            else if (errorCode == -1)
                view.answer("Число параметров меньше ожидаемых " + listSize);
            else if (service.savingData(textFormat, "out/"))
                view.answer("Данные успешно записаны");
            else
                view.answer("Отклонено: данные записаны ранее");
        }catch (ParseImpossibleException | IllegalDateException e) {
            view.answer(e.getMessage());
        } catch (IOException e) {
            view.answer(stackTraceToString(e));
        }

    }
    private String stackTraceToString (Exception e) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        return sw.toString(); // stack trace as a string
    }
}
