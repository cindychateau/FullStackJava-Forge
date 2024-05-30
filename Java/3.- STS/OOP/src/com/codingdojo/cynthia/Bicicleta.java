package com.codingdojo.cynthia;

public class Bicicleta extends Vehiculo implements ManejarVehiculo {
	
	public void acelerar() {
		System.out.println("Pedaleo más rápido");
		velocidad++;
		System.out.println("Mi velocidad es de:"+velocidad);
	}
	
	public void desacelerar() {
		System.out.println("Bajo despacio los pies para desacelerar");
		velocidad--;
		System.out.println("Mi velocidad es de:"+velocidad);
	}
	
}
