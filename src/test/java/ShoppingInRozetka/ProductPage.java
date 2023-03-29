package ShoppingInRozetka;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage{

    @FindBy(xpath = "//app-buy-button/button/span")
    public WebElement buyButton;
    @FindBy(xpath = "//div/button[contains(text(),'Продовжити покупки')]")
    public WebElement shoppingButton;

    @FindBy(xpath = "//ul[contains(@class,'header-actions')]/li[7]//button")
    public WebElement cartButton;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public CartPage clickBuyButton() {
        buyButton.click();
        return new CartPage(driver);
    }

    public void clickShoppingButton() {
        shoppingButton.click();
    }

    public CartPage clickCartIcon() {
        cartButton.click();
        return new CartPage(driver);
    }
}
