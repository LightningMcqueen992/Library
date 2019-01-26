
import java.util.Scanner;
/***********************************************************
 * Assignment 1
 * 
 * Purpose: This class is used to handle dates
 * 
 * Author: Andy Ta
 * Student Number: 40827788
 * Date: Oct 4th, 2018
 * Professor: Linda Crane 
 * Course: 18F_CST8130
 * 
 *  Data Members: year:int - used to store year
 *				  month:int - used to store month
 *				  day:int - used to store day
 *
 * Methods: default constructor
 * 			argument constructor
 * 			add:MyDate - takes in current date, adds extra dates to current date
 * 			and returns a new date for dueDate
 * 			inputDate:boolean - used to assign year, month and day 
 * 			isEqual:boolean - used to check if dates are equal
 * 			isGreaterThan:boolean - used to check if current date is greater than 
 * 			due date. Also checks if date was equal first
 * 			toString():String - formats fields so when object is printed, fields 
 * 			are properly formatted
 * 
 *
 ***************************************************************/

public class MyDate {

	private int year;
	private int month;
	private int day;

	//Default constructor to create a temporary MyDate object
	public MyDate() {

	}
	
	
	
	//Argument constructor to create any date 
	public MyDate(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}

	
	
	
	//Method used to initialize fields
	public MyDate add(MyDate date,int addDay) {
		//stores the type of month 
		int typeMonth;
		
		if(this.month==4 || this.month==6 || this.month==9 || this.month == 11) {
			//therefore type month has thirty days
			typeMonth=30;
		}
		else {
			//therefore type month has 31 days
			typeMonth=31;
		}
		//Creates a new date object
		MyDate newDate = new MyDate();
		//Checks to see if adding days will enter a different month 
		if(this.day+addDay > typeMonth) {
			//If month is december will set to new year 
			if(this.month == 12) {
				newDate.year = date.year+1;
				newDate.month = 1;
				newDate.day = addDay + date.day - typeMonth;
				return newDate;
			}
			//adds one month to current month 
			newDate.month= date.month + 1;
			//adds days 
			newDate.day = addDay + date.day - typeMonth;
			//sets year 
			newDate.year = date.year;
			return newDate;
		}
		//will normally increase day count 
		else {
			
			newDate.month = date.month;
			newDate.year = date.year;
			newDate.day = date.day+addDay;
		}
		//returns newDate which will be a dueDate
		return newDate ;
		
	}
	//Method used to assign field 
	public boolean inputDate(Scanner in) {
		
		do {

			System.out.print("Enter month - between 1 and 12: ");
			if (in.hasNextInt())
				this.month = in.nextInt();
			else {
				System.out.println("Invalid month input");
				in.next();
			}
		} while (this.month <= 0 || this.month > 12);
		
		do {

			System.out.print("Enter day - between 1 and 31: ");
			if (in.hasNextInt())
				this.day = in.nextInt();
			else {
				System.out.println("Invalid day input");
				in.next();
			}
		} while (this.day <= 0 || this.day > 31 || (this.month == 2 && this.day > 29)
				|| (this.day > 30 && (this.month == 9 || this.month == 4 || this.month == 6 || this.month == 11)));
		
		do {
			System.out.print("Enter year: ");
			if (in.hasNextInt())
				this.year = in.nextInt();
			else {
				System.out.println("Invalid day input");
				in.next();
			}
		} while (this.year <= 0);

		return true;
		
	}
	
	
	
	//Note please read , project will recognize that if dates are equal , it is not overDue.
	//Only when current date is overdue , will it recognize as overdue
	public boolean isEqual(MyDate date) {
		//If dates are equal, it is not overdue yet
		if(this.year == date.year && this.month == date.month && this.day==date.day) {
			return true;
		}
		return false;
	}

	
	//Checks to see if dates are greater than one another
	//If true that means it is greater
	public boolean isGreaterThan(MyDate dueDate) {
		//checks to see if dates are equal first 
		if(isEqual(dueDate)) {
			return false;
		}
		//secondly check year 
		if(this.year > dueDate.year) {
			return true;
		}
		//thirdly check month 
		if(this.month > dueDate.month) {
			if(this.year < dueDate.year) {
				return false;
			}
			return true;
			
		}
		//fourthly compares days 
		if(this.day > dueDate.day) {
			
			if(this.month<dueDate.month ) {
				return false;
			}
			else {
				return true;
			}
		}
		//default is return false
		return false;
	}

	
	
	
	//formats printing statement of object
	public String toString() {

		return "\nMonth: "+month+" Date: "+day+" Year: "+year;
	}

}
