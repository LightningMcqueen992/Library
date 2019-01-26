import java.util.Scanner;
/*************************************************************
 * Assignment 1
 * 
 * Purpose: This is a child class of resource. It is the DVD class and holds
 * 			the type field
 * Author: Andy Ta
 * Student Number: 40827788
 * Date: Oct 4th, 2018
 * Professor: Linda Crane 
 * Course: 18F_CST8130
 * 
 * Data Members: All inherited fields from Resource
 * 				 type:String - stores the type of DVD
 * Methods: Default constructor- hard codes overdueCost to 1.00
 * 			inputResource():boolean - takes in a scanner and date object,assigns
 * 			type of dvd to object
 * 			toString():String - formats fields so when object is printed, fields 
 * 			are properly formatted
 * 
 *
 *************************************************************/
public class DVD extends Resource {
	private String type;
	// due date is 3 days from todays date
	//assigns overdueCost when object is created 
	public DVD() {
		overdueCost = 1.00f;
	}
	
	//Assigns field 
	public boolean inputResource(Scanner in, MyDate date) {
		super.inputResource(in, date);
		// handle exception handling here
		System.out.println("Enter the type of DVD (No spaces)");
		type = in.next();
		//finds dueDate by calling add method of MyDate class
		this.dueDate = date.add(date, 3);

		return true;
	}
	//formats printing statement of object 
	public String toString() {

		return "DVD" + super.toString() + "\nType is " + type + "\nDue date is " + this.dueDate + "\nIf late, fee is "
				+ overdueCost;
	}

}
