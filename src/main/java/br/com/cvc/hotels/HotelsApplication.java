package br.com.cvc.hotels;

import static br.com.cvc.hotels.config.JsonUtil.createGsonBuilder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

import com.google.gson.GsonBuilder;

@EnableCaching
@SpringBootApplication
public class HotelsApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelsApplication.class, args);
	}

	@Bean
	GsonBuilder gsonBuilder() {
		return createGsonBuilder();
	}
}
