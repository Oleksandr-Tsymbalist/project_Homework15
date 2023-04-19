package tests;

import org.testng.annotations.Test;

public class SelectionOfPhoneDiagonalsTest extends BaseTest {

    private static final double DIAGONAL = 2.2;

    @Test
    public void selectionOfPhoneDiagonals() {
        mainPage.clickPhonesAndElectronic()
                .clickMobilePhone()
                .selectScreenPhonesDiagonal(DIAGONAL)
                .verifyFilterValueInHeadOfGrid();
    }
}
