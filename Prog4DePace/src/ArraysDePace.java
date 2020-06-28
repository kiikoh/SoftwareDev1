//
// Kyle DePace
// Prog 4
// Due Date and Time: 02/24/2020 before 9:00 a.m.
// 
// Purpose: To use various functions taking arrays as input
//
// Input: 	User will choose from a menu with options 1, 2, 3 or 0 to quit. 
// 			Each of these options correspond to its own subprogram.
// 
// Output: 	User can gain information about their golf game, find whether
//			there are more evens or odds, or find out how many times the 
//			minimum occurs in a set of data
//
// Certificate of Authenticity: I certify that this lab is entirely of my own work.

import java.util.*;

public class ArraysDePace {

	static Scanner kb = new Scanner(System.in);

	public static void main(String[] args) {
		int choice = 0;
		System.out.println("Welcome to the arrays program!");
		System.out.println();

		do {
			printMenu();
			choice = kb.nextInt();
			System.out.println();
			switch (choice) {
			case 1:
				System.out.println("Selected \"Let's Go Golfing!\"\n");
				golfInput();
				break;
			case 2:
				System.out.println("Selected \"More Evens or More Odds?\"\n");
				evenOrOddInput();
				break;
			case 3:
				System.out.println("Selected \"How Many Mins?\"\n");
				howManyMinInput();
				break;
			case 0:
				System.out.println("Goodbye!");
				break;
			default:
				System.out.println("Invalid Choice\n");
				choice = -1;
			} // switch
		} // do
		while (choice != 0);
		kb.close();
	} // main

	/**
	 * Prints the menu
	 */
	public static void printMenu() {
		System.out.println("Please choose a menu item.");
		System.out.println("1) Let's Go Golfing!");
		System.out.println("2) More Evens or More Odds?");
		System.out.println("3) How Many Mins?");
		System.out.println("0) Quit");
		System.out.println();
		System.out.print("Your Selection: ");
	} // printMenu

	/**
	 * Collects input for golfInput
	 */
	public static void golfInput() {
		int[] user = new int[9];
		int[] parsForCourse = new int[9];

		for (int i = 0; i < 9; i++) {
			System.out.print("Enter your score for hole " + (i + 1) + ": ");
			user[i] = kb.nextInt();
		} // for
		System.out.println();
		for (int i = 0; i < 9; i++) {
			System.out.print("Enter the par for hole " + (i + 1) + ": ");
			parsForCourse[i] = kb.nextInt();
		} // for
		golfOutput(user, parsForCourse);
	} // golfInput

	/**
	 * Calculates the number of eagles, birdies, etc for a given round of golf
	 * @param strokes An array of length 9 with the number of strokes for each hole
	 * @param pars An array of length 9 with the par for each hole.
	 */
	public static void golfOutput(int[] strokes, int[] pars) {
		int eagle = 0;
		int birdie = 0;
		int par = 0;
		int bogey = 0;
		int dblBogey = 0;
		int other = 0;

		for (int i = 0; i < 9; i++) {
			switch (strokes[i] - pars[i]) {
			case -2:
				eagle++;
				break;
			case -1:
				birdie++;
				break;
			case 0:
				par++;
				break;
			case 1:
				bogey++;
				break;
			case 2:
				dblBogey++;
				break;
			default:
				other++;
			} // switch
		} // for

		// Output results
		System.out.println();
		System.out.println("Your results: ");
		System.out.println("Eagles: " + eagle);
		System.out.println("Birdies: " + birdie);
		System.out.println("Pars: " + par);
		System.out.println("Bogeys: " + bogey);
		System.out.println("Double Bogey: " + dblBogey);
		System.out.println("Others: " + other);
		System.out.println();
	} // golfOutput

	/**
	 * Collects and validates input for evenOrOdd
	 */
	public static void evenOrOddInput() {
		int[] nums = new int[10];
		int count = 0;
		int choice = 0;
		do {
			System.out.print("Enter number " + (count + 1) + " (0 to quit): ");
			choice = kb.nextInt();
			nums[count] = choice;
			if (choice != 0)
				count++;
		} // do
		while (count < 10 && choice != 0);
		System.out.println();
		evenOrOddOutput(nums, count);
	} // evenOrOddInput

	/**
	 * Calculates and prints either the evens or odds depending on which has more
	 * @param values The numbers of the array
	 * @param size The size to read in the array
	 */
	public static void evenOrOddOutput(int[] values, int size) {
		int moreOdds = 0;
		// Determine if there is more evens or odds; pos = more odd
		for (int i = 0; i < size; i++) {
			if (values[i] % 2 == 1) {
				moreOdds++;
			} // if
			else {
				moreOdds--;
			} // else
		} // for
		if (moreOdds == 0) { // there are equal evens and odds
			System.out.println("There are the same number of evens and odds");
			for (int i = 0; i < size; i++)
				System.out.print(values[i] + " ");
		} // if
		else if (moreOdds > 0) { // there are more odds
			System.out.println("There are more odds");
			for (int i = 0; i < size; i++)
				if (values[i] % 2 == 1)
					System.out.print(values[i] + " ");
		} // else if
		else { // there are more evens
			System.out.println("There are more evens");
			for (int i = 0; i < size; i++)
				if (values[i] % 2 == 0)
					System.out.print(values[i] + " ");
		} // else
		System.out.println();
		System.out.println();
	} // evenOrOddOutput

	/**
	 * Collects and validates input for howManyMin
	 */
	public static void howManyMinInput() {
		int[] nums = new int[8];
		int count = 0;
		int choice = 0;
		do {
			System.out.print("Enter number " + (count + 1) + " (negative to quit): ");
			choice = kb.nextInt();
			nums[count] = choice;
			if (choice >= 0)
				count++;
		} // do
		while (count < 8 && choice >= 0);
		System.out.println();
		howManyMinOutput(nums, count);
	} // howManyMinInput

	/**
	 * Calculates and prints the array, minimum of the array, and the number of occurrences
	 * @param values The numbers of the array
	 * @param size The size to read in the array
	 */
	public static void howManyMinOutput(int[] values, int size) {
		System.out.print("The array: ");
		for (int i = 0; i < size; i++)
			System.out.print(values[i] + " ");
		System.out.println();

		int times = 1;
		int minSoFar = Integer.MAX_VALUE;
		for (int i = 0; i < size; i++) {
			if (minSoFar > values[i]) {
				times = 1;
				minSoFar = values[i];
			} // if
			else if (minSoFar == values[i]) {
				times++;
			} // else if
		} // for
		System.out.println("The minimum: " + minSoFar);
		System.out.println("Occurences: " + times);
		System.out.println();
	} // howManyMinOutput

} // ArraysDePace
