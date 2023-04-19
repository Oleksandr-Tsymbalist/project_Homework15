package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PhonesAndElectronicPage extends BasePage{

    @FindBy(xpath = "//a[contains(text(),'Мобільні телефони')]")
    private WebElement mobilePhones;

    public PhonesAndElectronicPage(WebDriver driver) {
        super(driver);
    }

    public MobilePhonesPage clickMobilePhone() {
        wait.until(ExpectedConditions.visibilityOf(mobilePhones));
        mobilePhones.click();
        return new MobilePhonesPage(driver);
    }
}
