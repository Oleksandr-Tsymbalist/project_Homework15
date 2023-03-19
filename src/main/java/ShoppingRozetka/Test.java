package ShoppingRozetka;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) throws InterruptedException{
        WebDriverManager.chromedriver().arch64().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://rozetka.com.ua/ua/");

        WebElement inputField = driver.findElement(By.name("search"));
        inputField.sendKeys("Acer Aspire");

        WebElement findButton = driver.findElement(By.xpath("//div//button[contains(text(),'Знайти')]"));
        findButton.click();
        Thread.sleep(1000);

        WebElement findAcerElement = driver.findElement(By.xpath("//ul[contains(@class,'catalog-grid')]/li[3]"));
        findAcerElement.click();

        WebElement findBuyButton = driver.findElement(By.xpath("//app-buy-button/button/span"));
        findBuyButton.click();
        Thread.sleep(1000);

        WebElement findShoppingButton = driver.findElement(By.xpath("//div/button[contains(text(),'Продовжити покупки')]"));
        findShoppingButton.click();

        WebElement inputFieldSecondProduct = driver.findElement(By.name("search"));
        inputFieldSecondProduct.sendKeys("FREGGIA");

        WebElement findButtonSecondProduct = driver.findElement(By.xpath("//div//button[contains(text(),'Знайти')]"));
        findButtonSecondProduct.click();
        Thread.sleep(1000);

        WebElement findFreggiaElement = driver.findElement(By.xpath("//ul[contains(@class,'catalog-grid')]/li[3]"));
        findFreggiaElement.click();

        WebElement findFreggiaBuyButton = driver.findElement(By.xpath("//app-buy-button/button/span"));
        findFreggiaBuyButton.click();
        Thread.sleep(1000);

        WebElement findFreggiaShoppingButton = driver.findElement(By.xpath("//div/button[contains(text(),'Продовжити покупки')]"));
        findFreggiaShoppingButton.click();

        WebElement findCartButton = driver.findElement(By.xpath("//ul[contains(@class,'header-actions')]/li[7]//button"));
        findCartButton.click();

        List<WebElement> list = driver.findElements(By.xpath("//ul[@class='cart-list']/li"));
        for (WebElement element : list) {
            System.out.println(element);
        }









        //driver.close();


    }
}
