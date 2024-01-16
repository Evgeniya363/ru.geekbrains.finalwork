package service.parsers;

import java.util.ArrayList;
import java.util.List;

public class  ParserList {
    private final static List<Parser> parsList;
    private final static int size;

    static {
        parsList = new ArrayList<>();
        parsList.add(new Letters("фамилия(СтрокаБукв)"));
        parsList.add(new Letters("имя(СтрокаБукв)"));
        parsList.add(new Letters("отчество(СтрокаБукв)"));
        parsList.add(new DdMmYyyy("дата_рождения(дд.мм.гггг)"));
        parsList.add(new Digits("телефон(цифры)"));
        parsList.add(new ForM("пол(f или m)"));
        size = parsList.size();
    }

    public static List<Parser> newList() {
        for(Parser pars : parsList) {
            pars.resetValue();
        }
        return parsList;
    }

    public static int size() {
        return size;
    }

    public static List<String> getNullNames(){
        List<String> list = new ArrayList<>();
        for (Parser pars : parsList) {
            if (pars.getValue() == null)
                list.add(pars.getName());
        }
        return list;
    }
}
