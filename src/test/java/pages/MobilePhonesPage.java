package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;
import java.util.regex.Pattern;

public class MobilePhonesPage extends BasePage {
    private static String checkboxValue;

    @FindBy(xpath = "//div[@data-filter-name='23777']//ul/li/a")
    private List<WebElement> screenDiagonalPhonesList;

    @FindBy(xpath = "//a[@class='catalog-selection__link']")
    private WebElement selectedFilterValueInHeader;

    public MobilePhonesPage(WebDriver driver) {
        super(driver);
    }

    public MobilePhonesPage selectScreenPhonesDiagonal(double diagonalForSelect) {
        wait.until(ExpectedConditions.visibilityOf(screenDiagonalPhonesList.get(0)));
        for (WebElement element : screenDiagonalPhonesList) {

            if (element.getText().contains("-")) {
                var parsedValue = parseStringByRegexp("([\\d.-]+)(\\D+)([\\d.-]+)(\\D)", element.getText());
               var diagonals = parsedValue.replaceAll("[\" ]", "").split("-");
               if (diagonalForSelect >= Double.parseDouble(diagonals[0]) && diagonalForSelect <= Double.parseDouble(diagonals[1])) {
                   checkboxValue = parsedValue;
                   element.click();
                   break;
               }
            } else {
                var parsedValue = parseStringByRegexp("([\\d.-]+)(\\D)+\\B", element.getText()).trim();
                var diagonal = parseStringByRegexp("[\\d.-]+", element.getText()).trim();
                if (screenDiagonalPhonesList.get(0).equals(element) && diagonalForSelect <= Double.parseDouble(diagonal)) {
                    checkboxValue = parsedValue;
                    element.click();

                    break;
                } else if (screenDiagonalPhonesList.get(screenDiagonalPhonesList.size() -1).equals(element) && diagonalForSelect >= Double.parseDouble(diagonal)) {
                    checkboxValue = parsedValue;
                    element.click();
                    break;
                }
            }
        }
        return new MobilePhonesPage(driver);
    }

    public void verifyFilterValueInHeadOfGrid() {
        wait.until(ExpectedConditions.visibilityOf(selectedFilterValueInHeader));
        System.out.println(checkboxValue.toLowerCase());
        System.out.println(selectedFilterValueInHeader.getText());
        Assert.assertEquals(checkboxValue.toLowerCase(), selectedFilterValueInHeader.getText());
    }

    private String parseStringByRegexp(String pattern, String text) {
        var currentPattern = Pattern.compile(pattern);
        var matcher = currentPattern.matcher(text);
        matcher.find();
        return matcher.group();
    }
}