package com.techelevator.vehicles;

public class Bus {

    private final static int TOTAL_NUMBER_OF_SEATS = 40;

    /*
        Member / Instance Variables - create State
     */
    private String routeName;
    private int passengers;
    private int gallonsOfGas = 50;
    private boolean isDoorOpen = false;



    /*
        Constructor is a special method that instantiates the class into an object.  It is
        always named the same as the class and never has a return type.

        If no constructor is explicitly added to the class then Java will provide the
        no argument constructor (a constructor with no parameters) for "free"

        If an Overloaded is present in the class then Java no longer adds the
        no-argument constructor for "free" so if it is wanted it must be explicitly added.
     */
    public Bus() {

    }

    /*
    Constructors can have Overloads just like other methods.
     */
    public Bus(String routeName) {
        this.routeName = formatRouteName(routeName);
    }



    /*
        Getters and Setters give public access to see or change the private
        member variables
     */
    // Getter
    public String getRouteName() {
        return this.routeName;
    }

   // Setter
    public void setRouteName(String routeName) {
        this.routeName = formatRouteName(routeName);
    }

    public int getPassengers() {
        return this.passengers;
    }

    public int getGallonsOfGas() {
        return this.gallonsOfGas;
    }

    public boolean isDoorOpen() {
        return this.isDoorOpen;
    }

    /*
        Encapsulated Setters - provide an easier and more intuitive way to set a value,
        for instance openDoor() instead of setIsDoorOpen(true)
     */
    public void openDoor() {
        this.isDoorOpen = true;
    }

    public void closeDoor() {
        this.isDoorOpen = false;
    }

    /*
        Derived Property
        NEVER has a member variable, but calculates a result from the other member variables
        and returns it.  By not storing the result and always calculating it, it will always
        be correct and up-to-date.
     */
    public int getRemainingSeats() {
        return TOTAL_NUMBER_OF_SEATS - this.passengers;
    }

    /*
        Methods - create Behavior
     */
    public int addGas(int gallonsToAdd) {
        if (this.gallonsOfGas + gallonsToAdd >= 100) {
            this.gallonsOfGas = 100;
        } else {
            this.gallonsOfGas += gallonsToAdd;
        }
        return this.gallonsOfGas;
    }

    public boolean board() {
        if (this.isDoorOpen && getRemainingSeats() >= 1) {
            this.passengers += 1;
            return true;
        }
        return false;
    }

    /*
        A method Overload is a method with the same name and a different number of arguments or
        arguments with different data types.  Overloading is used to create methods that do
        the same thing, but take different parameters.
     */
    public boolean board(int numberOfBoardingPassengers) {
        if (this.isDoorOpen && getRemainingSeats() >= numberOfBoardingPassengers) {
            this.passengers += numberOfBoardingPassengers;
            return true;
        }
        return false;
    }

    /*
        Private methods are "workers" that can only be used in this class.
     */
    private String formatRouteName(String routeName) {
        String name = routeName.replaceAll(" ", "-");
        return name.toUpperCase();
    }

}
