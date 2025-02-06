package com.entelgy.services;

import java.util.List;
import java.util.Map;

import com.entelgy.models.Animal;

public interface AnimalService {
	Map<String, List<Animal>>agruparPorTipoAmbiente();
	void mostrarAnimalesAgrupados();
}
