package ShoppingInRozetka;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage{

    @FindBy(xpath = "//ul[contains(@class,'catalog-grid')]/li[3]")
    public WebElement selectProduct;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public ProductPage clickSelectProduct(){
        selectProduct.click();
        return new ProductPage(driver);
    }
}
