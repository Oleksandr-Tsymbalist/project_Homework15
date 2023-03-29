package ShoppingInRozetka;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static java.lang.String.format;

public class RozetkaTest extends BaseTest{
    private ProductPage productPage;
    private CartPage cartPage;

    @Test
    public void rozetkaTest () {
        for (String product : products) {
            mainPage.inputSearchValue(product);
            productPage = mainPage.clickSearchButton()
                    .clickSelectProduct();
            productPage.clickBuyButton();
            sleepALittleBit(1);
            productPage.clickShoppingButton();
        }
        cartPage = productPage.clickCartIcon();

        List<String> actualProductsNames = cartPage.getNamesOfProductsInCart();
        Assert.assertEquals(actualProductsNames.size(), products.length);

        for (String productName : products) {
            assertThatListContainsValue(actualProductsNames, productName);
        }
    }

    public void assertThatListContainsValue(List<String> list, String expectedValue) {
        boolean containsValue = false;
        for (String element : list) {
            if (element.contains(expectedValue)) {
                containsValue = true;
                break;
            }
        }
        Assert.assertTrue(containsValue, format("List not contains expected value %s", expectedValue));
    }
}
