import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PochtaTest01 {

    @Test
    public void testSearch() {
        System.setProperty("webdriver.chrome.driver",
                "/home/kotdavinci/Dev/Java/automation/src/main/resources/webdrivers/chromedriver");

        WebDriver webDriver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(webDriver, 10, 500);

        webDriver.get("https://www.pochta.ru/TRACKING");

//        WebElement searchField = webDriver.findElement(By.tagName("input"));
        WebElement searchField = webDriver.findElement(By.cssSelector("input[type='text']"));
        searchField.clear();
        searchField.sendKeys("ZA183793056LV");

        webDriver.findElement(By.cssSelector(".input__btn-search")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".tracking-card-wrapper")));
        Assert.assertTrue(webDriver.findElement(By.cssSelector(".tracking-card-wrapper")).isDisplayed());

        webDriver.quit();
    }
}
