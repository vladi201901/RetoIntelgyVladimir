package com.entelgy.models;

public abstract class AnimalBase implements Animal {
	private String nombre;
	private String onomatopeia;
	private TipoAmbiente tipoAmbiente;
	
	public AnimalBase(String nombre, String onomatopeia, TipoAmbiente tipoAmbiente) {
		this.nombre = nombre;
		this.onomatopeia = onomatopeia;
		this.tipoAmbiente = tipoAmbiente;
	}
	
	@Override
	public String getNombre() {
		return nombre;
	}
	
	@Override
	public String hacerSonido() {
		return onomatopeia;
	}
	
	@Override
	public String getTipoAmbiente() {
		return tipoAmbiente.toString();
	}
	
	public void mostrarInformacion() {
		System.out.println("Nombre" + nombre);
		System.out.println("Tipo de ambiente" + tipoAmbiente);
		System.out.println("Sonido caracteristico" + onomatopeia );
		System.out.println("------------------------");
	}
}
