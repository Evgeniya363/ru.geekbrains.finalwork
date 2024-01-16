package service;

import model.Gender;
import model.Human;
import service.exception.IllegalDateException;
import service.exception.ParseImpossibleException;
import service.parsers.*;

import java.util.*;

/**
 * Класс Builder служит для распознавания строки в объект класса Human
 */
public class Builder {

    /**
     * Метод CreateHuman пробует распарсить слова из переданного списка
     * в объекты, перечисленные в классе ParserList, в случае успеха
     * возвращается ссылка на объект класса Human. В противном случае
     * выбрасывается исключение ParseImpossibleException
     * @param inputlist список строк, которые нужно распарсить
     * @return ссылка на объект типа Human
     */
    public static Human CreateHuman(List<String> inputlist) throws ParseImpossibleException, IllegalDateException {

        List<Parser> parsList = ParserList.newList();
        LinkedList<String> list = new LinkedList<>(inputlist);

        /*Значение каждого валидного элемента list
        сохраняем в поле value соответствующего элемента parsList,
        после чего элемент удаляем из списка переданных параметров*/
        for (Parser pars : parsList) {
            for (String str : list) {
                if (pars.parseToClass(str)) {
                    list.remove(str);
                    break;
                }
            }
        }

        // В списке list остаются только невалидные параметры
        if (!list.isEmpty()) {  // если они есть, выбрасываем исключение
            throw new ParseImpossibleException(list.toString(), ParserList.getNullNames().toString());
        }

        // Также невалидной является дата, превышающая сегодняшнюю
        Date birthday = (Date)parsList.get(3).getValue();
        if (birthday.after(new Date())){
            throw new IllegalDateException(Human.getDateDdMmYyyyFormat(birthday));
        }

        Human human;  // Создаем объект класса Human
        human = new Human((String) parsList.get(0).getValue()
                , (String) parsList.get(1).getValue()
                , (String) parsList.get(2).getValue()
                , (Date) parsList.get(3).getValue()
                , (Long) parsList.get(4).getValue()
                , (Gender) parsList.get(5).getValue());
        return human;
    }

}