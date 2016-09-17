package com.demo.test.yahoo.test;

import com.demo.test.common.config.TestConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

/**
 * Created by SAI on 8/13/2016.
 */
public class BaseTest {

    static ThreadLocal<WebDriver> tdriver = new ThreadLocal<WebDriver>();
    protected TestConfig config;

    @BeforeTest
    public void beforeSuite(){
        config = new TestConfig();
        System.out.println("*****"+config.browsertype);
        if(config.browsertype.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver","D:\\geckodriver.exe");
           tdriver.set(new FirefoxDriver());
        }
        else if(config.browsertype.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
            tdriver.set(new ChromeDriver());
        }
    }
}
