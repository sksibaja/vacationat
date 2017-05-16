package com.gap.atpractice.testSuites;

        import com.gap.atpractice.selenium.SeleniumBase;
        import org.openqa.selenium.By;
        import org.openqa.selenium.Keys;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.interactions.Actions;
        import org.openqa.selenium.support.ui.ExpectedConditions;
        import org.openqa.selenium.support.ui.WebDriverWait;

        import java.io.File;

/**
 * Created by auto on 04/05/17.
 */
public class TestAction {

    public static String url = "https://jsfiddle.net/L6qggtub/2/show/";
    //new File("src/main/resources/html/index.html").getAbsolutePath();

    public static void main (String [] args) throws InterruptedException {


        SeleniumBase seleniumBase = new SeleniumBase();
        WebDriver driver = seleniumBase.setup("Chrome");
        //river.manage().window().maximize();
        // driver.get(url);

        WebElement frame = driver.findElement(By.cssSelector("iframe"));
        driver.switchTo().frame(frame);

        WebElement textElement = driver.findElement(By.cssSelector("#double_click"));

        //Double click
        Actions actions = new Actions(driver);
        actions.doubleClick(textElement).build().perform();

        //Drag and drop
        WebElement sourceElement = driver.findElement(By.cssSelector("#draggable>p"));
        WebElement targetElement = driver.findElement(By.cssSelector("#droppable>p"));
        actions.dragAndDrop(sourceElement,targetElement).perform();

        //Key down Key up
        WebElement textArea = driver.findElement(By.cssSelector("html>body>textarea"));
        textArea.click();
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE).perform();

        //Move to element
/*
        WebElement menuElement = driver.findElement(By.xpath("html/body/div[1]/button"));
        WebElement subMenuElement1 = driver.findElement(By.xpath(".html/body/div[1]/div/a[1]"));
        WebElement subMenuElement2 = driver.findElement(By.xpath(".html/body/div[1]/div/a[2]"));
        WebElement subMenuElement3 = driver.findElement(By.xpath(".html/body/div[1]/div/a[3]"));
        actions.moveToElement(menuElement).
                moveToElement(subMenuElement1).moveToElement(subMenuElement2).
                moveToElement(subMenuElement3).build().perform();
        */


        Thread.sleep(5000);
        driver.quit();
    }

}
