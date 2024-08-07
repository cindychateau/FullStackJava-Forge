package com.codingdojo.cynthia;

//Heredando de la clase Vehiculo. Solo se puede tener una clase padre
public class Auto extends Vehiculo implements ManejarVehiculo /*, OtraInterface*/ {
	
	//1.- TODOS los atributos del padre (Vehiculo) son heredados
	//2.- TODOS los métodos del padre (Vehiculo) son heredados
	
	private String patente; //Establecer atributos únicos/distintos a los del padre

	public Auto() { //Método constructor vacío
		super(); //Clase superior.
	}

	public Auto(int anio, String marca, String modelo, String color, int ruedas, String patente) {
		super(anio, marca, modelo, color, ruedas); //Vehiculo(anio, marca, modelo, color, ruedas)
		/*
		 this.anio = anio;
		 this.marca = marca;
		 this.modelo = modelo;
		 ...
		 */
		this.patente = patente;
	}

	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}
	
	public void imprimirAuto() {
		//super = Vehiculo -> clase superior/clase padre
		System.out.println(super.getMarca()+"-"+super.getModelo()+": "+patente);
	}
	
	//POLIMORFISMO
	@Override
	public String toString() {
		//return "Auto [anio=" + anio + ", marca=" + super.getMarca() + ", modelo=" + super.getModelo() + ", color=" + super.getColor() + ", ruedas="+ super.getRuedas()+", patente=" + patente + "]";
		
		return super.toString()+" patente:"+patente;
		
	}
	
	public void acelerar() {
		System.out.println("Estoy pisando el acelerador");
		velocidad += 2;
		System.out.println("Mi velocidad es de:"+velocidad);
	}
	
	public void desacelerar() {
		System.out.println("Estoy pisando el freno");
		velocidad -= 2;
		System.out.println("Mi velocidad es de:"+velocidad);
	}
	
	
}
