package ru.yandex.praktikum;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ProfilePage {

    public static final String URL = "https://stellarburgers.nomoreparties.site/account/profile";

    //кнопка "Вход"
    @FindBy(how = How.XPATH, using = "//button[text()='Выход']")
    private SelenideElement loginButton;

    //Поле ввода "Имя"
    @FindBy(how = How.XPATH, using = "//label[text()='Имя']/../input")
    private SelenideElement inputFieldName;

    //Поле ввода email
    @FindBy(how = How.XPATH, using = "//label[text()='Логин']/../input")
    private SelenideElement inputFieldEmail;

    //кнопка "Конструктор"
    @FindBy(how = How.XPATH, using = "//p[text()='Конструктор']")
    private SelenideElement constructorButton;

    //логотип Stellar Burgers
    @FindBy(how = How.XPATH, using = "//div/a")
    private SelenideElement logoStellarBurgers;


    public void clickExitButton() {
        loginButton.click();
    }

    public void clickConstructorButton() {
        constructorButton.click();
    }

    public void clickLogoSB() {
        logoStellarBurgers.click();
    }

    public String getNameField() {
        return inputFieldName.getValue();
    }

    public String getEmailField() {
        return inputFieldEmail.getValue();
    }
}
