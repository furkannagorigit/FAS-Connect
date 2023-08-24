package com.fas.connect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

@SpringBootApplication(scanBasePackages= {"com.fas.connect"})
public class ServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
	}
	@Bean
	public ModelMapper mapper() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return modelMapper;
	}
	
	 @Configuration
	    public class GlobalCorsConfig implements WebMvcConfigurer {

	        @Override
	        public void addCorsMappings(CorsRegistry registry) {
	            registry.addMapping("/**")
	                .allowedOrigins("http://localhost:3000")
	                .allowedMethods("GET", "POST", "PUT", "DELETE")
	                .allowedHeaders("*")
	                .allowCredentials(true);
	            
	        }
	    }
}

