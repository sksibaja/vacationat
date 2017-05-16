package com.gap.atpractice.selenium;

import com.thoughtworks.selenium.Selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by auto on 06/04/17.
 */
public class SeleniumBase {
    private WebDriver driver;

    public WebDriver setup(String browserName){
        switch (browserName){
            case "Chrome":
                initChrome();
                break;
            case "Firefox":
                initFirefox();
                break;
            case "IE":
                initIE();
                break;
            default:
                System.out.println("Driver not found");
                break;
        }
        return driver;
    }

    private void initChrome(){

        DesiredCapabilities options = setChromeCapabilities();
        this.driver = new ChromeDriver(options);

    }

    private void initFirefox(){
        this.driver = new ChromeDriver();
    }

    private void initIE(){
        this.driver = new InternetExplorerDriver();
    }

    //Capabilities settings

    private DesiredCapabilities setChromeCapabilities(){

        ChromeOptions  chromeOptions = new ChromeOptions();
        DesiredCapabilities capabilities = new DesiredCapabilities();

        chromeOptions.addArguments("start-maximized");
        chromeOptions.addArguments(CapabilityType.ACCEPT_SSL_CERTS);
        chromeOptions.addArguments("-incognito");

        capabilities.setCapability("browser.startup.homepage", "https://jsfiddle.net/L6qggtub/2/show/");
        capabilities.setCapability(ChromeOptions.CAPABILITY,chromeOptions);

        return (capabilities);
    }

}
