import java.util.Scanner;
/**********************************************************
 * Assignment 1
 * 
 * Purpose: This is a child class of Resource. It is the magazone class
 * 			and holds the edition field 
 * Author: Andy Ta
 * Student Number: 40827788
 * Date: Oct 4th, 2018
 * Professor: Linda Crane 
 * Course: 18F_CST8130
 * 
 * Data Members: All inherited fields from Resource
 * 				 edition:MyDate - stores the date edition 
 * Methods: Default constructor - hard code over due cost to 1.00f
 * 			inputResource():boolean - takes in a scanner and a date as
 * 			an argument.Assigns edition by calling constructor of MyDate.
 * 			toString():String - formats fields so when object is printed, fields 
 * 			are properly formatted
 * 				
 *
 **********************************************************/

public class Magazine extends Resource {
	private MyDate edition;
	// due date is 7 days
	//assigns overdueCost when object is created 
	public Magazine() {
		overdueCost = 1.00f; 
	}
	
	//Assigns field 
	public boolean inputResource(Scanner in, MyDate date) {
		super.inputResource(in, date);
		edition = new MyDate();
		System.out.println("Enter edition");
		edition.inputDate(in);
		//finds dueDate by calling add method of MyDate class
		this.dueDate = date.add(date,7);
		return true;
	}
	//formats printing statement of object 
	public String toString() {

		return "Magazine"+super.toString() + "\nEdition is " + edition.toString() + "\nDue date is " +
		this.dueDate+"\nIf late, fee is "+overdueCost;

	}

}
