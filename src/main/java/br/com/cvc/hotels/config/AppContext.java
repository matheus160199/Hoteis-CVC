package br.com.cvc.hotels.config;

import java.nio.charset.Charset;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Component;

@Component
public class AppContext implements ApplicationContextAware{

private static ApplicationContext contexto;
	
	@Value("UTF-8")
	private String charsetName;
	

	@Override
	public void setApplicationContext(ApplicationContext appContext) throws BeansException {
		contexto = appContext;
	}

	@Bean
	public StringHttpMessageConverter stringHttpMessageConverter() {
	    return new StringHttpMessageConverter(Charset.forName(charsetName));
	}
	
	public static ApplicationContext getApplicationContext() {
		return contexto;
	}

}
