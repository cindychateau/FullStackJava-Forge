package com.codingdojo.cynthia;

import java.util.Random;

public class BankAccount {
	
	
	private String numeroCuenta; //"1234567890"
	private double saldoCuentaCorriente;
	private double saldoCuentaAhorros;
	
	private static int cantidadCuentas = 0; //Cuántas cuentas se han creado
	private static double totalDinero = 0;  //Cuánto dinero tenemos en TODAS las cuentas
	
	private static String generarCuentaAleatoria() {
		String textoNumerosRandom = ""; //String vacío
		
		Random r = new Random(); //Crea una instancia de la clase Random
		//r.nextInt(10); -> Genera un número entre 0-9
		
		/*
		 textoNumerosRandom = ""
		 textoNumerosRandom = "1";
		 textoNumerosRandom = "13";
		 textoNumerosRandom = "138";
		 textoNumerosRandom = "138";
		 ...
		 */
		for(int i=0; i<10; i++) {
			textoNumerosRandom += r.nextInt(10);
		}
		
		return textoNumerosRandom;
	}
	
	//Constructor
	public BankAccount() {
		this.saldoCuentaAhorros = 0;
		this.saldoCuentaCorriente = 0;
		this.numeroCuenta = generarCuentaAleatoria();
		
		BankAccount.cantidadCuentas++;
		
		System.out.println("Tu cuenta es:"+this.numeroCuenta);
	}

	public double getSaldoCuentaCorriente() {
		return saldoCuentaCorriente;
	}

	public double getSaldoCuentaAhorros() {
		return saldoCuentaAhorros;
	}
	
	//depositarDinero(5000, "ahorros");
	public void depositarDinero(double cantidad, String cuenta) {
		//cuenta = "ahorros" o cuenta = "corriente"
		if(cuenta.equals("ahorros")) {
			this.saldoCuentaAhorros += cantidad;
		} else {
			this.saldoCuentaCorriente += cantidad;
		}
		
		BankAccount.totalDinero += cantidad; //totalDinero -> contabilizando todo el dinero depositado
	}
	
	//retirarDinero(5000, "ahorros");
	public void retirarDinero(double cantidad, String cuenta) {
		if(cuenta.equals("ahorros")) {
			//500
			//saldoCuentaAhorros = 600
			if(cantidad <= this.saldoCuentaAhorros) {
				this.saldoCuentaAhorros -= cantidad;
				BankAccount.totalDinero -= cantidad;
			} else {
				System.out.println("Fondos insuficientes en la cuenta de ahorro");
			}
			
		}else {
			if(cantidad <= this.saldoCuentaCorriente) {
				this.saldoCuentaCorriente -= cantidad;
				BankAccount.totalDinero -= cantidad;
			} else {
				System.out.println("Fondos insuficientes en la cuenta corriente");
			}
		}
	}
	
	public void verMiDinero() {
		System.out.println("Dinero de Cuenta ahorro:"+this.saldoCuentaAhorros);
		System.out.println("Dinero de Cuenta Corriente:"+this.saldoCuentaCorriente);
		System.out.println("Total:"+(this.saldoCuentaAhorros+this.saldoCuentaCorriente));
	}
	
}
