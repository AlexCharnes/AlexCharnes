package com.techelevator.farm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OldMacdonald {

	public static void main(String[] args) {
		
		String harvestDate = Farm.calculateHarvestDate(5, 15, 75);
		System.out.println(harvestDate);


		FarmAnimal pigAsFarmAnimal = new Pig();

		if (pigAsFarmAnimal instanceof Singable) {
			System.out.println("The Pig is an instance of Singable");
		}
		if (pigAsFarmAnimal instanceof Pig) {
			System.out.println("The FarmAnimal is a Pig");
		}

		Object pigAsObject = new Pig();
		boolean isThePigAString = pigAsObject instanceof String;
		System.out.println("The Pig is a String? " + isThePigAString);

		/*
			FarmAnimal is an Abstract Class so it cannot be instantiated
		 */
//		FarmAnimal unicorn = new FarmAnimal("Unicorn", "Hello its a unicorn", 1000);
//		FarmAnimal genericFarmAnimal = new FarmAnimal("","",0);

		FarmAnimal[] farmAnimals = new FarmAnimal[] {
				new Cow(), new Chicken(),
				new Pig(), new Sheep()
		};

		System.out.println("Animals on the farm...");
		for (FarmAnimal animal : farmAnimals) {
			System.out.println(animal.getName());
			animal.move();
		}

		System.out.println();
		System.out.println();

		Cow singingCow = new Cow();
		singingCow.sleep();

		Chicken singingChicken = new Chicken();
		singingChicken.wake();

		FarmCat cat = new FarmCat();
		cat.wake();

//		TabbyCat tabbyCat = new TabbyCat();
//		cat.wake();

		Singable[] singers = new Singable[] { cat, singingCow, singingChicken,
				new Pig(), new Sheep(), new Tractor(), new MusicBox() };

		for (Singable singer : singers) {
			String name = singer.getName();
			String sound = singer.getSound();
			System.out.println("Old MacDonald had a farm, ee, ay, ee, ay, oh!");
			System.out.println("And on his farm he had a " + name + ", ee, ay, ee, ay, oh!");
			System.out.println("With a " + sound + " " + sound + " here");
			System.out.println("And a " + sound + " " + sound + " there");
			System.out.println("Here a " + sound + " there a " + sound + " everywhere a " + sound + " " + sound);
			System.out.println();
		}

		System.out.println();
		System.out.println();

		Sellable[] thingsForSale = new Sellable[] { new Cow(), new Chicken(),
				new Pig(), new Sheep(), new Egg(), new MusicBox() };

		System.out.println("For Sale:");
		for (Sellable itemForSale : thingsForSale) {
			System.out.print(itemForSale.getName());
			System.out.print("  $");
			System.out.println(itemForSale.getPrice());
		}
	}
}