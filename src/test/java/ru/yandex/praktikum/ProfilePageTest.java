package ru.yandex.praktikum;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ProfilePageTest extends BaseTest{
    LoginPage loginPage = Selenide.page(LoginPage.class);
    RegisterPage registerPage = Selenide.page(RegisterPage.class);
    ProfilePage profilePage = Selenide.page(ProfilePage.class);
    MainPage mainPage = Selenide.page(MainPage.class);
    User user;

    @Before
    public void setup() {
        user = User.getRandomCorrectUser();
        registerPage = open(RegisterPage.URL, RegisterPage.class);
        registerPage.setName(user.name);
        registerPage.setEmail(user.email);
        registerPage.setPassword(user.password);
        registerPage.clickRegisterButton();
        assertTrue("Переход на страницу входа не выполнен!", loginPage.onLoginPage());
    }
    @Test
    @DisplayName("Check the transition by clicking on Personal Account")
    public void checkTransitionPersonalAccount() {
        mainPage = open(MainPage.URL, MainPage.class);
        mainPage.clickLkButton();
        loginPage.onLoginPage();
        loginPage.setEmail(user.email);
        loginPage.setPassword(user.password);
        loginPage.clickLoginButton();
        assertTrue(mainPage.checkOrderButton());
        mainPage.clickLkButton();
        assertEquals(user.name, profilePage.getNameField());
        assertEquals(user.email.toLowerCase(), profilePage.getEmailField());
    }
    @Test
    @DisplayName("Check the transition by clicking on the Constructor")
    public void checkTransitionConstructor() {
        mainPage = open(MainPage.URL, MainPage.class);
        mainPage.clickLkButton();
        loginPage.onLoginPage();
        loginPage.setEmail(user.email);
        loginPage.setPassword(user.password);
        loginPage.clickLoginButton();
        assertTrue(mainPage.checkOrderButton());
        mainPage.clickLkButton();
        profilePage.clickConstructorButton();
        mainPage.checkHeadingConstructBurger();
        mainPage.checkOrderButton();
    }
    @Test
    @DisplayName("Check click-through to the Stellar Burgers logo")
    public void checkTransitionBurgersLogo() {
        mainPage = open(MainPage.URL, MainPage.class);
        mainPage.clickLkButton();
        loginPage.onLoginPage();
        loginPage.setEmail(user.email);
        loginPage.setPassword(user.password);
        loginPage.clickLoginButton();
        assertTrue(mainPage.checkOrderButton());
        mainPage.clickLkButton();
        profilePage.clickLogoSB();
        mainPage.checkHeadingConstructBurger();
        mainPage.checkOrderButton();
    }
    @Test
    @DisplayName("Check the exit by clicking the Exit button in your account")
    public void checkExitAccount() {
        mainPage = open(MainPage.URL, MainPage.class);
        mainPage.clickLkButton();
        loginPage.onLoginPage();
        loginPage.setEmail(user.email);
        loginPage.setPassword(user.password);
        loginPage.clickLoginButton();
        assertTrue(mainPage.checkOrderButton());
        mainPage.clickLkButton();
        profilePage.clickExitButton();
        loginPage.onLoginPage();
    }
}
