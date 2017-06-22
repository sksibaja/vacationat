package com.gap.atpractice.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.LoadableComponent;
import com.gap.atpractice.botstyletest.BotStyle;

/**
 * Created by ssibaja on 5/25/17.
 */
public abstract class PageBase extends LoadableComponent {

    protected WebDriver driver;
    protected BotStyle botDriver;


    private static String DOMAIN= "https://vacations-management.herokuapp.com/";

    //Constructor initializes both drivers
    public PageBase(WebDriver driver){
        this.driver = driver;
        this.botDriver =  new BotStyle(driver);
    }

    //This method concatenates the domain string + the path string to build the complete URL
    public String getPageURL(String path){

        return String.format("%s%s", DOMAIN, path);
    }

}
