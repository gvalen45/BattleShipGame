/***********************************************************************
 * Jose Gabriel Valenzuela CSC110AB 31269, May 2nd 2019 Module 7 Arrays
 * 
 * This class creates a 2-D array that acts as the 'sea' for the ShipSinkingGame
 * class. It also includes methods that check if the Ship object can be placed
 * on the sea without passing the arrays boundaries or landing ontop of a
 * existing ship.
 * 
 ***********************************************************************/

public class Sea {

	private Ship sea[][];

	// Displays the 2-D sea using for loops that print the row follwed by each
	// column
	public void displaySea() {

		System.out.println("===========================================================");
		System.out.println();
		System.out.println("  0 1 2 3 4 5 6 7 8 9");
		// row for loop
		for (int i = 0; i < sea.length; i++) {
			System.out.print(i + " ");
			// column for loop
			for (int j = 0; j < sea[i].length; j++) {
				System.out.print(sea[i][j] + " ");

			}
			System.out.println();
		}

	}

	// Constructor creates the sea 2-D array
	public Sea() {

		sea = new Ship[10][10];

	}

	// method that checks if the ship will fit
	public boolean shipWouldNotFit(int row, int col, boolean horizontalOrVertical, int size) {

		boolean willFit = true;

		// if statement checks if a vertica ship will fit on on the Sea Map
		if (horizontalOrVertical == false) {

			// adds the row and size of the ship to see if it passes the array boundaries
			if ((row + size) - 1 > 9) {
				willFit = false;
			} else {

				for (int index = 0; index < size; index++) {

					// Checks if it is landing ontop of a existing ship
					if (sea[row + index][col] != null) {

						willFit = false;
					}
				}
			}
			// else if checks if a horizontal ship will fit on on the Sea Map
		} else if (horizontalOrVertical == true) {
			// adds the column and size of the ship to see if it passes the array boundaries
			if ((col + size) - 1 > 9) {
				willFit = false;
			} else {
				for (int x = 0; x < size; x++) {

					// Checks if it is landing ontop of a existing ship
					if (sea[row][col + x] != null) {

						willFit = false;

					}

				}
			}

		}
		// returns a true or false if it will fit
		return willFit;
	}

	// This mehthod places the ships on the Sea map
	/*
	 * The program runs but sometimes will crash and points out this method
	 * placeShip most of the time it runs smoothly but something must be wrong here
	 * for it to crash only sometimes. Run several times and it will crash.
	 * 
	 */

	public void placeShip(Ship shipPlacer) {
		// if getOrientation() returns true then it will place a horizontal ship
		if (shipPlacer.getOrientation() == true) {

			for (int i = 0; i < shipPlacer.getSize(); i++) {

			}
			// if getOrientation() returns false then it will place a vertical ship
		} else if (shipPlacer.getOrientation() == false) {

			for (int j = 0; j < shipPlacer.getSize(); j++) {
				sea[shipPlacer.getRow() + j][shipPlacer.getColumn()] = shipPlacer;

			}

		}
	}

	// method that grabs the letter ID
	public String check(Ship shipPlacer) {
		String printId = shipPlacer.toString();

		return printId;
	}

	// method returns a copy of the sea map
	public Ship getShip(int r, int c) {

		return sea[r][c];
	}

}