import java.util.Scanner;

//
// Kyle DePace
// Prog 1
// Due Date and Time: 02/03/2020 before 9:00 a.m.
// 
// Purpose: Create a program that can find the most efficient way to make change for a given amount of change.
//
// Input: The amount of cents to make change for
// 
// Output: The fewest amount of bills and coins that correspond to the input
//
// Certificate of Authenticity: I certify that this lab is entirely of my own work.

public class ChangeMakerDePace {
	static Scanner kb = new Scanner(System.in);

	public static void main(String[] args) {
		int amount = 0;
		int originalAmount = 0;
		int twenties = 0;
		int tens = 0;
		int fives = 0;
		int ones = 0;
		int quarters = 0;
		int dimes = 0;
		int nickels = 0;
		int pennies = 0;
		int totalBills = 0;
		int totalCoins = 0;

		// Greet the user
		System.out.println("Welcome to the change maker system!");
		System.out.println("Enter a whole number");
		System.out.println("I will output a combination of bills and coins");
		System.out.println("that equals that amount of change.");

		// Get the input
		System.out.println("\nEnter the amount to be changed: ");
		amount = kb.nextInt();

		// Calculate change
		originalAmount = amount;
		twenties = amount / 2000;
		amount %= 2000;

		tens = amount / 1000;
		amount %= 1000;

		fives = amount / 500;
		amount %= 500;

		ones = amount / 100;
		amount %= 100;

		quarters = amount / 25;
		amount %= 25;

		dimes = amount / 10;
		amount %= 10;

		nickels = amount / 5;
		amount %= 5;

		pennies = amount;
		
		//add up the total bills and total coins
		totalBills = twenties + tens + fives + ones;
		totalCoins = quarters + nickels + dimes + pennies;
		
		// Output the results
		System.out.println(originalAmount + " cents in bills and coins can be given as:");
		if (totalBills == 1)
			System.out.println(totalBills + " bill");
		else
			System.out.println(totalBills + " bills");

		if (totalCoins == 1)
			System.out.println(totalBills + " coin");
		else
			System.out.println(totalBills + " coins");

		System.out.println("-------------------");

		if (twenties == 1)
			System.out.println(twenties + " twenty");
		else
			System.out.println(twenties + " twenties");

		if (tens == 1)
			System.out.println(tens + " ten");
		else
			System.out.println(tens + " tens");

		if (fives == 1)
			System.out.println(fives + " five");
		else
			System.out.println(fives + " fives");

		if (ones == 1)
			System.out.println(ones + " one");
		else
			System.out.println(ones + " ones");

		System.out.println();

		if (quarters == 1)
			System.out.println(quarters + " quarter");
		else
			System.out.println(quarters + " quarters");

		if (dimes == 1)
			System.out.println(dimes + " dime");
		else
			System.out.println(dimes + " dimes");

		if (nickels == 1)
			System.out.println(nickels + " nickel");
		else
			System.out.println(nickels + " nickels");

		if (pennies == 1)
			System.out.println(pennies + " penny");
		else
			System.out.println(pennies + " pennies");

		System.out.println("\nThanks! Goodbye");
		kb.close();
	} // main
} // ChangeMakerDePace
