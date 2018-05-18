import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class App00 {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver",
                "/home/kotdavinci/Dev/Java/automation/src/main/resources/webdrivers/chromedriver");

//        WebDriver webDriver = new FirefoxDriver();
        WebDriver webDriver = new ChromeDriver();

        webDriver.get("https://www.pochta.ru/TRACKING");

//        WebElement searchField = webDriver.findElement(By.tagName("input"));
        WebElement searchField = webDriver.findElement(By.cssSelector("input[type='text']"));
        searchField.clear();
        searchField.sendKeys("ZA183793056LV");

        webDriver.findElement(By.cssSelector(".input__btn-search")).click();
//        webDriver.findElement(By.xpath("//*[@id=\"p_p_id_trackingPortlet_WAR_portalportlet_\"]/div/div/div/div/div[1]/div/div[2]/input"));


        System.out.println(webDriver.getTitle());


//        webDriver.close();
        webDriver.quit();
    }

}
