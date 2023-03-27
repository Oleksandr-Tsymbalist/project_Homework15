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
        Assert.assertEquals(productList.size(), products.length);
        /*Цей тест дуже легко ламається додаванням товару в product.properties.
        Постарайтеся переписати аби не використовувати індекси цифрами.
        Помістіть у цикл, який буде перебирати ті товари, які є в корзині
        і порівнювати з тими, які є в product.properties. Хоча і цей варіант робочий,
        але він завʼязаний на черзі відображення товарів в корзині. Якщо завтра вони будеть відображатися
        в порядку спадання вартості, то ваш тест впаде. Це більше для гнучкості і унеможливлення
        падіння тесту через певні архітектурні рішення на сайті.*/
        Assert.assertTrue(productList.get(0).getText().contains(products[2]));
        Assert.assertTrue(productList.get(1).getText().contains(products[1]));
        Assert.assertTrue(productList.get(2).getText().contains(products[0]));
    }
}
