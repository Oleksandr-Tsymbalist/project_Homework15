package FindElementsWithRozetkaPage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class FindElementsTest extends BaseTest {

    private static final By DISCUSSED_PRODUCTS = By.xpath("//h2[contains(text(),'Найбільш обговорювані товари')]");
    private static final By DISCUSSED_PRODUCTS_LIST = By.xpath("//h2[contains(text(),'Найбільш обговорювані товари')]/..//following-sibling::ul/li");
    private static final By DISCUSSED_PRODUCTS_NAME = By.xpath(".//a[2]");
    private static final By DISCUSSED_PRICE = By.xpath(".//div[contains(@class,'tile__price_color_red')]");


    @Test
    public void findElementsTest() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        scrollTo();
        sleepALittleBit(1);
        scrollTo();
        WebElement discussedProducts = driver.findElement(DISCUSSED_PRODUCTS);
        jse.executeScript("arguments[0].scrollIntoView();", discussedProducts);
        for(WebElement element : driver.findElements(DISCUSSED_PRODUCTS_LIST)) {
            System.out.printf("%s коштує %s\n", element.findElement(DISCUSSED_PRODUCTS_NAME).getText(), element.findElement(DISCUSSED_PRICE).getText());
        }
    }
}