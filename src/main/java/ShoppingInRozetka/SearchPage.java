package ShoppingInRozetka;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchPage extends BasePage{

    @FindBy(xpath = "//ul[contains(@class,'catalog-grid')]/li[3]")
    public WebElement selectProduct;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public ProductPage clickSelectProduct(){
        wait.until(ExpectedConditions.elementToBeClickable(selectProduct));
        selectProduct.click();
        return new ProductPage(driver);
    }
}
