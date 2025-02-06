package com.entelgy.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.entelgy.models.Agua;
import com.entelgy.models.Aire;
import com.entelgy.models.Animal;
import com.entelgy.models.Tierra;
import com.entelgy.services.AnimalService;
import com.entelgy.services.AnimalServiceImpl;

@Configuration
public class AnimalConfig {
	@Bean
	public List<Animal>animales(){
		return new ArrayList<>();
	}

	
	@Bean
	public AnimalService animalService(List<Animal>animales) {
		//return new AnimalServiceImpl(List.of(tierra(),aire(),agua()));
		return new AnimalServiceImpl(animales);
	}
	
	
}
