package com.demo.test.yahoo.pages;

import com.demo.test.common.page.PageBase;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;

/**
 * Created by SAI on 8/13/2016.
 */

public class YahooHomePage extends PageBase {
    private String searchbox = "uh-search-box";
    private String searchbutton = "uh-search-button";

    public void doSearch(String searchtext) {
        driver.findElement(By.id(searchbox)).click();
        driver.findElement(By.id(searchbox)).sendKeys(searchtext);
        driver.findElement(By.id(searchbutton)).click();
    }

    public YahooHomePage(WebDriver driver) {
        super(driver);
    }
}

