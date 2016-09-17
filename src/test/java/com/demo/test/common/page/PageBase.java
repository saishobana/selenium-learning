package com.demo.test.common.page;

import org.openqa.selenium.WebDriver;

/**
 * Created by SAI on 8/13/2016.
 */
public class PageBase {

    protected WebDriver driver;
    public PageBase(WebDriver driver){
        this.driver = driver;
    }
}
