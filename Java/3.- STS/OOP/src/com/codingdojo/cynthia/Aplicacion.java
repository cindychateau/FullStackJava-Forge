package com.codingdojo.cynthia;

import java.util.ArrayList;

public class Aplicacion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Vehiculo auto1 = new Vehiculo(2010, "Honda", "Civic", "Rojo", 4);
		System.out.println("Marca Auto1: "+auto1.getMarca());
		System.out.println(auto1);
		
		/*Para agregar importación: Ctrl + Shift + O*/
		ArrayList<Integer> lista = new ArrayList<Integer>();
		
		Auto automovil = new Auto(2020, "Fiat", "Cronos", "Verde", 4, "ABC1234");
		System.out.println("Color automovil: "+automovil.getColor());
		System.out.println(automovil); //¿Qué se va a imprimir?
		automovil.imprimirAuto();
		
	}

}