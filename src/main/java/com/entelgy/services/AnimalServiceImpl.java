package com.entelgy.services;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.entelgy.models.Animal;

@Service
public class AnimalServiceImpl  implements AnimalService{
	private List<Animal> animales;

	public AnimalServiceImpl(List<Animal> animales) {
		this.animales = animales;
	}
	@Override
	public Map<String, List<Animal>> agruparPorTipoAmbiente()
	{
		return animales.stream().collect(Collectors.groupingBy(Animal::getTipoAmbiente));
	}
	@Override
	public void mostrarAnimalesAgrupados() {
		agruparPorTipoAmbiente().forEach((tipo, lista) -> {
            System.out.println("Tipo de ambiente: " + tipo);
            lista.forEach(animal -> System.out.println("  - " + animal.getNombre() + " hace " + animal.hacerSonido()));
            System.out.println("------------------------------");
        });
		
	}
}
