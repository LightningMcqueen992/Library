
import java.util.Scanner;
/*****************************************************************************************************
 * Assignment 1
 * 
 * Purpose: This class holds the main function. The main function is in charge of menu processing
 * Objects of Date and Library are created in the main.
 * Author: Andy Ta
 * Student Number: 40827788
 * Date: Oct 4th, 2018
 * Professor: Linda Crane 
 * Course: 18F_CST8130
 * 
 * Data Members:none  
 * Methods: main
 * 
 *
 *****************************************************************************************************/

public class Assign1 {

	public static void main(String[] args) {

		int in = 0;
		Scanner input = new Scanner(System.in);
		Library beaverBrook = new Library();
		MyDate date = null;

		/*
		 * Note Please read , this project needs the user to set up a date before other
		 * options are chosen. Attempting to add resources without date setup , will
		 * prompt user to enter 5 to change date.
		 * 
		 * 
		 */

		do {

			System.out.println("\nEnter:");
			System.out.println("1 to add resources");
			System.out.println("2 to display overdue items");
			System.out.println("3 to display all resources");
			System.out.println("4 to delete a resource");
			System.out.println("5 to change todays date");
			System.out.println("6 to display current date");
			System.out.println("7 to quit");
			//Tests if input is not a number
			if (!input.hasNextInt()) {
				System.out.println("Invalid input");
				in = -1;
				input.next();
				continue;
			} else {
				in = input.nextInt();
				//checks to see if input is a valid number
				if (in > 7 || in <= 0) {
					System.out.println("Invalid input too high");
					in = -1;
				}
				
				//Switch cases is used to decide 
				switch (in) {

				case 1:

					if (date == null) {
						System.out.println("Date has not been setup, please proceed with option 5");
						break;
					}

					beaverBrook.inputResource(input, date);
					break;

				case 2:

					System.out.println(beaverBrook.resourcesOverDue(date));
					break;

				case 3:
					System.out.println("Items currently borrowed from library :");
					beaverBrook.printResources();
					;
					break;

				case 4:
					System.out.println("You have selected to delete a resource");

					if (date == null) {
						System.out.println("Date has not been setup");
						break;
					}

					beaverBrook.deleteResource(input, date);
					break;

				case 5:
					date = new MyDate();
					if (date.inputDate(input)) {
						System.out.println("Date has been successfully updated");

					}

					break;
				case 6:
					if (date == null) {
						System.out.println("No date setup");
						break;
					} else {
						System.out.println("\nCurrent date: " + date);
					}
					break;

				case 7:
					System.out.println("GoodBye");
					break;
					
				}

			}

		} while (!(in == 7));
		input.close();

	}

}
