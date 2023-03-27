package ShoppingInRozetka;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class CartPage extends BasePage{

    @FindBy(xpath = "//ul[@class='cart-list']/li")
    public List<WebElement> productList;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void assertProductList(String... products) {
        Assert.assertEquals(productList.size(), 3);
        Assert.assertTrue(productList.get(0).getText().contains(products[2]));
        Assert.assertTrue(productList.get(1).getText().contains(products[1]));
        Assert.assertTrue(productList.get(2).getText().contains(products[0]));
    }
}
