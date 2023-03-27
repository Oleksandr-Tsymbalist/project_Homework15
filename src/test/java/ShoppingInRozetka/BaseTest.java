package ShoppingInRozetka;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected MainPage mainPage;
    protected WebDriver driver;
    protected String[] products;

    @BeforeTest
    public void initBrowser(){
        products = getPropValue("products").split(",");
        WebDriverManager.chromedriver().arch64().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        mainPage = openRozetka();
    }

    @AfterTest
    public void afterTest() {
        driver.close();
    }

    public MainPage openRozetka() {
        driver.get("https://rozetka.com.ua/ua/");
        return new MainPage(driver);
    }

    public void sleepALittleBit(int second){
        try {
            Thread.sleep(second *1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private String getPropValue(String propName) {
        Properties prop = new Properties();
        try {
            FileInputStream fis = new FileInputStream("src/test/resources/product.properties");
            prop.load(fis);
        } catch (IOException ignored) {
        }
        return prop.getProperty(propName);
    }

}
