package ru.yandex.praktikum;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {
    public void setup() {
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
    }

    public void setupYandex() {
        ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver", "C:\\testing\\WebDriver\\bin\\chromedriver.exe");
        options.setBinary("C:\\Users\\ГульфияЯгудина\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
        WebDriver driver = new ChromeDriver(options);
        WebDriverRunner.setWebDriver(driver);

    }
    @Before
    public void init() {
        setup();
        //setupYandex();
    }
    @After
    public void tearDown(){
        Selenide.closeWebDriver();
    }
}
