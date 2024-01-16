package service.parsers;

public class Letters extends Parser<String> {

    Letters(String name) {
        super(name);
    }

    @Override
    public boolean parseToClass(String str) {
        if (str != null && str.length() > 1 && str.chars().allMatch(Character::isLetter)) {
            setValue(firstUpperOtherLowerCase(str));
            return true;
        } else {
            return false;
        }
    }

    public String firstUpperOtherLowerCase(String s) {
        if(s == null) return null;
        if (!s.isEmpty()) {
            String f = s.substring(0, 1).toUpperCase();
            if (s.length()>1)
                return f + s.substring(1).toLowerCase();
            else
                return f;
        }
        return s;
    }

}
