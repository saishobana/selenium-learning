package com.demo.test.yahoo.test;

        import com.demo.test.yahoo.pages.SheetReader;
        import com.demo.test.yahoo.pages.YahooHomePage;
        import org.testng.annotations.Test;

/**
 * Created by SAI on 8/13/2016.
 */
public class YahooTest extends BaseTest {
    @Test
    public void testYahooSearch(){
        String textFromExcel;
        tdriver.get().get(config.testurl);
        YahooHomePage homepage=new YahooHomePage(tdriver.get());
       // SheetReader sheetReader=new SheetReader();
      //  textFromExcel=sheetReader.read();
       // homepage.doSearch(textFromExcel);

    }

}
