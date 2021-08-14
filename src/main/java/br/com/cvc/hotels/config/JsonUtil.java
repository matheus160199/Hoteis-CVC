package br.com.cvc.hotels.config;

import java.time.LocalDate;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.converter.gson.GsonConverterFactory;

public abstract class JsonUtil {
	
	public static GsonConverterFactory createGsonConverterFactory() {
		return GsonConverterFactory.create(createGson());
	}

	private static Gson createGson() {
		return new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				 .registerTypeAdapter(LocalDate.class, new DateAdapter())
				 .setPrettyPrinting()
				 .setDateFormat("dd/MM/yyyy")
				 .create();
	}
	public static GsonBuilder createGsonBuilder() {
		return new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
					 .registerTypeAdapter(LocalDate.class, new DateAdapter())
					 .setDateFormat("dd/MM/yyyy")
					 .setPrettyPrinting();
	}
}
