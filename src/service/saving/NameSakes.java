package service.saving;

import model.Gender;
import model.Human;

import java.util.ArrayList;
import java.util.List;

public class NameSakes {
    /**
     * Метод определяет список возможных однофамильцев
     * @param human объект класса Human
     * @return возвращае список возможных однофамильцев
     */
    public List<String> nameSakes(Human human) {
        String s = human.getLastName();
        List<String> list = new ArrayList<>();
        list.add(s);

        if (s.length() > 4) {
            int len = s.length();
            String last = s.substring(len - 1, len);
            String last2 = s.substring(len - 2, len);
            boolean isMale = human.getGender() == Gender.Male;

            if (isMale && "ий|ый".contains(last2)) {
                list.add(s.substring(0, len - 2) + "ая");

            } else if (!isMale && "ая".contains(last2)) {
                String before2 = s.substring(0, len - 2);
                list.add(before2 + "ий");
                list.add(before2 + "ый");

            } else if (isMale && "н|в".contains(last)) {
                list.add(s.substring(0, len) + "а");

            } else if (!isMale && "а".contains(last)) {
                list.add(s.substring(0, len - 1));
            }
        }
        return list;
    }

}
