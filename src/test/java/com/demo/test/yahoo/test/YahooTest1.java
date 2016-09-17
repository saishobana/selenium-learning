package com.demo.test.yahoo.test;

import com.demo.test.common.config.TestConfig;
import com.demo.test.yahoo.pages.YahooHomePage;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by SAI on 8/13/2016.
 */
public class YahooTest1 extends BaseTest {


    @Test
    public void testYahooSearch(){
       // tdriver.get().get("http://yahoo.com");
        tdriver.get().get(config.testurl);
        YahooHomePage homepage=new YahooHomePage(tdriver.get());
        homepage.doSearch("India");
    }

}
