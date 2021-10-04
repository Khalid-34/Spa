package com.example.spa;

import java.net.*;

public class Weather {

    public URL cats() throws MalformedURLException {
        URL url = new URL("https://aws.random.cat");
        return url;
    }

    public URL dog() throws MalformedURLException {
        URL urldog = new URL("https://random.dog/");
        return urldog;
    }

    public URL fox() throws MalformedURLException {
        URL urlfox = new URL("https://randomfox.ca/");
        return urlfox;
    }

}
