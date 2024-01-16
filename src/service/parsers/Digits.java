package service.parsers;

public class Digits extends Parser<Long> {
    Digits(String name) {
        super(name);
    }

    @Override
    public boolean parseToClass(String str) {

        if (str != null && str.chars().allMatch(Character::isDigit)) {
            setValue(Long.parseLong(str));
            return true;
        } else {
            return false;
        }

    }

}
