//
// Kyle DePace
// Prog 6
// Due Date and Time: 02/24/2020 before 9:00 a.m.
// 
// Purpose: Create a Steps object to use in drawing a staircase with text
//
// Input: 	User selects menu options which allows them to change the
//			properties of the steps
// 
// Output: 	User can get either a text description or a drawing of the 
//			steps in text
//
// Certificate of Authenticity: I certify that this lab is entirely of my own work.

import java.util.Scanner;

public class StepsDemoDePace {

	static Scanner kb = new Scanner(System.in);

	public static void main(String[] args) {
		char choice = 'X';
		int number = -1;
		char fillChar = '*';
		Steps step = new Steps();

		System.out.println("Welcome to the steps program!\n");

		do {
			printMenu();
			choice = kb.next().toUpperCase().charAt(0);
			System.out.println();
			switch (choice) {
			case 'W':
				do {
					System.out.print("Change the step width (Must be >0): ");
					number = kb.nextInt();
				} // do
				while (number < 1);
				System.out.println("Set step width to " + number);
				step.setStepWidth(number);
				break;
			case 'N':
				do {
					System.out.print("Change the number of steps (Must be >0): ");
					number = kb.nextInt();
				} // do
				while (number < 1);
				System.out.println("Set number of steps to " + number);
				step.setNumSteps(number);
				break;
			case 'F':
				System.out.print("Change the fill character: ");
				fillChar = kb.next().charAt(0);
				step.setFillChar(fillChar);
				break;
			case 'A':
				System.out.println("The area of the steps is " + step.calculateArea());
				break;
			case 'T':
				System.out.println(step);
				break;
			case 'D':
				step.drawSteps();
				break;
			case 'X':
				step.drawThickSteps();
				break;
			case 'Q':
				System.out.println("Goodbye!");
				break;
			default:
				System.out.println("Invalid Choice");
			} // switch
			System.out.println();

		} // do
		while (choice != 'Q');
		kb.close();
	} // main

	/**
	 * Prints the menu
	 */
	public static void printMenu() {
		System.out.println("W : Assign the Step Width");
		System.out.println("N : Assign the Number of Steps");
		System.out.println("F : Assign the Fill Style");
		System.out.println("A : Calculate the Area");
		System.out.println("T : Text Description of the Steps");
		System.out.println("D : Draw the Steps");
		System.out.println("X : Draw the Thick Steps");
		System.out.println("Q : Quit");
		System.out.println();
		System.out.print(">>> ");
	} // printMenu

} // StepsDemoDePace
