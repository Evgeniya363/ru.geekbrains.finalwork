package model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/**
 * Класс Human описывает данные чловека
 */
public class Human {
    private String lastName;
    private String firstName;
    private String patronymic;
    private Date birthDate;
    private Gender gender;
    private Long telephone;

    public Human(String lastName, String firstName, String patronymic, Date birthDate, Long telephone, Gender gender) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.birthDate = birthDate;
        this.gender = gender;
        this.telephone = telephone;
    }
    public static String getDateDdMmYyyyFormat(Date birthDate) {
        if (birthDate != null) {
            SimpleDateFormat myFormat = new SimpleDateFormat("dd.MM.yyyy");
            return myFormat.format(birthDate);
        } else {
            return "..";
        }
    }

    private String getGenderSymbol() {
        if (gender != null){
            if (gender == Gender.Female) return "f";
            else return "m";
        }
        return "none";
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        return sb.append(lastName).append(' ')
                .append(firstName).append(' ')
                .append(patronymic).append(' ')
                .append(getDateDdMmYyyyFormat(birthDate)).append(' ')
                .append(getGenderSymbol()).append(' ')
                .append(telephone).append(' ').toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return Objects.equals(lastName, human.lastName)
                && Objects.equals(firstName, human.firstName)
                && Objects.equals(patronymic, human.patronymic)
                && Objects.equals(birthDate, human.birthDate)
                && gender == human.gender
                && Objects.equals(telephone, human.telephone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName
                , firstName
                , patronymic
                , birthDate
                , gender
                , telephone);
    }

    public Gender getGender() {
        return gender;
    }
}
