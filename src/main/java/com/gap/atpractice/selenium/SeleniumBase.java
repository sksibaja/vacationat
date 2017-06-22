package com.gap.atpractice.selenium;

import com.thoughtworks.selenium.Selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

/**
 * Created by auto on 06/04/17.
 */
public class SeleniumBase {

    protected WebDriver driver;
    private final int IMPLICIT_WAIT_TIME_SEC = 10;

    // This method calls the init browser's driver method per each browser, according to the browser's name
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

    //This method initializes the Chrome driver with the capabilities set in the "DesiredCapabilities" method
    private void initChrome(){
        DesiredCapabilities desiredCapabilities = setChromeCapabilities();
        this.driver = new ChromeDriver(desiredCapabilities);
        //implicit wait
        this.driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT_TIME_SEC, TimeUnit.SECONDS);

    }

    //This method initializes de Firefox driver
    private void initFirefox(){

        FirefoxProfile fxProfile = setFirefoxPreferences();
        this.driver = new FirefoxDriver(fxProfile);
        this.driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT_TIME_SEC, TimeUnit.SECONDS);

    }

    //This method initializes de IE driver
    private void initIE(){

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        this.driver = new InternetExplorerDriver(desiredCapabilities);
        this.driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT_TIME_SEC, TimeUnit.SECONDS);

    }

    //This method sets the Capabilities settings for Chrome driver
    private DesiredCapabilities setChromeCapabilities(){

        ChromeOptions  chromeOptions = new ChromeOptions();
        DesiredCapabilities capabilities = new DesiredCapabilities();

        chromeOptions.addArguments("start-maximized");
        chromeOptions.addArguments(CapabilityType.ACCEPT_SSL_CERTS);
        //These two configurations are used as a example
        //chromeOptions.addArguments("-incognito");
        //capabilities.setCapability("browser.startup.homepage", "https://jsfiddle.net/L6qggtub/2/show/");
        capabilities.setCapability(ChromeOptions.CAPABILITY,chromeOptions);

        return (capabilities);
    }

    private FirefoxProfile setFirefoxPreferences(){

        FirefoxProfile fxProfile = new FirefoxProfile();
        fxProfile.setPreference("browser.cache.disk.enable", false);
        fxProfile.setPreference("browser.download.useDownloadDir", false);
        //fxProfile.setPreference("about:home", "page");
        fxProfile.setAcceptUntrustedCertificates(true);
        fxProfile.setAssumeUntrustedCertificateIssuer(false);

        return fxProfile;

    }

    private DesiredCapabilities IESetPreferences(){

        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS,false);
        dc.setCapability(InternetExplorerDriver.ENABLE_ELEMENT_CACHE_CLEANUP, true);
        dc.setCapability(CapabilityType.ACCEPT_SSL_CERTS,true);
        dc.setJavascriptEnabled(true);

        return dc;
    }

    //Using the quit method, quits and closes the browser's driver.
    public void quit(){
        this.driver.quit();

    }

}
