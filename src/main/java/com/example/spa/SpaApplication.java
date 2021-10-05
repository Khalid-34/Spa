package com.example.spa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
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

	@GetMapping("/hello")
	public String hello() {
		LOGGER.info("retour hello");
		return "BonJour MOI";
	}

	@GetMapping("/cats")
	public BufferedImage cats() throws IOException {
		Weather weather = new Weather();

		BufferedImage a = weather.cats();
		LOGGER.info("retoure le chat");
		return a;
	}

	@GetMapping("/dog")
	public URL dog() throws MalformedURLException {
		Weather weather = new Weather();

		URL a = weather.dog();
		LOGGER.info("retourne le chien");
		return a;
	}

	@GetMapping("/fox")
	public URL fox() throws MalformedURLException{
		Weather weather = new Weather();
		LOGGER.info("retourne le renard");
		URL a = weather.fox();
		return a;
	}

//	@GetMapping(value = "/image")
//	public @ResponseBody byte[] getImage() throws IOException {
//		InputStream in = getClass()
//				.getResourceAsStream("C:/Users/utilisateur/Pictures/Saved Pictures/tigre.jpg");
//		return IOUtils.toByteArray(in);
//	}


}
