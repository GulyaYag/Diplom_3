package ru.yandex.praktikum;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MainPage {
    public static final String URL = "https://stellarburgers.nomoreparties.site";

    //кнопка "Вход в аккаунт"
    @FindBy(how = How.XPATH, using = "//button[text()='Войти в аккаунт']")
    private SelenideElement loginButton;

    //кнопка "Оформить заказ"
    @FindBy(how = How.XPATH, using = "//button[text()='Оформить заказ']")
    private SelenideElement orderButton;

    //кнопка "Личный кабинет"
    @FindBy(how = How.XPATH, using = "//p[text()='Личный Кабинет']")
    private SelenideElement lkButton;

    //Заголовок "Соберите бургер"
    @FindBy(how = How.XPATH, using = "//h1[text()='Соберите бургер']")
    private SelenideElement headingConstructBurger;

    //Кнопка Соусы
    @FindBy(how = How.XPATH, using = "//span[text()='Соусы']")
    private SelenideElement sauceButton;

    //Кнопка Булки
    @FindBy(how = How.XPATH, using = ".//span[contains(text(),'Булки')]")
    private SelenideElement bunButton;

    //Кнопка Начинки
    @FindBy(how = How.XPATH, using = "//span[text()='Начинки']")
    private SelenideElement fillingButton;

    //Выбранная кнопка ингредиентов
    @FindBy(how = How.CSS, using = ".tab_tab_type_current__2BEPc")
    private SelenideElement currentButton;

    public String getCurrentButtonText() {
        return currentButton.getText();
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void clickLkButton() {
        lkButton.click();
    }

    public void clickBunButton() {
        bunButton.click();
    }

    public void clickSauceButton() {
        sauceButton.click();
    }

    public void clickFillingButton() {
        fillingButton.click();
    }

    public Boolean checkOrderButton() {
        orderButton.shouldBe(Condition.visible);
        return true;
    }

    public Boolean checkHeadingConstructBurger() {
        headingConstructBurger.shouldBe(Condition.visible);
        return true;
    }

}
