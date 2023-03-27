package ShoppingInRozetka;

import org.testng.annotations.Test;

public class RozetkaTest extends BaseTest{
    private ProductPage productPage;
    private CartPage cartPage;

    @Test
    public void rozetkaTest () {
        /*
        Якщо у файл product.properties додати ще один товар, як це відобразиться на вашому тестовому методі?
        Ніяк! Бо ви конкретно прописуєте, що саме 3 товари треба додати в корзину. Цикл може вирішити
        цю проблему)
        */
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
