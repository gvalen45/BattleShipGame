/***********************************************************************
  Jose Gabriel Valenzuela CSC110AB 31269, May 2nd 2019 Module 7 Arrays
 
 This class hold the main method where the program is run. This class
 creates a 1 sides battleship game where the user must try to guess 
 the locations of the randomly placed ships on a 10 by 10 map. The aim of
 game is to destroy all the ships. This is created by using a 2-D array
 created in the Sea class and a ship generated created in thr Ship class.
 
 
 ***********************************************************************/

import java.util.Random;
import java.util.Scanner;

public class ShipSinkingGame {

	//creates random object
   public static Random generator = new Random();
	//constant
   final static int MAX_SHIPS = 8;

	public static void main(String[] args) {


      //constant
		final int MAX_MISSES = 12;
      //declares variables that user will set 
      int userRow;
		int userColumn;
		char userCheatMode;
      int misses = 0;
      
      //creates scanner
		Scanner keyboard = new Scanner(System.in);

		// creates sea object
      Sea s = new Sea();
      
      //calls method to create fleet
		createFleet(s);
      
      //makes a grid that will be used to display the Sea to the user
		String seaGrid[][] = new String[10][10];
      
      //Welcome message
		System.out.println("Welcome to the Ship Sinking Game ");
		System.out.println();
		System.out.print("Do you want play mode? (N = cheat mode): ");

		userCheatMode = keyboard.next().toUpperCase().charAt(0);
      
      
      //if and else determines if the user will be in PLAY mode or CHEAT mode
		if (userCheatMode == 'Y') {
         
         System.out.println("OK We're in PLAY mode. Enjoy...");
			System.out.println();
         
         for (int i = 0; i < 10; i++) {

				for (int j = 0; j < 10; j++) {

					seaGrid[i][j] = ".";

				}
			}

			   //While loop ends the game once 12 misses have been accumalated
            while(misses < MAX_MISSES){
            //Creates a grid that displays to the user
				createSeaGrid(seaGrid);

				System.out.print("Enter a coordinate(0..9) for target: ");

			    userRow = keyboard.nextInt();
			      
               //while loop forces the user to enter a coordinate(0..9)
               while (userRow < 0 || userRow > 9) {

				   System.out.print("Again: Enter a coordinate(0..9) for target: ");

				   userRow = keyboard.nextInt();

				   System.out.println();
			}
			System.out.println();
         
         
         System.out.print("Enter a coordinate(0..9) for target: ");

			userColumn = keyboard.nextInt();
         
         //while loop forces the user to enter a coordinate(0..9)

         while (userColumn < 0 || userColumn > 9) {

				System.out.print("Again: Enter a coordinate(0..9) for target: ");

				userColumn = keyboard.nextInt();

				System.out.println();
			}
			System.out.println();

				// creates a copy of the sea class that can be used to compare the cells
            Ship temp = s.getShip(userRow, userColumn);

				//checks if the cell at userRow & userColumn is not null if it is
            // not null then it is a hit
				if (temp != null) {

					seaGrid[userRow][userColumn] = "*";
               System.out.println("       Good shot! A ship was hit.");
				//else if checks if the cell at userRow & userColumn is null
            // if it is then it is a miss
            } else if (temp == null) {

					seaGrid[userRow][userColumn] = "X";

				   System.out.println("       No ships were hit.");
               misses++;
           
            }


			}
        for (int i = 0; i < 10; i++) {

				for (int j = 0; j < 10; j++) {
				   // creates a copy of the sea class that can be used to compare the cells
               Ship temp = s.getShip(i, j);
					//if statements checks if a object is in that class and displays its ID letter
               if (temp != null && seaGrid[i][j] != "." && seaGrid[i][j] != "X" && seaGrid[i][j] != "*") {

						seaGrid[i][j] = s.check(temp);
               // else there is no object in  the cell and displays a dot '.'
					} else {

						seaGrid[i][j] = ".";

					}
				}
         
			}

		} else {

         //for loop creates the CHEAT mode sea grid
			for (int i = 0; i < 10; i++) {

				for (int j = 0; j < 10; j++) {
				   // creates a copy of the sea class that can be used to compare the cells
               Ship temp = s.getShip(i, j);
					//if statements checks if a object is in that class and displays its ID letter
               if (temp != null && seaGrid[i][j] != "." && seaGrid[i][j] != "X" && seaGrid[i][j] != "*") {

						seaGrid[i][j] = s.check(temp);
               // else there is no object in  the cell and displays a dot '.'
					} else {

						seaGrid[i][j] = ".";

					}
				}

			}


	
         //While loop ends the game once 12 misses have been accumalated
         while(misses < MAX_MISSES){
			createSeaGrid(seaGrid);

			System.out.print("Enter a coordinate(0..9) for target: ");

			userRow = keyboard.nextInt();
			// forces the user to enter a coordinate between 0-9
         while (userRow < 0 || userRow > 9) {

				System.out.print("Again: Enter a coordinate(0..9) for target: ");

				userRow = keyboard.nextInt();

				System.out.println();
			}
			System.out.println();
         
         
         System.out.print("Enter a coordinate(0..9) for target: ");

			userColumn = keyboard.nextInt();
			
         // forces the user to enter a coordinate between 0-9
         while (userColumn < 0 || userColumn > 9) {

				System.out.print("Again: Enter a coordinate(0..9) for target: ");

				userColumn = keyboard.nextInt();

				System.out.println();
			}
			System.out.println();



			// creates a copy of the sea class that can be used to compare the cells
			Ship temp = s.getShip(userRow, userColumn);

         //checks if the cell at userRow & userColumn is not null if it is
         // not null then it is a hit
			if (temp != null) {

					seaGrid[userRow][userColumn] = "*";
               System.out.println("       Good shot! A ship was hit.");
				
            //else if checks if the cell at userRow & userColumn is null
            // if it is then it is a miss
            } else if (temp == null) {

					seaGrid[userRow][userColumn] = "X";

				   System.out.println("       No ships were hit.");
               misses++;
           
            }


		}

	  }
   
   /*
   There is no way to win the game. Everything worked fine until I created 
   several ships and couldnt figure out a way to keep track of the total
   number of ships destoryed.
  
   */
   
   //Displays loser message
   System.out.print("Sorry, you have accumulated 12 misses : You lost!");
   }
	
   //method that creates a 2-D grid that will be used to display to the user
   public static void createSeaGrid(String display[][]) {

		System.out.println("===========================================================");
		System.out.println();
		System.out.println("  0 1 2 3 4 5 6 7 8 9");
		for (int i = 0; i < 10; i++) {
			System.out.print(i + " ");

			for (int j = 0; j < 10; j++) {

				System.out.print(display[i][j] + " ");

			}
			System.out.println();

		}
	}
   /*
   Creating the fleet is another problem I ran into. The fleet orignally was turning
   out fine until it randomly stoped creating 8 instances and now only creates either 
   4 or 6 or less ships 
   
   */
   
   
   //Method that creates the fleet of ships
	public static void createFleet(Sea s) {
      //for loop repeats until 8 ships are created
		for (int d = 0; d < MAX_SHIPS; d++) {
			// creates a random row,column, ship size and veritcal or horizontal orientation that 
         //are passed to shipWouldNotFit() to create the ship objects
         int r = generator.nextInt(10);
			int c = generator.nextInt(10);
			int size = generator.nextInt(10) + 1;
			boolean orientation = generator.nextBoolean();
         
         //while loops keeps generating random row,column, ship size and veritcal or horizontal orientation
         // until shipWouldNotFit returns true
			while (s.shipWouldNotFit(r, c, orientation, size) == false) {
				r = generator.nextInt(10);
				c = generator.nextInt(10);
				size = generator.nextInt(10) + 1;
				orientation = generator.nextBoolean();

			}
			//once it returns true it creates the ship object and places it on the Sea map
         Ship makeShips = new Ship(r, c, orientation, size);
			s.placeShip(makeShips);

		}

	}

}
