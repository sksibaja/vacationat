package com.gap.atpractice.botstyletest;
import com.google.common.base.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by ssibaja on 5/18/17.
 */
public class BotStyle {

    private WebDriver driver;

    public BotStyle (WebDriver driver){
        this.driver = driver;

    }

    public WebDriver getDriver() {
        return this.driver;
    }

    // This is not used by now, but it's ready to be used
    public void waitForPageTitle(int timeToWaitSecs, final String title){

        try{
            (new WebDriverWait(driver, timeToWaitSecs)).until(new ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver d) {
                    return d.getTitle().toLowerCase().startsWith(title.toLowerCase());
                }
            });
        }catch (NoSuchElementException ex){
            ex.printStackTrace();
        }
    }

    public Boolean waitForElementPresent(final By byElement, int timeoutInSeconds){

        try{
            Wait<WebDriver> wait = new WebDriverWait(driver, timeoutInSeconds);
            WebElement we = wait.until(new Function<WebDriver, WebElement>() {
                public WebElement apply(WebDriver driver) {
                    return driver.findElement(byElement);
                }
            });
            return we.isDisplayed();
        }catch (NoSuchElementException ex){
            ex.printStackTrace();
        }
        return null;
    }

    public String getTextOnElementPresent(final By byElement, int timeoutInSeconds){

        try{
            Wait<WebDriver> wait = new WebDriverWait(driver, timeoutInSeconds);
            WebElement we = wait.until(new Function<WebDriver, WebElement>() {
                public WebElement apply(WebDriver driver) {
                    return driver.findElement(byElement);
                }
            });
            return we.getText().toString();
        }catch (NoSuchElementException ex){
            ex.printStackTrace();
        }
        return null;
    }

    //This method is implemented using the locator as parameter.
    public void type (By locator, String text){

        try{
            WebElement we = this.driver.findElement(locator);
            we.clear();
            we.sendKeys(text);
        }catch (NoSuchElementException ex){
            ex.printStackTrace();
        }
    }

    //This method is implemented using the WebElement as parameter
    public void type (WebElement we, String text){
        try{
            we.clear();
            we.sendKeys(text);
        }catch (NoSuchElementException ex){
            ex.printStackTrace();
        }


    }

    public void click (By locator){
        try{
            WebElement we = this.driver.findElement(locator);
            we.click();
        }catch (NoSuchElementException ex){
            ex.printStackTrace();
        }

    }

    public void click (WebElement we){
        we.click();
    }

    public void submit (By locator){
        try{
            WebElement we = this.driver.findElement(locator);
            we.click();
        }catch (NoSuchElementException ex){
            ex.printStackTrace();
        }

    }

}