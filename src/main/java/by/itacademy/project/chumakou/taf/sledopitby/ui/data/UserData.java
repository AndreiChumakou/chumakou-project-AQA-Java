package by.itacademy.project.chumakou.taf.sledopitby.ui.data;

import com.github.javafaker.Faker;

public class UserData {

    static Faker faker = new Faker();

    public static final String NAME_VALID = "Ivan";
    public static final String EMAIL_VALID = "cs8qfcns@freepost.cc";
    public static final String PASSWORD_VALID = "tyfhdj785";

    public static final String EMAIL_INVALIDE = faker.internet().emailAddress();
    public static final String PASSWORD_INVALIDE = faker.internet().password(6,10);
}
