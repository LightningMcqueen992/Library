import java.util.Scanner;

/********************************************************
 * Assignment 1
 * 
 * Purpose : This is a parent class.Different types of resources use this class
 * for a base.
 * 
 * Author: Andy Ta 
 * Student Number: 40827788
 * Date: Oct 4th, 2018
 * Professor: Linda Crane 
 * Course: 18F_CST8130
 * 
 * Data Members: title:String - stores the name of the resource borrower:String
 * - stores the name of the borrower dueDate:MyDate - stores the due date of the
 * resource overdueCost:float - stores the cost of the over due fee Methods:
 * Default Constructor - blank inputResource():boolean - takes in a scanner and
 * MyDate object. Assigns title and borrower name isOverDue():boolean - calls
 * MyDate is greater method, if true that means that the date is over due
 * toString():String -formats fields so when object is printed, fields are
 * properly formatted
 *
 *********************************************************/

public class Resource {

	protected String title;
	protected String borrower;
	protected MyDate dueDate;
	protected float overdueCost;

	public Resource() {

	}
	//Assigns field 
	public boolean inputResource(Scanner in, MyDate date) {
		
		System.out.println("Enter title being borrowed (No spaces)");
		title = in.next();

		System.out.println("Enter borrower name (No spaces)");
		borrower = in.next();

		return true;
	}
	//Calls date methods isOverDue , if true indicates item is overdue
	public boolean isOverDue(MyDate date) {
		//If true return true
		if (date.isGreaterThan(dueDate)) {

			return true;
		}

		return false;
	}
	//formats printing statement of object 
	public String toString() {
		return "\nTitle is " + title + "\nBorrower is " + borrower;
	}

}
