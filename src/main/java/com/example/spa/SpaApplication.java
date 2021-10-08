package com.example.spa;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

@SpringBootApplication
@RestController
public class SpaApplication {
	private final static java.util.logging.Logger LOGGER = Logger.getLogger(SpaApplication.class.getName());

	public static void main(String[] args) {
		LOGGER.setLevel(Level.INFO);
		SpringApplication.run(SpaApplication.class, args);
	}

	@GetMapping("/api/weather/")
	public String weather() throws IOException {
		String town = "Marseille";
		Weather weather = new Weather(town);

		JSONObject a = new JSONObject(weather.get_weather().toString());

		JSONObject jsonObject = new JSONObject(a.toString());

		LOGGER.info(jsonObject.toString());
		//return jsonObject.get("woeid").toString();

		String meteo2 = "https://www.metaweather.com/api/location/";
		LOGGER.info(meteo2);
		URL urlMeteo2 = new URL(meteo2 + jsonObject.get("woeid").toString());
		LOGGER.info(urlMeteo2.toString());
		JSONObject jo2 = null;
		HttpURLConnection con2 = (HttpURLConnection) urlMeteo2.openConnection();
		con2.setRequestMethod("GET");
		int status = con2.getResponseCode();
		if (status == 200) {
			BufferedReader in = new BufferedReader(new InputStreamReader(con2.getInputStream()));
			String inputLine;
			StringBuffer content2 = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				//inputLine = inputLine.replace("[", "").replace("]","");
				content2.append(inputLine);

			}
			LOGGER.info("Content of Json: "+content2.toString());
			jo2 = new JSONObject(content2.toString());

		}
		LOGGER.info(jo2.toString());

		//JSONObject myString = new JSONObject().put("day", jo2.getJSONArray("consolidated_weather").get("applicable_date")).toString();
		//JSONObject myString = new JSONObject(jo2);

		JSONArray arr = jo2.getJSONArray("consolidated_weather");
		String date = null;
		String TempsMeteo = null;
		Object picture_weather = null;
		JSONObject joFinal = new JSONObject();
		joFinal.put("content", new JSONArray());
		JSONArray list_fill = (JSONArray) joFinal.get("content");
		int Temperature = 0;

		for (int i = 0; i < arr.length(); i++) {
			var t = arr.getJSONObject(i);
			var dct = new JSONObject();
			date = t.getString("applicable_date");
			TempsMeteo = t.getString("weather_state_name");
			Temperature = t.getInt("the_temp");
			picture_weather = null;
			if(TempsMeteo == "Heavy Cloud" || TempsMeteo == "Showers" ||TempsMeteo == "Light Cloud" || TempsMeteo == "Light Rain" || TempsMeteo == "Heavy Rain"){
				Weather meteoChien = new Weather(town);
				picture_weather = meteoChien.get_UrlDog().toString();

			}
			if(TempsMeteo == "Clear" || TempsMeteo == "Sunny" ||TempsMeteo == "Light Cloud"){
				Weather meteoChat = new Weather(town);
				picture_weather = meteoChat.get_UrlCats().toString();


			}
			else {
				Weather meteoFox = new Weather(town);
				picture_weather = meteoFox.get_UrlFox().toString();
			}
			LOGGER.info("url annimaux: "+picture_weather.toString());
			//LOGGER.info(picture_weather.toString());
			dct.put("date", date).put("weather",TempsMeteo).put("picture_weather",picture_weather).put("temperature", Temperature);
			list_fill.put(dct);
			//return consolidated_weather;
		}
		LOGGER.info("dernier json: "+joFinal.toString());

		return joFinal.toString();
		//return jo2.toString();

	}


//	@GetMapping("/dog")
//	public URL dog() throws MalformedURLException {
//		Weather weather = new Weather();
//
//		URL a = weather.dog();
//		LOGGER.info("retourne le chien");
//		return a;
//	}

//	@GetMapping("/fox")
//	public URL fox() throws MalformedURLException{
//		Weather weather = new Weather();
//		LOGGER.info("retourne le renard");
//		URL a = weather.fox();
//		return a;
//	}

//	@GetMapping(value = "/image")
//	public @ResponseBody byte[] getImage() throws IOException {
//		InputStream in = getClass()
//				.getResourceAsStream("C:/Users/utilisateur/Pictures/Saved Pictures/tigre.jpg");
//		return IOUtils.toByteArray(in);
//	}


}
