package com.techelevator.farm;

public class OldMacdonald {
	public static void main(String[] args) {

		Pig pig = new Pig();
		pig.rollInMud(); // from Pig
		pig.getName(); // from FarmAnimal, Singable, Sellable
		pig.getSound(); // from FarmAnimal, Singable
		pig.getPrice(); // from FarmAnimal, Sellable

		FarmAnimal pigAsFarmAnimal = pig;
		pigAsFarmAnimal.getName(); // from FarmAnimal, Singable, Sellable
		pigAsFarmAnimal.getSound(); // from FarmAnimal, Singable
		pigAsFarmAnimal.getPrice(); // from FarmAnimal, Sellable
		// When cast as a FarmAnimal the pig can't rollInMud()

		Singable pigAsSingable = pig;
		pigAsSingable.getName(); // Singable
		pigAsSingable.getSound(); // Singable
		// When cast as Singable the pig can't rollInMud() or getPrice()

		Sellable pigAsSellable = pig;
		pigAsSellable.getName(); // Sellable
		pigAsSellable.getPrice(); // Sellable
		// When cast as Sellable the pig can't rollInMud() or getSound()

		/*
		Dowcasting
		 */
		Object cowAsObject = new Cow();
		Sellable cowAsSellable = (Sellable) cowAsObject;
		Singable cowAsSingable = (Singable) cowAsSellable;
		FarmAnimal cowAsFarmAnimal = (FarmAnimal) cowAsSingable;
		Cow cowAsCow = (Cow) cowAsFarmAnimal;

		/*
		This code will cause a ClassCastException because Egg does not implement
		Singable, so it can not be case to Singable.
		 */
//		Sellable eggAsSellable = new Egg();
//		Singable eggAsSingable = (Singable) eggAsSellable;

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

		//  How could we add the Pig?
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