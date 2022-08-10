package ru.yandex.praktikum;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
public class RegisterPageTest extends BaseTest {
    private static RegisterPage registerPage;
    LoginPage loginPage = Selenide.page(LoginPage.class);
    User user;
    @Test
    @DisplayName("Incorrect password length during registration")
    public void checkRegisterWithWrongPassword() {
        registerPage = open(RegisterPage.URL, RegisterPage.class);
        user = User.getRandomUserWithWrongPassword();
        registerPage.setName(user.name);
        registerPage.setEmail(user.email);
        registerPage.setPassword(user.password);
        registerPage.clickRegisterButton();
        assertEquals("Валидация пароля не пройдена", "Некорректный пароль", registerPage.getErrorMessage());
    }
    @Test
    @DisplayName("Successful registration")
    public void checkSuccessRegister() {
        registerPage = open(RegisterPage.URL, RegisterPage.class);
        user = User.getRandomCorrectUser();
        registerPage.setName(user.name);
        registerPage.setEmail(user.email);
        registerPage.setPassword(user.password);
        registerPage.clickRegisterButton();
        assertTrue("Переход на страницу входа не выполнен!", loginPage.onLoginPage());
    }
}
