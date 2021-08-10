package br.com.cvc.hotels.config;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.converter.gson.GsonConverterFactory;

public abstract class JsonUtil {
	
	public static GsonConverterFactory createGsonConverterFactory() {
		return GsonConverterFactory.create(createGson());
	}
	
	protected String json(final Object object){
		return JsonUtil.asJson(object);
	}
	
	public static <T> T asObject(String json, Class<T> clazz) {
		return createGson().fromJson(json, clazz);
	}

	public static <T> String asJson(T object) {
		return createGson().toJson(object);
	}

	private static Gson createGson() {
		return new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
			 	 .registerTypeAdapter(LocalDateTime.class, new DateTimeAdapter())
				 .registerTypeAdapter(LocalDate.class, new DateAdapter())
				 .setPrettyPrinting()
				 .setDateFormat("dd/MM/yyyy")
				 .create();
	}
	public static GsonBuilder createGsonBuilder() {
		return new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				 	 .registerTypeAdapter(LocalDateTime.class, new DateTimeAdapter())
					 .registerTypeAdapter(LocalDate.class, new DateAdapter())
					 .setDateFormat("dd/MM/yyyy")
					 .setPrettyPrinting();
	}
}
