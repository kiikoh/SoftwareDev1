//
// Kyle DePace
// Prog 2
// Due Date and Time: 02/10/2020 before 9:00 a.m.
// 
// Purpose: 
//
// Input: 
// 
// Output: 
//
// Certificate of Authenticity: I certify that this lab is entirely of my own work.

import java.text.DecimalFormat;
import java.util.Scanner;

public class TaxesDePace {

	static Scanner kb = new Scanner(System.in);
	static DecimalFormat moneyStyle = new DecimalFormat("0.00");
	
	public static void main(String[] args) {
		final int EXEMPTION_DEDUCTION = 1200;
		final int STANDARD_DEDUCTION = 3250;
		
		int payerID = 0;
		char filingStatus = 'N';
		String filingStatusWords = "";
		double grossIncome = 0.0;
		int numExemptions = 0;

		double taxableIncome = 0;
		int taxRate = 0;
		double taxesDue = 0;

		int numPayers = 0;
		double highestTax = Integer.MIN_VALUE;
		int highestTaxID = 0;
		double totalTaxesPaid = 0;
		double averageTax = 0;

		// Greet the user
		System.out.println("This program will assist in calculating taxes for multiple users.");

		// Get the taxpayer id before the loop
		System.out.print("Please enter your taxpayer id (0 to quit): ");
		payerID = kb.nextInt();

		while (payerID != 0) {
			numPayers++;
			// Get inputs from the user
			do {
				System.out.print("Please enter your filing status (I, J or H): ");
				filingStatus = kb.next().toUpperCase().charAt(0);
			} // do
			while (filingStatus != 'I' && filingStatus != 'J' && filingStatus != 'H');

			System.out.print("Please enter your gross income: ");
			grossIncome = kb.nextDouble();

			do {
				System.out.print("Please enter your number of exemptions (between 0-10): ");
				numExemptions = kb.nextInt();
			} // do
			while (numExemptions < 0 || numExemptions > 10);

			// Calculate the taxes
			taxableIncome = grossIncome - STANDARD_DEDUCTION - numExemptions * EXEMPTION_DEDUCTION;
			switch (filingStatus) {
			case 'I':
				filingStatusWords = "Individual";
				if (taxableIncome < 17000) {
					taxRate = 11;
				} // if
				else if (taxableIncome <= 58000) {
					taxRate = 20;
				} // else if
				else {
					taxRate = 31;
				} // else
				break;
			case 'J':
				filingStatusWords = "Married filing Jointly";
				if (taxableIncome < 20000) {
					taxRate = 14;
				} // if
				else if (taxableIncome <= 110000) {
					taxRate = 22;
				} // else if
				else {
					taxRate = 39;
				} // else
				break;
			case 'H':
				filingStatusWords = "Head of Household";
				if (taxableIncome < 34000) {
					taxRate = 15;
				} // if
				else if (taxableIncome <= 75000) {
					taxRate = 23;
				} // else if
				else {
					taxRate = 38;
				} // else
				break;
			default:
				System.out.println("I dont know how you possibly got here");
			} // switch
			taxesDue = taxableIncome * taxRate / 100.;
			if(taxesDue < 0) taxesDue = 0;
			totalTaxesPaid += taxesDue;
			
			if(taxesDue > highestTax) {
				highestTax = taxesDue;
				highestTaxID = payerID;
			}
			
			System.out.println();
			System.out.println("Taxpayer ID: " + payerID);
			System.out.println("Filing Status: " + filingStatusWords);
			System.out.println("Taxable Income: $" + moneyStyle.format(taxableIncome));
			System.out.println("Tax Rate: " + taxRate + "%");
			System.out.println("Taxes Owed: $" + moneyStyle.format(taxesDue));

			//Start prompting for next user
			System.out.println();
			System.out.print("Please enter your taxpayer id (0 to quit): ");
			payerID = kb.nextInt();
		} // while
		
		// Calculate the average
		if(numPayers != 0) {
			averageTax = totalTaxesPaid / numPayers;
		} else {
			averageTax = 0;
		}
		
		
		// Output summary information
		System.out.println();
		System.out.println("----- Taxes Summary -----");
		System.out.println("Number of Taxpayers: " + numPayers);
		System.out.println("Highest Tax Amount: $" + moneyStyle.format(highestTax));
		System.out.println("Taxpayer ID of Highest Tax Amount: " + highestTaxID);
		System.out.println("Total Taxes Paid: $" + moneyStyle.format(totalTaxesPaid));
		System.out.println("Average Tax Amount: $" + moneyStyle.format(averageTax));
		
		System.out.println();
		System.out.println("Goodbye!");

	} // main

} // TaxesDePace
