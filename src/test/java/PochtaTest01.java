import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.*;

public class PochtaTest01 {
    WebDriver webDriver;
    WebDriverWait wait;

    @Before
    public void setupClass() {
        System.setProperty("webdriver.chrome.driver",
                "/home/kotdavinci/Dev/Java/automation/src/main/resources/webdrivers/chromedriver");
        webDriver = new ChromeDriver();
        wait = new WebDriverWait(webDriver, 10, 500);

        webDriver.get("https://www.pochta.ru/");

        wait.until(ExpectedConditions.titleIs("Почта России"));
    }

    @Test
    public void testSearch() {
//        WebElement searchField = webDriver.findElement(By.tagName("input"));
        WebElement searchField = webDriver.findElement(By.cssSelector("input[type='text']"));
        searchField.clear();
        searchField.sendKeys("ZA183793056LV");
//        webDriver.findElement(By.cssSelector(".input__btn-search")).click();
        searchField.submit();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".tracking-card-wrapper")));
        assertTrue(webDriver.findElement(By.cssSelector(".tracking-card-wrapper")).isDisplayed());
    }

    @Test
    public void testLoginForm() {
        webDriver.findElement(By.cssSelector("a.header__btn-login")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("h1.id-page__title")));
        assertTrue(webDriver.findElement(By.cssSelector("h1.id-page__title")).isEnabled());
    }

    @After
    public void  cleanup() {
        if (webDriver != null) webDriver.quit();
    }

}
