package com.codingdojo.cynthia;

public class Gorilla extends Mammal {
	
	public void throwSomething() {
		System.out.println("U-U-U el gorila te lanzó algo");
		energyLevel -= 5;
	}
	
	public void eatBananas() {
		System.out.println("YUM YUM Gorila come banana");
		energyLevel += 10;
	}
	
	public void climb() {
		System.out.println("Uha uha! Gorila sube al arbol. Se siente el rey del mundo");
		energyLevel -= 10;
	}
	
}