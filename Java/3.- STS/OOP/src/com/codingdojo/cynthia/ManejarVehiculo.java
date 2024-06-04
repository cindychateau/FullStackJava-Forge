package com.codingdojo.cynthia;

public interface ManejarVehiculo {
	
	/*Métodos default: NO necesita ser implementado, sino que se "hereda" 
	directamente a las clases en las que se implementa la interfaz*/
	/*
	 Métodos abstractos: son aquellos que OBLIGAMOS a nuestra clase
	 a implementar
	 */
	/*
	 Métodos estáticos: son aquellos que perteneces a la interfaz. "Ayudantes" 
	 */
	
	public default void manejar() {
		System.out.println("Se está manejando el vehiculo");
	}
	
	public default void reposo() {
		System.out.println("El vehiculo está detenido");
	}
	
	abstract void acelerar();
	abstract void desacelerar();
	//abstract int otroMetodo(int num);
	
	
}