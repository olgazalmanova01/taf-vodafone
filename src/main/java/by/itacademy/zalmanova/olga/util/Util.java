package by.itacademy.zalmanova.olga.util;

import com.github.javafaker.Faker;

public class Util {
    Faker faker;

    public String generateEmail() {
        faker = new Faker();
        String email = faker.internet().emailAddress();
        return email;
    }

    public String generatePassword() {
        faker = new Faker();
        String password = faker.internet().password();
        return password;

    }
}
