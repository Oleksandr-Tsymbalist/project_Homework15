package Listeners;

import org.testng.annotations.DataProvider;

public class MyData {

    @DataProvider
    public Object[][] getDataForSumAddition() {
        return new Object[][]{
                {3, 3, 6}
        };
    }

    @DataProvider
    public Object[][] getDataForSubtraction() {
        return new Object[][]{
                {3, 3, 0}
        };
    }

    @DataProvider
    public Object[][] getDataForMultiply() {
        return new Object[][]{
                {3, 3, 9}
        };
    }

    @DataProvider
    public Object[][] getDataForDivision() {
        return new Object[][]{
                {9, 3, 3}
        };
    }
}