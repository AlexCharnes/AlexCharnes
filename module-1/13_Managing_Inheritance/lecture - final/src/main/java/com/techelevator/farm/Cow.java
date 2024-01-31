package com.techelevator.farm;

public class Cow extends FarmAnimal {

	public Cow() {
		super("Cow", "moo!", 3000);
	}

	@Override
	public void move() {
		System.out.println("The cow walks");
	}
}