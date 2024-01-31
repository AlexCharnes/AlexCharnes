package com.techelevator.farm;

/*
	An abstract class cannot be instantiated but can be used be used as a superclass
	All non-private methods and properties are inherited by its subclasses
	It can force subclasses to Override an abstract method (like an interface)
 */
public abstract class FarmAnimal implements Singable, Sellable {
	private String name;
	private String sound;
	private int price;

	private boolean sleeping = false;

	public FarmAnimal(String name, String sound, int price) {
		this.name = name;
		this.sound = sound;
		this.price = price;
	}

	/*
		An Abstract method is just a method signature with the abstract keyword.  The subclass must Override this method
		and provide implementation
	 */
	public abstract void move();

	public void sleep() {
		this.sleeping = true;
	}

	public void wake() {
		this.sleeping = false;
	}
	public String getName() {
		return name;
	}

	/*
		The final keyword makes it so this method
		cannot be Overriden
	 */
	public final String getSound() {
		if (sleeping) {
			return "Zzzzzzzzzzz...";
		}
		return sound;
	}

	public int getPrice() {
		return price;
	}

	public boolean isSleeping() {
		return sleeping;
	}

}