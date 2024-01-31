package com.techelevator.farm;

public class OldMacdonald {
	public static void main(String[] args) {


		FarmAnimal[] farmAnimals = new FarmAnimal[] {
				new Cow(), new Chicken(),
				new Pig(), new Sheep()
		};

		System.out.println("Animals on the farm...");
		for (FarmAnimal animal : farmAnimals) {
			System.out.println(animal.getName());
		}

		System.out.println();
		System.out.println();

		Singable[] singers = new Singable[] { new Cow(), new Chicken(),
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