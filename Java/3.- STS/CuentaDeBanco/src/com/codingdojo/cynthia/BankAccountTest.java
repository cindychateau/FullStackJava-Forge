package com.codingdojo.cynthia;

public class BankAccountTest {

	public static void main(String[] args) {
		
		BankAccount cuentaMiu = new BankAccount();
		
		cuentaMiu.depositarDinero(100, "ahorros");
		
		cuentaMiu.verMiDinero();

	}

}