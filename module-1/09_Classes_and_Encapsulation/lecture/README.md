# Implement the `Bus` class

## Instance variables

| Attribute                            | Data Type | Get | Set | Description                                     |
| ------------------------------------ | --------- | --- | --- | ----------------------------------------------- |
| routeName                            | String    | X   |     | The route name of the bus.                      |
| passengers                           | int       | X   |     | The total number of passengers on the bus.      |
| gallonsOfGas                         | int       | X   |     | The number of gallons of gas the bus has.       |
| isDoorOpen                           | boolean   | X   |     | Determines if the door is open or closed.       |
| remainingSeats _(derived)_           | int       | X   |     | The number of available seats.                  |

**Notes**

- The bus should start with a default of 40 seats.
- `gallonsOfGas` should start with a default value of 50.
- `isDoorOpen` should start with a default value of false.
- `remainingSeats` is a derived value calculated by subtracting `passengers` from the total seats.
- The routeName should format the given route name to upper kebab case, example: HIGH-STREET

## Constructors

Create a constructor for this class that accepts no parameters.

Create a constructor for this class that accepts one parameter: `String routeName`. Use this parameters in this order to set the routeName property of the class. Make sure the routeName is properly formatted using upper kebab case.

## Methods

Create methods based on the following signatures:

```
    int addGas(int gallonsToAdd)
    void openDoor()
    void closeDoor()
    boolean board()
    boolean board(int numberOfBoardingPassengers)
```

**Notes**

- `addGas(int gallonsToAdd)` adds the given number of gallons to the amount of gas the bus has. The total number of gallons the bus has should not exceed 100. Returns the number of gallons the bus has after adding the gas.
- `openDoor()` opens the door of the bus.
- `closeDoor()` closes the door of the bus.
- `board` boards 1 additional passenger onto the bus. A passenger may only board if the door is open and there is at least 1 remaining seat.  Return true if the passenger was able to board the bus.
- `boolean board(int numberOfBoardingPassengers)` boards multiple passengers onto the bus.  The passengers may only board if the door is open and there are enough remaining seats on the bus.  Return true if the passengers where able to board.
