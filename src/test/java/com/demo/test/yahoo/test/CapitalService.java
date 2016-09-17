package com.demo.test.yahoo.test;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/**
 * Created by Shobana on 9/16/2016.
 */
public class CapitalService {

    private static String servicePath = "http://services.groupkt.com/state/get/";

     public CapitalService(String country,String state){
         System.out.println(servicePath);
       servicePath = servicePath+country+"/"+state;
         System.out.println(servicePath);
    }

  /*  String sURL = "http://freegeoip.net/json/"; //just a string

    // Connect to the URL using java's native library
    URL url = new URL(sURL);
    HttpURLConnection request = (HttpURLConnection) url.openConnection();
    request.connect();

    // Convert to a JSON object to print data
    JsonParser jp = new JsonParser(); //from gson
    JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent())); //Convert the input stream to a json element
    JsonObject rootobj = root.getAsJsonObject(); //May be an array, may be an object.
    zipcode = rootobj.get("zip_code").getAsString(); //just grab the zipcode
    }



    private static String getUrlContent(Reader rd) throws IOException {
    StringBuilder urlContent = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            urlContent.append((char) cp);
        }
        return urlContent.toString();
    }


  private static JSONObject getJsonResponse(String servicePath) throws IOException, JSONException {
        InputStream is = new URL(servicePath).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = getUrlContent(rd);
            JSONObject json = new JSONObject(jsonText);
            return json;
        } finally {
            is.close();
        }
    }*/
  private static JsonObject getJsonResponse(String servicePath) throws IOException {
      URL url = new URL(servicePath);
      String capital;
      HttpURLConnection request = (HttpURLConnection) url.openConnection();
      request.connect();
      // Convert to a JSON object to print data
      JsonParser jp = new JsonParser(); //from gson

      JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent())); //Convert the input stream to a json element
      JsonObject json = root.getAsJsonObject();

    //println(json.get("messages").getAsString();
      return json;
  }
  public static String getCapital(JsonObject Json) {
      String capital1;
      capital1 = Json.get("RestResponse").getAsJsonObject().get("result").getAsJsonObject().get("capital").toString();
      return capital1;
  }

    public static void main(String[] args) throws IOException {
        CapitalService capitalService= new CapitalService("IND","TN");
        JsonObject json = getJsonResponse(servicePath);
        //System.out.println(getCapital(json));
    }



}
