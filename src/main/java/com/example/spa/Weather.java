package com.example.spa;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.logging.Logger;

import java.io.IOException;
import java.net.*;

public class Weather {
    private String town;

    public Weather(String town) {
        this.town = town;
    }


    private final static Logger LOGGER = Logger.getLogger(Weather.class.getName());


    public Object get_weather() throws IOException {
        LOGGER.info(this.town);
        String meteo = "https://www.metaweather.com/api/location/search/?query=";
        LOGGER.info(meteo);
        URL urlMeteo = new URL(meteo +town);
        LOGGER.info(urlMeteo.toString());
        JSONObject jo = null;
        HttpURLConnection con = (HttpURLConnection) urlMeteo.openConnection();
        con.setRequestMethod("GET");

        int status = con.getResponseCode();
        if (status == 200) {
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                inputLine = inputLine.replace("[", "").replace("]","");
                content.append(inputLine);

            }
            LOGGER.info(content.toString()+"ssss");
            jo = new JSONObject(content.toString());
            //return jo;
        }
        LOGGER.info(jo.get("woeid").toString());
        return jo;


        


        // GET CAT IMAGE
        /*
        URL url = new URL("https://aws.random.cat/meow");
        LOGGER.info("prend l':  " + url.toString());
        JSONObject jo = null;
        LOGGER.info("Connexion a l'URL: ");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        int status = con.getResponseCode();
        LOGGER.info(String.valueOf(status));
        if (status == 200) {
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            // Now use JSONObject to transform content into a Json
            LOGGER.info(content.toString());
            jo = new JSONObject(content.toString());
            LOGGER.info(jo.get("file").toString());
            //return jo.get("file").toString();
        }
        //return jo.get("file").toString();

         */

    }
    public Object get_UrlCats() throws IOException{

        // GET CAT IMAGE
        URL url = new URL("https://aws.random.cat/meow");
        LOGGER.info("prend l':  " + url.toString());
        JSONObject jo = null;
        LOGGER.info("Connexion a l'URL: ");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        int status = con.getResponseCode();
        LOGGER.info(String.valueOf(status));
        if (status == 200) {
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            // Now use JSONObject to transform content into a Json
            LOGGER.info(content.toString());
            jo = new JSONObject(content.toString());
            LOGGER.info(jo.get("file").toString());
            //return jo.get("file").toString();
        }
        return jo.get("file").toString();

    }
    public Object get_UrlDog() throws IOException{

        // GET DOG IMAGE
        URL url = new URL("https://random.dog/woof.json");
        LOGGER.info("prend l':  " + url.toString());
        JSONObject jo = null;
        LOGGER.info("Connexion a l'URL: ");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        int status = con.getResponseCode();
        LOGGER.info(String.valueOf(status));
        if (status == 200) {
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            // Now use JSONObject to transform content into a Json
            LOGGER.info(content.toString());
            jo = new JSONObject(content.toString());
            LOGGER.info(jo.get("url").toString());
            //return jo.get("file").toString();
        }
        return jo.get("url").toString();
    }

    public Object get_UrlFox() throws IOException{

        //GET FOX IMAGE
        URL url = new URL("https://randomfox.ca/floof/");
        LOGGER.info("prend l':  " + url.toString());
        JSONObject jo = null;
        LOGGER.info("Connexion a l'URL: ");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        int status = con.getResponseCode();
        LOGGER.info(String.valueOf(status));
        if (status == 200) {
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            // Now use JSONObject to transform content into a Json
            LOGGER.info(content.toString());
            jo = new JSONObject(content.toString());
            LOGGER.info(jo.get("image").toString());
            //return jo.get("file").toString();
        }
        return jo.get("image").toString();

    }




//    public URL dog() throws MalformedURLException {
//        URL urldog = new URL("https://random.dog/");
//        return urldog;
//    }
//
//    public URL fox() throws MalformedURLException {
//        URL urlfox = new URL("https://randomfox.ca/");
//        return urlfox;
//    }


}
