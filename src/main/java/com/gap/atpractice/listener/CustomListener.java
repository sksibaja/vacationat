package com.gap.atpractice.listener;

import com.gap.atpractice.testSuites.TestBase;
import com.gap.atpractice.utils.TakeScreenshot;
import com.gap.atpractice.utils.Utils;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * Created by ssibaja on 6/8/17.
 */
public class CustomListener implements ITestListener {

    private static String FILES_STORAGE_PATH = "./src/main/resources/screenshots/";
    private Utils utils;

    public CustomListener(){
        utils = new Utils();
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        printExecutionSummary(iTestResult);

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {

        printExecutionSummary(iTestResult);
        WebDriver driver = ((TestBase)(iTestResult.getInstance())).getDriver();
        new TakeScreenshot().takeScreenshot(driver, FILES_STORAGE_PATH + utils.getCurrentDate() + ".png");

    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println(" =========================     Test Summary from Listener     ========================= ");
        System.out.println(String.format("%s%s%s", "Test Name: ", iTestResult.getName().toString(), " skipped."));
        System.out.println(String.format("%s%s", "Time: ", iTestResult.getStartMillis()).toString());
        System.out.println(" ====================================================================================== ");

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }

    private void printExecutionSummary(ITestResult result){
        System.out.println(" =========================     Test Summary from Listener     ========================= ");
        System.out.println(String.format("%s%s", "Test Name: ", result.getName()).toString());
        System.out.println(String.format("%s%s", "Status: ", result.getStatus()).toString());
        System.out.println(String.format("%s%s", "Time: ", result.getStartMillis()).toString());
        System.out.println(" ====================================================================================== ");

    }
}
