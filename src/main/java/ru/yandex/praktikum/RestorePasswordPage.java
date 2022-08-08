package ru.yandex.praktikum;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
public class RestorePasswordPage {
    public static final String URL = "https://stellarburgers.nomoreparties.site/forgot-password";

    //кнопка Войти
    @FindBy(how = How.XPATH, using = "//a[text()='Войти']")
    private SelenideElement enterButton;

    public void clickEnterButton() {
        enterButton.click();
    }
}
