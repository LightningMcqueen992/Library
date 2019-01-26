
import java.util.Scanner;
/*************************************************************************
 * Assignment 1
 * 
 * Purpose: This class is in charge of storing the resources. This is done by having an 
 * array of the class Resource.
 * Author: Andy Ta
 * Student Number: 40827788
 * Date: Oct 4th, 2018
 * Professor: Linda Crane 
 * Course: 18F_CST8130
 * 
 * Data Members: resourcesBorrowed:Resource[] - stores an array of resource
 * 				 numResources:int - acts as a counter variable keeping track of 
 * 				 the amount of resources inside resourcesBorrowed
 * 				 max:int - hard coded value, that initializes resourcesBorrowed size
 * 
 * Methods: Default constructor-initializes array size based on max variable
 * 			Argument constructor-initializes array size based on int argument passed in 
 * 			inputResource():boolean - method that prompts the user which type of resource
 * 			is being borrowed.Resource object is created in the process.When object is created 
 * 			it is initialized through its own inputResource methods.
 * 			printResources():void - method that uses a for loop to print array
 * 			deleteResource():void - deletes resource by calling prompting user to enter index of 
 * 			resource.Uses for loops to remove index and re position elements.If resource is overdue
 * 			user is told with a print statement
 * 			resourcesOverDue():String - using a for loop, calling isOverDue method of objects, if
 * 			true, object is printed on screen.
 *
 *************************************************************************/

public class Library {

	private Resource[] resourcesBorrowed;
	private int numResources = 0;
	private int max = 10;

	// Default constructor initializes Resource array to value of max
	public Library() {
		resourcesBorrowed = new Resource[max];
		
	}

	// Argument constructor initializes Resource array to integer value passed in to
	// it
	public Library(int size) {
		resourcesBorrowed = new Resource[size];
	}

	public boolean inputResource(Scanner in, MyDate date) {
		// This if statement prevents the array from entering index out of bounds
		if (numResources >= max) {
			System.out.println("\nNote: Library size has increased\n");
			// max variable is multiplied by 4
			max = max * 4;
			// temporary array to hold elements that are currently saved in
			// resourcesBorrowed
			Resource[] temp = new Resource[max];

			// copies elements from resourcesBorrowed into temp
			System.arraycopy(resourcesBorrowed, 0, temp, 0, numResources);
			// original array is now reset to a high size
			resourcesBorrowed = new Resource[max];
			// re-copies temp array into new resourcesBorrowed
			System.arraycopy(temp, 0, resourcesBorrowed, 0, numResources);

		}
		//This section prompts user for input, will keep asking if input is not acceptable
		String type = " ";
		do {
			System.out.println("Enter the type of resource");
			System.out.println("D for DVD, M for Magazine, B for Book");
			if (in.hasNext()) {
				type = in.next();
			} else {
				in.next();
				type = " ";
				System.out.println("Invalid resource, try again");
			}
		} while (!type.equalsIgnoreCase("d") && !type.equalsIgnoreCase("m") && !type.equalsIgnoreCase("b"));
		//Convert string into a lower case char 
		char option = type.toLowerCase().charAt(0);
		//Temporary Resource object is created 
		Resource temp = new Resource();
		//Switch cases decide what type of child resource
		switch (option) {

		case 'd':
			temp = new DVD();
			break;

		case 'm':
			temp = new Magazine();
			break;

		case 'b':
			temp = new Book();
			break;

		}
		//if objects initialization method returns true, object is than added into the array
		if (temp.inputResource(in, date)) {
			resourcesBorrowed[numResources] = temp;
		}
		//increments counter variable by one 
		numResources++;

		return true;
	}
	//Method prints resources out 
	public void printResources() {
		//checks if array is filled 
		if (resourcesBorrowed[0] == null) {
			System.out.println("No resources borrowed");
			return;
		}
		//Prints all current objects in array
		for (int i = 0; i < numResources; i++) {
			
			System.out.println("\n" + (i + 1) + ":");
			System.out.println(resourcesBorrowed[i]);
		}

	}
	//Method is in charge of deleting a resource 
	public void deleteResource(Scanner in, MyDate date) {
		//Will return if nothing to delete
		if (resourcesBorrowed[0] == null) {
			System.out.println("Error there are no resources borrowed");
			return;
		}
		//prints current elements in array 
		printResources();
		//declares an int value to store index 
		int index;
		do {
			System.out.println("\nWhich resource would you like to remove please provide number");
			if (in.hasNextInt()) {
				index = in.nextInt();
				if (index == 0 || index <0) {
					index = numResources + 1;
				}
			}
			else {
				in.next();
				index = numResources + 1;
			}

			index--;
			//Will keep asking if index value is greater or equal to numResources
		} while (index >= numResources);
		//Checks if resource is over due, if true, user will be notified
		if (resourcesBorrowed[index].isOverDue(date)) {
			System.out.println("This resource is overDue, borrower owes :" + resourcesBorrowed[index].overdueCost);
		}
		// For loop : i is set to index, which is the element we are removing. Moves all elements behind
		// the index one index.
		for (int i = index; i < numResources - 1; i++) {
			resourcesBorrowed[i] = resourcesBorrowed[i + 1];
		}
		//Last element is copy but is now set to null
		resourcesBorrowed[numResources - 1] = null;

		// decreases logical size
		numResources--;
		System.out.println("Resource has been deleted");

	}
	//This method prints all resources that are currently overDue
	public String resourcesOverDue(MyDate today) {
		
		// for loop runs through array
		for (int i = 0; i < numResources; i++) {
			//if resourcesBorrowed at current index is overdue,it will print overdue
			if (resourcesBorrowed[i].isOverDue(today)) {
				/*
				return ("\nTHIS IS OVERDUE !\n" + resourcesBorrowed[i] + "\nFee is "
						+ resourcesBorrowed[i].overdueCost);
				*/
				System.out.println("\nTHIS IS OVERDUE !\n" + resourcesBorrowed[i] + "\nFee is "
						+ resourcesBorrowed[i].overdueCost);
			}

		}
		
		//If no resources are overdue, it will return no resources are 
		return "No resources overdue";
	}

}
