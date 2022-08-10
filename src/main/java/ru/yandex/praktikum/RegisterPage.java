package ru.yandex.praktikum;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
public class RegisterPage {
    public static final String URL = "https://stellarburgers.nomoreparties.site/register";

    //Поле для ввода имени
    @FindBy(how = How.XPATH, using = "//label[text()='Имя']/../input")
    private SelenideElement inputFieldName;

    //Поле ввода email
    @FindBy(how = How.XPATH, using = "//label[text()='Email']/../input")
    private SelenideElement inputFieldEmail;

    //Поле ввода пароля
    @FindBy(how = How.XPATH, using = "//label[text()='Пароль']/../input")
    private SelenideElement inputFieldPassword;

    //Кнопка "Зарегистрироваться"
    @FindBy(how = How.XPATH, using = "//button[text()='Зарегистрироваться']")
    private SelenideElement registerButton;

    //Кнопка "Войти"
    @FindBy(how = How.XPATH, using = "//a[text()='Войти']")
    private SelenideElement loginButton;

    //Алерт "Некорректный пароль"
    @FindBy(how = How.XPATH, using = "//div/p[@class='input__error text_type_main-default']")
    private SelenideElement incorrectPassword;

    public void setName(String name) {
        inputFieldName.setValue(name);
    }
    public void setEmail(String email) {inputFieldEmail.setValue(email);}
    public void setPassword(String password) {
        inputFieldPassword.setValue(password);
    }
    public String getErrorMessage() {
        return incorrectPassword.getText();
    }
    public void clickRegisterButton() {
        registerButton.click();
    }
    public void clickEnterButton() {
        loginButton.click();
    }
}
