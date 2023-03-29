package ShoppingInRozetka;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage{

    @FindBy(xpath = "//ul[@class='cart-list']/li")
    public List<WebElement> productList;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public List<String> getNamesOfProductsInCart() {
        List<String> names = new ArrayList<>();
        for (WebElement element : productList) {
            names.add(element.getText());
        }
        return names;
    }
}
