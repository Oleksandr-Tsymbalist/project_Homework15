package ShoppingInRozetka;

import org.testng.annotations.Test;

public class RozetkaTest extends BaseTest{
    private ProductPage productPage;
    private CartPage cartPage;

    @Test
    public void rozetkaTest () {
        mainPage.inputSearchValue(products[0]);
        productPage = mainPage.clickSearchButton()
                .clickSelectProduct();
        productPage.clickBuyButton();
        sleepALittleBit(1);
        productPage.clickShoppingButton();
        mainPage.inputSearchValue(products[1]);
        productPage = mainPage.clickSearchButton()
                .clickSelectProduct();
        productPage.clickBuyButton();
        sleepALittleBit(1);
        productPage.clickShoppingButton();
        mainPage.inputSearchValue(products[2]);
        productPage = mainPage.clickSearchButton()
                .clickSelectProduct();
        cartPage = productPage.clickBuyButton();
        sleepALittleBit(1);
        cartPage.assertProductList(products);
    }
}
