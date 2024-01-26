package com.techelevator;

public class Elevator {

    /*
    These are the instance variable
     */
    private int currentFloor;
    private int numberOfFloors;
    private boolean doorOpen = false;

    public Elevator(int numberOfLevels) {
        this.currentFloor = 1;
        this.numberOfFloors = numberOfLevels;
    }

    public void openDoor(){
        this.doorOpen = true;
    }
    public void closeDoor(){
        this.doorOpen = false;
    }
    public void goUp(int desiredFloor){
        if (!this.doorOpen && desiredFloor <= numberOfFloors && desiredFloor > currentFloor){
            this.currentFloor = desiredFloor;
        }
    }
    public void goDown(int desiredFloor){
        if (!this.doorOpen && desiredFloor < currentFloor && desiredFloor > 0){
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
