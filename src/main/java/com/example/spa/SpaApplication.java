package com.example.spa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.MalformedURLException;
import java.net.URL;

@SpringBootApplication
@RestController
public class SpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpaApplication.class, args);
	}

	@GetMapping("/hello")
	public String hello() {

		return "helloqqqqqqq";
	}

	@GetMapping("/cats")
	public URL cats() throws MalformedURLException {
		Weather weather = new Weather();

		URL a = weather.cats();
		return a;
	}

	@GetMapping("/dog")
	public URL dog() throws MalformedURLException {
		Weather weather = new Weather();

		URL a = weather.dog();
		return a;
	}

	@GetMapping("/fox")
	public URL fox() throws MalformedURLException{
		Weather weather = new Weather();

		URL a = weather.fox();
		return a;
	}



}
