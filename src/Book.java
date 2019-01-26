
import java.util.Scanner;
/*********************************************************************************
 * Assignment 1
 * 
 * Purpose: This is a child class of resource. It is the book class 
 * 			and holds the author field
 * Author: Andy Ta
 * Student Number: 40827788
 * Date: Oct 4th, 2018
 * Professor: Linda Crane 
 * Course: 18F_CST8130
 * 
 * Data Members: All inherited fields from Resource
 * 				 author:String - stores author of book
 * Methods: Default Constructor - hard code initializes over due cost to 2.00f
 * 			inputResource():boolean - takes in a scanner and a date as an argument
 * 			Assigns author name and also creates a due date by calling add method
 * 			toString():String - formats fields so when object is printed, fields 
 * 			are properly formatted
 *
 *********************************************************************************/
public class Book extends Resource {

	private String author;
	// due date is 14 days from todays date
	
	//assigns overdueCost when object is created 
	public Book() {
		overdueCost = 2.00f;
	}
	// method used to assign author name 
	public boolean inputResource(Scanner in, MyDate date) {
		super.inputResource(in, date);
		
		System.out.println("Enter author name (No spaces)");
		author = in.next();
		//finds dueDate by calling add method of MyDate class
		this.dueDate = date.add(date, 14);

		return true;
	}
	//formats printing statement of object 
	public String toString() {

		return "Book" + super.toString() + "\nAuthor is " + author + "\nDue date is " + this.dueDate
				+ "\nIf late, fee is " + overdueCost;

	}

}
