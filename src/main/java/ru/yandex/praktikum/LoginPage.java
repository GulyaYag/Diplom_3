package ru.yandex.praktikum;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
public class LoginPage {
    public static final String URL = "https://stellarburgers.nomoreparties.site/login";

    //Поле ввода email
    @FindBy(how = How.XPATH, using = "//label[text()='Email']/../input")
    private SelenideElement inputFieldEmail;

    //Поле ввода пароля
    @FindBy(how = How.XPATH, using = "//label[text()='Пароль']/../input")
    private SelenideElement inputFieldPassword;

    //Кнопка "Вход"
    @FindBy(how = How.XPATH, using = "//button[text()='Войти']")
    private SelenideElement loginButton;

    //Заголовок "Вход"
    @FindBy(how = How.XPATH, using = "//div/h2[text()='Вход']")
    private SelenideElement headerInput;

    public void setEmail(String email) {
        inputFieldEmail.setValue(email);
    }

    public void setPassword(String password) {
        inputFieldPassword.setValue(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public Boolean onLoginPage() {
        headerInput.shouldBe(Condition.visible);
        return true;
    }

}
