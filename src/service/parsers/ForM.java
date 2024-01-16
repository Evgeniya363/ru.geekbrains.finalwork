package service.parsers;

import model.Gender;

public class ForM extends Parser<Gender> {

    ForM(String name) {
        super(name);
    }

    @Override
    public boolean parseToClass(String str) {

        if ("f".equals(str)) {
            setValue(Gender.Female);
            return true;
        } else if (str.equals("m")) {
            setValue(Gender.Male);
            return true;
        } else return false;

    }

}
