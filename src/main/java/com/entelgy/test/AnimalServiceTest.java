package com.entelgy.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.entelgy.models.Agua;
import com.entelgy.models.Aire;
import com.entelgy.models.Animal;
import com.entelgy.models.Tierra;
import com.entelgy.services.AnimalServiceImpl;

class AnimalServiceTest {

	private AnimalServiceImpl animalService;

	@BeforeEach
	void setup() {
		animalService = new AnimalServiceImpl(List.of(new Tierra("Rex", "Ladrar"), new Aire("Paloma", "Pio"),
				new Agua("Ballena", "Chillido"), new Tierra("Gato", "Maulla")));
	}

	@Test
	void testAgruparPorTipoAmbiente() {

		Map<String, List<Animal>> agrupados = animalService.agruparPorTipoAmbiente();

		assertEquals(3, agrupados.size());

		assertEquals(2, agrupados.get("TERRESTRE").size());

		assertEquals(1, agrupados.get("VOLADOR").size());

		assertEquals(1, agrupados.get("ACUATICO").size());
	}

	@Test
	void testHacerSonido() {

		Animal perro = new Tierra("Max", "Guau Guau");
		//assertEquals("Max hace: Guau Guau", perro.hacerSonido());

		Animal pajaro = new Aire("Canario", "Tweet");
		//assertEquals("Canario hace: Tweet", pajaro.hacerSonido());
	}

	@Test
	void testMostrarInformacion() {
		Animal pez = new Agua("Dory", "Blub Blub");
		
		assertEquals("Dory", pez.getNombre());		
		
		assertEquals("ACUATICO", pez.getTipoAmbiente());
	}

}
