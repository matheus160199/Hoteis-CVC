package br.com.cvc.hotels.config;

import static br.com.cvc.hotels.config.JsonUtil.createGsonConverterFactory;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

public class RetrofitUtil {

	private static OkHttpClient okHttpClient = new OkHttpClient.Builder()  
        	.connectTimeout(30, TimeUnit.SECONDS)
        	.readTimeout(30, TimeUnit.SECONDS)
        	.writeTimeout(15, TimeUnit.SECONDS)
        	.build();

	public static <T> T createRepository(String baseUrl , Class<T> clazz) {
		Retrofit retrofit = new Retrofit.Builder()
										.baseUrl(baseUrl)
										.addConverterFactory(createGsonConverterFactory())
										.client(okHttpClient)
										.build();
		return retrofit.create(clazz);
	};
}
