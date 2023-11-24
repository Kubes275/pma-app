package sk.jra.pmaapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import sk.jra.pmaapp.common.utils.RequestMappings;

@SpringBootApplication
public class PmaAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(PmaAppApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				WebMvcConfigurer.super.addCorsMappings(registry);
				registry.addMapping(RequestMappings.API_PROPERTIES_URL + "/**")
					.allowedOrigins("http://localhost:5000", "http://127.0.0.1:5000" )
					.allowedMethods("GET", "POST");
			}
		};
	}

}
