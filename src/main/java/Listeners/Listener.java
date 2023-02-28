package Listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {
    @Override
    public void onTestStart(ITestResult method) {
        System.out.printf("Починається тестування %s\n", method.getName());
    }

    @Override
    public void onTestSuccess(ITestResult method) {
        System.out.printf("Закінчення тестування %s\n", method.getName());
        System.out.println("----------------------------------------");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {

    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {
        System.out.println("Початок загального тестування");
        System.out.println("----------------------------------------");
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        System.out.println("Кінец загального тестування");
        System.out.println("----------------------------------------");
    }
}
