package ru.yandex.praktikum;
import org.apache.commons.lang3.RandomStringUtils;
public class User {
    String name;
    String email;
    String password;

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public static User getRandomCorrectUser() {
        String name = RandomStringUtils.randomAlphabetic(6);
        String email = RandomStringUtils.randomAlphabetic(6) + "@test.ru";
        String password = RandomStringUtils.randomAlphabetic(8);
        return new User(name, email, password);
    }

    public static User getRandomUserWithWrongPassword() {
        String name = RandomStringUtils.randomAlphabetic(6);
        String email = RandomStringUtils.randomAlphabetic(6) + "@test.ru";
        String password = RandomStringUtils.randomAlphabetic(4);
        return new User(name, email, password);
    }
}
