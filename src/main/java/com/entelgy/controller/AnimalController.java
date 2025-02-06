package com.entelgy.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.entelgy.models.Agua;
import com.entelgy.models.Aire;
import com.entelgy.models.Animal;
import com.entelgy.models.Tierra;
import com.entelgy.models.TipoAmbiente;
import com.entelgy.services.AnimalService;
import com.entelgy.services.AnimalServiceImpl;

public class AnimalController {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		List<Animal> animales = new ArrayList<>();

		System.out.println("Ingrese animales en formato: nombre|tipo|onomatopeia");
		System.out.println("Ejemplo: Rex|Terrestre|Guau   (Escriba 'fin' para terminar)");

		while (true) {
			System.out.print("> ");
			String input = scanner.nextLine();

			if (input.equalsIgnoreCase("fin")) {
				break;
			}

			String[] partes = input.split("\\|");

			if (partes.length != 3) {
				System.out.println("Formato incorrecto. Debe ser: nombre|tipo|onomatopeya");
				continue;
			}

			String nombre = partes[0].trim();
			String tipo = partes[1].trim().toLowerCase();
			String onomatopeya = partes[2].trim();

			Animal animal = crearAnimal(nombre, tipo, onomatopeya);

			if (animal != null) {
				animales.add(animal);
				System.out.println("Animal agregado: " + animal.getNombre());
			} else {
				System.out.println("Tipo de animal no reconocido. Intente de nuevo.");
			}
		}

		scanner.close();

		AnimalServiceImpl animalService = new AnimalServiceImpl(animales);
		Map<String, List<Animal>> agrupados = animalService.agruparPorTipoAmbiente();

		System.out.println("\n=== Animales agrupados por tipo de ambiente ===");
		agrupados.forEach((tipo, lista) -> {
			System.out.println("\n" + tipo + ":");
			lista.forEach(animal -> System.out.println(" - " + animal.getNombre() + " hace: " + animal.hacerSonido()));
		});
	}

	private static Animal crearAnimal(String nombre, String tipo, String onomatopeya) {
		switch (tipo) {
		case "terrestre":
			return new Tierra(nombre, onomatopeya);
		case "volador":
			return new Aire(nombre, onomatopeya);
		case "acuatico":
			return new Agua(nombre, onomatopeya);
		default:
			return null;
		}
	}
}
