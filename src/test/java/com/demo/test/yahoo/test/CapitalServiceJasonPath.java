package com.demo.test.yahoo.test;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.ReadContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import org.slf4j.impl.StaticLoggerBinder;

/**
 * Created by Shobana on 9/16/2016.
 */
public class CapitalServiceJasonPath {
    private static String servicePath = "http://services.groupkt.com/state/get/";
    public CapitalServiceJasonPath(String country,String state){
        System.out.println(servicePath);
        servicePath = servicePath+country+"/"+state;
        System.out.println(servicePath);
    }

    private static String getJsonResponse(String servicePath) throws IOException {
        URL url = new URL(servicePath);
        String capital;
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.connect();
        // Convert to a JSON object to print data
        JsonParser jp = new JsonParser(); //from gson

        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
        String response = root.toString();
        //Convert the input stream to a json element

        //println(json.get("messages").getAsString();
        return response;
    }

   private static String getCapital(String json){
       ReadContext ctx = JsonPath.parse(json);
      // List<String> capitalNames=ctx.read("$.RestResponse.result.capital");
       //"$.store.book[?(@.isbn)].author");

      String Capital=JsonPath.read(json,"$.RestResponse.result.capital");
        return Capital;
    }

    public static void main(String[] args) throws IOException {
        CapitalServiceJasonPath capitalServicepath= new CapitalServiceJasonPath("IND","TN");
        String json = getJsonResponse(servicePath);
       System.out.println(getCapital(json));
    }
}
