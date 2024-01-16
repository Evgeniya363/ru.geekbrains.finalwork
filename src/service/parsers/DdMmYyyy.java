package service.parsers;

import service.exception.IllegalDateException;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DdMmYyyy extends Parser<Date> {
    DdMmYyyy(String name) {
        super(name);
    }

    @Override
    public boolean parseToClass(String str) {
        SimpleDateFormat myFormat = new SimpleDateFormat("dd.MM.yyyy");
        myFormat.setLenient(false);
        try {
            setValue(myFormat.parse(str));
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

}
