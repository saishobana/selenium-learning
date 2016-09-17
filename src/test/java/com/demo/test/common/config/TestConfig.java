package com.demo.test.common.config;

/**
 * Created by SAI on 8/13/2016.
 */
//TODO: Pull the parameter xml values and assign it to each variable

public class TestConfig {
    public String testurl = "https://www.yahoo.com/";
    public String username = "xxxx";
    public String password ="yyyy";
    public String chromeDriverPath=null;
    public String iedriverpath=null;
    public String maxtryreentrycount="5";
    public String browsertype="FireFox";

    public TestConfig()
    {
        if (System.getProperty("browser")==null || System.getProperty("browser").trim().length()<2){
            browsertype = "Firefox";
        }else{
            browsertype = System.getProperty("browser");
        }
        String fileName = System.getProperty("config.paramfile");
        if (fileName==null){
            fileName=  "config.xml";
        }
    }


}
