package ru.yandex.praktikum;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertEquals;

public class MainPageTest extends BaseTest{

    MainPage mainPage = Selenide.page(MainPage.class);

    @Before
    public void setup() {
        mainPage = open(MainPage.URL, MainPage.class);
    }

    @Test
    @DisplayName("Checking that they work go to the Bun section")
    public void checkTransferBunSection() {
        mainPage.clickSauceButton();
        mainPage.clickBunButton();
        assertEquals("Переход на вкладку Булки не осуществлен", "Булки", mainPage.getCurrentButtonText());
    }

    @Test
    @DisplayName("Checking that they work go to the sauces section")
    public void checkTransferSauseSection() {
        mainPage.clickSauceButton();
        assertEquals("Переход на вкладку Соусов не осуществлен", "Соусы", mainPage.getCurrentButtonText());
    }

    @Test
    @DisplayName("Checking that they work go to the filling section")
    public void checkTransferFillingSection() {
        mainPage.clickFillingButton();
        assertEquals("Переход на вкладку Начинки не осуществлен", "Начинки", mainPage.getCurrentButtonText());
    }
}