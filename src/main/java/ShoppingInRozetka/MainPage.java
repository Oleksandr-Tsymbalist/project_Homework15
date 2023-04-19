package ShoppingInRozetka;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {
    @FindBy(name = "search")
    public WebElement searchInput;

    @FindBy(xpath = "//div//button[contains(text(),'Знайти')]")
    public WebElement searchButton;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public SearchPage clickSearchButton() {
        searchButton.click();
        return new SearchPage(driver);
    }

    public void inputSearchValue(String value) {
        searchInput.sendKeys(value);
    }
}
