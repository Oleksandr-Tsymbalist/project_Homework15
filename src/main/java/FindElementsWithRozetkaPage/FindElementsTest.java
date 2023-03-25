package FindElementsWithRozetkaPage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static java.lang.String.format;

public class FindElementsTest extends BaseTest {

    private static final By DISCUSSED_PRODUCTS_LIST = By.xpath("//h2[contains(text(),'Найбільш обговорювані товари')]/following-sibling::ul/li");
    private static final By DISCUSSED_PRODUCTS_NAME = By.xpath(".//a[2]");
    private static final By DISCUSSED_PRICE = By.xpath(".//div[contains(@class,'tile__price_color_red')]");
    private static final int ITERATIONS = 10;


    @Test
    public void findElementsTest() {
        int iterations = 0;
        while (driver.findElements(DISCUSSED_PRODUCTS_LIST).size() == 0 && iterations < ITERATIONS) {
            scrollByPixels(500);
            iterations++;
        }

        if (iterations >= ITERATIONS){
            throw new RuntimeException(format("List with elements not found after %s iterations", iterations));
        }

        for (WebElement element : driver.findElements(DISCUSSED_PRODUCTS_LIST)) {
            System.out.printf("%s коштує %s грн\n", element.findElement(DISCUSSED_PRODUCTS_NAME).getText(), element.findElement(DISCUSSED_PRICE).getText());
        }
    }
}