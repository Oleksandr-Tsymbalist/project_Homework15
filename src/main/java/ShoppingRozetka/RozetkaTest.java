package ShoppingRozetka;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class RozetkaTest {
    private WebDriver driver;
    private static final By SEARCH_INPUT = By.name("search");
    private static final By SEARCH_BUTTON = By.xpath("//div//button[contains(text(),'Знайти')]");
    private static final By FIND_ELEMENT = By.xpath("//ul[contains(@class,'catalog-grid')]/li[3]");
    private static final By BUY_BUTTON = By.xpath("//app-buy-button/button/span");
    private static final By SHOPPING_BUTTON = By.xpath("//div/button[contains(text(),'Продовжити покупки')]");
    private static final By CART_BUTTON = By.xpath("//ul[contains(@class,'header-actions')]/li[7]//button");


    @BeforeTest
    public void beforeTest() {
        WebDriverManager.chromedriver().arch64().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://rozetka.com.ua/ua/");
    }

    @Test
    public void rozetkaTest () throws InterruptedException{

        driver.findElement(SEARCH_INPUT).sendKeys("Acer Aspire");
        driver.findElement(SEARCH_BUTTON).click();
        Thread.sleep(300);
        driver.findElement(FIND_ELEMENT).click();
        driver.findElement(BUY_BUTTON).click();
        Thread.sleep(1000);
        driver.findElement(SHOPPING_BUTTON).click();
        driver.findElement(SEARCH_INPUT).sendKeys("FREGGIA");
        driver.findElement(SEARCH_BUTTON).click();
        Thread.sleep(300);
        driver.findElement(FIND_ELEMENT).click();
        driver.findElement(BUY_BUTTON).click();
        Thread.sleep(1000);
        driver.findElement(SHOPPING_BUTTON).click();
        driver.findElement(CART_BUTTON).click();
        List<WebElement> list = driver.findElements(By.xpath("//ul[@class='cart-list']/li"));
        Assert.assertEquals(list.size(), 2);
        Assert.assertTrue(list.get(0).getText().contains("FREGGIA"));
        Assert.assertTrue(list.get(1).getText().contains("Acer Aspire"));
    }

    @AfterTest
    public void afterTest() {
        driver.close();
    }
}
