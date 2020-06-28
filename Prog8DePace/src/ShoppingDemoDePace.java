import java.io.*;
import java.text.*;
import java.util.*;

/**
 * Kyle DePace <br>
 * Prog 8 <br>
 * Due Date and Time: 04/09/2020 before 12:00 p.m. <br>
 * 
 * Purpose:  This program models a shopping cart<br>
 *
 * Input:  	The user may choose various options and load data from a file<br>
 * 
 * Output: 	Various outputs depending on the user's choice<br>
 * 			User can print the cart, the cost of the cart, etc <br>
 *
 * Certificate of Authenticity: I certify that this lab is entirely of my own
 * work. <br>
 * 
 * @author Kyle DePace <br>
 */
public class ShoppingDemoDePace {

	/**
	 * The keyboard reader
	 */
	static Scanner kb = new Scanner(System.in);
	
	/**
	 * The money formatter
	 */
	static DecimalFormat money = new DecimalFormat("$0.00");

	public static void main(String[] args) {
		KeyedListDePace cart = new KeyedListDePace();
		char choice = 'X';
		String userKey = "";
		int userQuantity = 0;
		double userPrice = 0;
		ItemDePace userItem = null;

		String fileName = "";
		File myFile = null;
		int numItems = 0;

		System.out.println("Welcome to your online shopping cart.\n");

		System.out.print("Enter a filename: ");
		fileName = kb.next();

		myFile = new File(fileName);

		try {
			Scanner input = new Scanner(myFile);

			numItems = input.nextInt();

			for (int i = 0; i < numItems; i++) {
				userKey = input.next();
				userQuantity = input.nextInt();
				userPrice = input.nextDouble();

				userItem = new ItemDePace(userKey, userQuantity, userPrice);
				cart.add(userItem);
			} // for i
			System.out.println("Items loaded from file successfully.");
			input.close();
		} // try
		catch (FileNotFoundException ex) {
			System.out.println("Failed to find file: " + myFile.getAbsolutePath());
		} // catch
		catch (InputMismatchException ex) {
			System.out.println("Type mismatch for the number I just tried to read.");
			System.out.println(ex.getMessage());
		} // catch
		catch (NumberFormatException ex) {
			System.out.println("Failed to convert String text into an integer value.");
			System.out.println(ex.getMessage());
		} // catch
		catch (NullPointerException ex) {
			System.out.println("Null pointer exception.");
			System.out.println(ex.getMessage());
		} // catch
		catch (Exception ex) {
			System.out.println("Something went wrong");
			ex.printStackTrace();
		} // catch
		System.out.println();

		do {
			printMenu();
			choice = kb.next().charAt(0);
			System.out.println();
			switch (choice) {
			case '1':
				System.out.println("Selected \"Add an item to the list\"");
				System.out.println();
				System.out.print("Enter the name of the item: ");
				userKey = kb.next();
				do {
					System.out.print("Enter the quantity of the item: ");
					userQuantity = kb.nextInt();
				} // do
				while (userQuantity <= 0);
				do {
					System.out.print("Enter the price of the item: ");
					userPrice = kb.nextDouble();
				} // do
				while (userPrice <= 0);
				System.out.println();
				if (cart.add(new ItemDePace(userKey, userQuantity, userPrice))) {
					System.out.println(userKey + " added to cart.");
				} // if
				else {
					System.out.println(userKey + " could not be added to cart.");
				} // else
				break;
			case '2':
				System.out.println("Selected \"Delete an item from the list\"");
				System.out.println();
				System.out.print("Enter the name of the item: ");
				userKey = kb.next();
				System.out.println();
				if (cart.remove(userKey)) {
					System.out.println(userKey + " removed from cart.");
				} // if
				else {
					System.out.println(userKey + " is not in the cart.");
				} // else
				break;
			case '3':
				System.out.println("Selected \"Print each item in the list\"");
				System.out.println();
				cart.print();
				break;
			case '4':
				System.out.println("Selected \"Search for a user-specified item in the list\"");
				System.out.println();
				System.out.print("Enter the name of the item: ");
				userKey = kb.next();
				System.out.println();
				userItem = cart.retrieve(userKey);
				if (userItem != null) {
					System.out.println("Item Found.");
					System.out.println(userItem.toString());
				} // if
				else {
					System.out.println(userKey + " is not in the cart.");
				} // else
				break;
			case '5':
				System.out.println("Selected \"Count the total number of items in the list\"");
				System.out.println();
				System.out.println("Number of Items: " + cart.getCount());
				break;
			case '6':
				System.out.println("Selected \"Total the cost of the items in the list\"");
				System.out.println();
				System.out.println("Total Cost: " + money.format(cart.calcTotal()));
				break;
			case '7':
				System.out.println("Selected \"Determine whether the list is empty\"");
				System.out.println();
				System.out.println(cart.isEmpty() ? "The cart is empty." : "The cart is not empty");
				break;
			case '8':
				System.out.println("Selected \"Determine whether the list is full\"");
				System.out.println();
				System.out.println(cart.isFull() ? "The cart is full." : "The cart is not full");
				break;
			case '9':
				System.out.println("Selected \"Clear the list\"");
				System.out.println();
				cart.clear();
				System.out.println("The cart has been cleared.");
				break;
			case '0':
				System.out.println("Goodbye!");
				break;
			default:
				System.out.println("Invalid Choice");
			} // switch
			System.out.println();
		} // do
		while (choice != '0');
		kb.close();
	} // main

	/**
	 * Prints the menu
	 */
	public static void printMenu() {
		System.out.println("1. Add an item to the list");
		System.out.println("2. Delete an item from the list");
		System.out.println("3. Print each item in the list");
		System.out.println("4. Search for a user-specified item in the list");
		System.out.println("5. Count the total number of items in the list");
		System.out.println("6. Total the cost of the items in the list");
		System.out.println("7. Determine whether the list is empty");
		System.out.println("8. Determine whether the list is full");
		System.out.println("9. Clear the list");
		System.out.println("0. Quit");
		System.out.println();
		System.out.print(">>> ");
	} // printMenu

} // ShoppingDemoDePace
