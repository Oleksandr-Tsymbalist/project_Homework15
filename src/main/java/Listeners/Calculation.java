package Listeners;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class Calculation {

    @Test(priority = 1,dataProvider = "getDataForSumAddition", dataProviderClass = MyData.class)
    public void additionTest(int a, int b, int result){
        assertEquals(a + b, result);
        System.out.printf("Результат додавання: %s + %s = %s\n", a, b, result);
    }

    @Test(priority = 2,dataProvider = "getDataForSubtraction", dataProviderClass = MyData.class)
    public void subtractionTest(int a, int b, int result){
        assertEquals(a - b, result);
        System.out.printf("Результат віднімання: %s - %s = %s\n",  a, b, result);
    }

    @Test(priority = 3,dataProvider = "getDataForMultiply", dataProviderClass = MyData.class)
    public void multiplyTest(int a, int b, int result){
        assertEquals(a * b, result);
        System.out.printf("Результат множиння: %s * %s = %s\n",  a, b, result);
    }

    @Test(priority = 4,dataProvider = "getDataForDivision", dataProviderClass = MyData.class)
    public void divisionTest(int a, int b, int result){
        assertEquals(a / b, result);
        System.out.printf("Результат ділення: %s / %s = %s\n",  a, b, result);
    }
}
