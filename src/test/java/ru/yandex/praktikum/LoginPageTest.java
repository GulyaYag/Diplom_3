package ru.yandex.praktikum;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertTrue;
public class LoginPageTest extends BaseTest {
    LoginPage loginPage = Selenide.page(LoginPage.class);
    RegisterPage registerPage = Selenide.page(RegisterPage.class);
    ProfilePage profilePage = Selenide.page(ProfilePage.class);
    MainPage mainPage = Selenide.page(MainPage.class);
    RestorePasswordPage restorePasswordPage = Selenide.page(RestorePasswordPage.class);
    User user;
    @Before
    public void register() {
        user = User.getRandomCorrectUser();
        registerPage = open(RegisterPage.URL, RegisterPage.class);
        registerPage.setName(user.name);
        registerPage.setEmail(user.email);
        registerPage.setPassword(user.password);
        registerPage.clickRegisterButton();
        assertTrue("Переход на страницу входа не выполнен!", loginPage.onLoginPage());
    }
    @After
    public void exit() {
        mainPage.clickLkButton();
        profilePage.clickExitButton();
    }

    @Test
    @DisplayName("login through the Personal account button")
    public void loginTroughPersonalAccountButton() {
        mainPage = open(MainPage.URL, MainPage.class);
        mainPage.clickLkButton();
        loginPage.onLoginPage();
        loginPage.setEmail(user.email);
        loginPage.setPassword(user.password);
        loginPage.clickLoginButton();
        assertTrue(mainPage.checkOrderButton());
    }
    @Test
    @DisplayName("login by clicking the Login button on the main page")
    public void loginByClickLoginButton() {
        mainPage = open(MainPage.URL, MainPage.class);
        mainPage.clickLoginButton();
        loginPage.onLoginPage();
        loginPage.setEmail(user.email);
        loginPage.setPassword(user.password);
        loginPage.clickLoginButton();
        assertTrue(mainPage.checkOrderButton());
    }
    @Test
    @DisplayName("Login through the button in the registration form")
    public void loginThroughRegistrationButton() {
        registerPage = open(RegisterPage.URL, RegisterPage.class);
        registerPage.clickEnterButton();
        loginPage.onLoginPage();
        loginPage.setEmail(user.email);
        loginPage.setPassword(user.password);
        loginPage.clickLoginButton();
        assertTrue(mainPage.checkOrderButton());
    }
    @Test
    @DisplayName("Login through the button in the password recovery form")
    public void loginThroughPasswordRecoveryForm() {
        restorePasswordPage = open(RestorePasswordPage.URL, RestorePasswordPage.class);
        restorePasswordPage.clickEnterButton();
        loginPage.onLoginPage();
        loginPage.setEmail(user.email);
        loginPage.setPassword(user.password);
        loginPage.clickLoginButton();
        assertTrue(mainPage.checkOrderButton());
    }
}
