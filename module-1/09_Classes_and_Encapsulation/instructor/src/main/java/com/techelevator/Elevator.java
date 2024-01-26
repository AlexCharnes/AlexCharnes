package com.techelevator;

public class Elevator {

    /*
        Instance variables
     */
    private int currentFloor;
    private int numberOfFloors;
    private boolean doorOpen;


    public Elevator(int numberOfLevels) {
        this.currentFloor = 1;
        this.numberOfFloors = numberOfLevels;
    }

    public void openDoor() {
        this.doorOpen = true;
    }
    public void closeDoor(){
        this.doorOpen = false;
    }
    public void goUp(int desiredFloor){
        // Set current floor to desired floor
        // Given:
        // 1) the door is closed
        // 2) can't be less than or equal numberOfFloors
        // 3) must be greater current floor
        if (!this.doorOpen && desiredFloor <= numberOfFloors && desiredFloor > currentFloor){
            this.currentFloor = desiredFloor;
        }

    }
    public void goDown(int desiredFloor){
        // Set current floor to the desired floor, Given
        // 1) the door is closed
        // 2) desired floor < current floor
        // 3) desired floor > 0
        if (!this.doorOpen && desiredFloor < currentFloor && desiredFloor > 0) {
            this.currentFloor = desiredFloor;
        }
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public boolean isDoorOpen() {
        return doorOpen;
    }
}
