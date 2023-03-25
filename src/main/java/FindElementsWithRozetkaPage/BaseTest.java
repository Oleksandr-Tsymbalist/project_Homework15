package FindElementsWithRozetkaPage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


import java.util.concurrent.TimeUnit;

import static java.lang.String.format;

public class BaseTest {

    protected WebDriver driver;

    @BeforeTest
    public void initBrowser(){
        WebDriverManager.chromedriver().arch64().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://rozetka.com.ua/ua/");
    }

    @AfterTest
    public void afterTest() {
        driver.close();
    }

    public void scrollByPixels(int pixels){
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript(format("window.scrollBy(0, %d)", pixels));
    }

    public void sleepALittleBit(int second){
        try {
            Thread.sleep(second *1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
