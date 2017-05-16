package com.gap.atpractice.pageobject;

        import org.openqa.selenium.By;
        import org.openqa.selenium.JavascriptExecutor;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.support.ui.ExpectedConditions;
        import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by auto on 15/05/17.
 */
public class LoginPage {

    private WebDriver driver;

    private static String URL= "http://vacations.evercoding.com/users/sign_in";

    //Locators
    By pageHeader = By.xpath("#content>h1");
    By userInput = By.cssSelector("#user_email");
    By passInput = By.cssSelector("#user_password");
    By loginBtn = By.xpath(".//*[@id='new_user']/div[3]/p[4]/input");


    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void goToLoginPage (){
        this.driver.get(URL);
    }

    public AdminUsersPage userLogin(String username, String password){

       // WebElement headerElm = (new WebDriverWait(this.driver,10)).until(ExpectedConditions.presenceOfElementLocated(pageHeader));

        //WebElement headerElm = this.driver.findElement(pageHeader);

        if (isPageLoaded(driver,URL)){

            //if(headerElm.isDisplayed()){
                WebElement userInputEl = this.driver.findElement(userInput);
                userInputEl.clear();
                userInputEl.sendKeys(username);

                WebElement passInputEl = this.driver.findElement(passInput);
                passInputEl.clear();
                passInputEl.sendKeys(password);

                WebElement loginBtnEl = this.driver.findElement(loginBtn);
                loginBtnEl.submit();

                System.out.println("Login form submitted");

            //}

        }


        return new AdminUsersPage(this.driver);
    }


    private static boolean isPageLoaded(WebDriver driverPage, String pageURL){
        boolean isLoaded = false;
        driverPage.get(pageURL);
        JavascriptExecutor js = (JavascriptExecutor)driverPage;
        if (js.executeScript("return document.readyState").toString().equals("complete")){
            System.out.println("Overview page is loaded");
            isLoaded = true;
        }
        return isLoaded;
    }
}
