package com.codingdojo.cynthia;

public class Cuadrado extends Figura {
	
	private double longitud;

	public Cuadrado(double longitud) {
		super();
		this.longitud = longitud;
	}
	
	public double area() {
		return longitud*longitud;
	}
	
}
