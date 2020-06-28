//
// Kyle DePace
// Prog 3
// Due Date and Time: 02/17/2020 before 9:00 a.m.
// 
// Purpose: To calculate the cost for individuals and groups of patients at a 
// 			hospital depending on their insurance plan and how long they stay.
//
// Input:  	The user's health insurance, their household income, and how long 
//			they will stay in the hospital
// 
// Output: 	The cost breakdown for the user to stay inn the hospital for that 
//			long taking into account a discount.  Also, a summary for all users.
//
// Certificate of Authenticity: I certify that this lab is entirely of my own work.

import java.text.DecimalFormat;
import java.util.Scanner;

public class HospitalDePace {

	static Scanner kb = new Scanner(System.in);
	static DecimalFormat moneyStyle = new DecimalFormat("$0.00");
	static final int ADMITTANCE_FEE = 500;

	public static void main(String[] args) {
		// Input variables
		int patID = -1;
		double houseIncome = 0;
		char insurancePlan = 'X';
		int days = 0;

		// Calculation variables
		double perDiem = 0;
		double serviceFee = 0;
		double discount = 0;
		double bill = 0;

		// Summary variables
		int numPats = 0;
		double highestBill = Integer.MIN_VALUE;
		int highestPatient = 0;
		double lowestBill = Integer.MAX_VALUE;
		int lowestPatient = 0;
		double totalCost = 0;
		double averageCost = 0;

		System.out.print("Enter your patient ID (0 to quit): ");
		patID = kb.nextInt();
		while (patID != 0) {
			numPats++;
			// Get the input from the user
			do {
				System.out.print("Enter your household income (must be positive): ");
				houseIncome = kb.nextDouble();
			} // do
			while (houseIncome < 0);
			do {
				System.out.print("Enter your insurance provider (B, M, H or N): ");
				insurancePlan = kb.next().toUpperCase().charAt(0);
			} // do
			while (insurancePlan != 'B' && insurancePlan != 'M' && insurancePlan != 'H' && insurancePlan != 'N');
			do {
				System.out.print("Enter the length of your stay (between 1 - 365 days): ");
				days = kb.nextInt();
			} // do
			while (days < 1 || days > 365);

			// Run the calculations
			perDiem = calcPerDiem(insurancePlan, houseIncome);
			serviceFee = calcServiceFee(perDiem, days);
			discount = calcDiscount(days);
			bill = calcTotalBill(serviceFee, discount);

			// Output the results
			outputResults(patID, houseIncome, insurancePlan, days, perDiem, serviceFee, discount, bill);

			// Determine the highest and lowest bills
			if (lowestBill > bill) {
				lowestBill = bill;
				lowestPatient = patID;
			} // if
			if (highestBill < bill) {
				highestBill = bill;
				highestPatient = patID;
			} // if

			// Calculate the total bill
			totalCost += bill;

			// Get the input for the next run
			System.out.println();
			System.out.print("Enter your patient ID (0 to quit): ");
			patID = kb.nextInt();
		} // while

		// Calculate the average cost
		if (numPats != 0)
			averageCost = totalCost / numPats;

		// Print the summary info
		System.out.println();
		System.out.println("Summary Information: ");
		System.out.println();
		System.out.println("Highest Bill: " + moneyStyle.format(highestBill));
		System.out.println("ID of Highest Bill: " + highestPatient);
		System.out.println("Lowest Bill: " + moneyStyle.format(lowestBill));
		System.out.println("ID of Lowest Bill: " + lowestPatient);
		System.out.println("Total Cost: " + moneyStyle.format(totalCost));
		System.out.println("Average Cost: " + moneyStyle.format(averageCost));
		
		System.out.println();
		System.out.println("Goodbye!");
		kb.close();
	} // main

	/**
	 * This function will calculate the daily cost of stay in the hospital.
	 * 
	 * @param plan   A character that corresponds to the insurance plan. (B M H or
	 *               N)
	 * @param income The household income of the user in dollars.
	 * @return The daily rate for the hospital (per diem)
	 */
	public static int calcPerDiem(char plan, double income) {
		int ans = 0;
		switch (plan) {
		case 'B':
			if (income < 15000) {
				ans = 50;
			} // if
			else if (income <= 67500) {
				ans = 85;
			} // else if
			else {
				ans = 150;
			} // else
			break;
		case 'M':
			if (income < 20000) {
				ans = 65;
			} // if
			else if (income <= 75000) {
				ans = 100;
			} // else if
			else {
				ans = 200;
			} // else
			break;
		case 'H':
			if (income < 17500) {
				ans = 55;
			} // if
			else if (income <= 63000) {
				ans = 90;
			} // else if
			else {
				ans = 150;
			} // else
			break;
		case 'N':
			ans = 500;
			break;
		default:
			System.out.println("Invalid Healthcare");
		} // switch
		return ans;
	} // calcPerDiem

	/**
	 * This function will calculate the service fee
	 * 
	 * @param perDiemRate  The daily cost of the hospital in dollars
	 * @param numDays      The number of days the user stays in the hospital
	 * @return The service fee in dollars
	 */
	public static double calcServiceFee(double perDiemRate, int numDays) {
		double ans = 0;
		ans = perDiemRate * numDays;
		return ans;
	} // calcServiceFee

	/**
	 * This function will calculate the discount for patients depending on the
	 * number of days stayed.
	 * 
	 * @param numDays The number of days stayed in the hospital
	 * @return The discount in dollars
	 */
	public static double calcDiscount(int numDays) {
		double ans = 0;
		ans = 300 * (numDays / 7);
		if (numDays < 25) {
			ans = 0;
		} // if
		return ans;
	} // calcDiscount

	/**
	 * This function will calculate the total bill of the patient
	 * 
	 * @param fee 			   The service cost in dollars
	 * @param discountAmount   The amount of the discount in dollars
	 * @return The total bill in dollars
	 */
	public static double calcTotalBill(double fee, double discountAmount) {
		double ans = 0;
		ans = fee + ADMITTANCE_FEE - discountAmount;
		return ans;
	} // calcTotalBill

	/**
	 * This method will output the patients receipt to the console.
	 * 
	 * @param patient         The ID of the patient
	 * @param householdIncome The household income of the patient
	 * @param insurance       The insurance plan character for the patient
	 * @param numDays         The number of days the patient stayed
	 * @param perDiemRate     The daily rate for the patient
	 * @param fee             The service fee for the patient
	 * @param discountAmount  The discount the patient receives
	 * @param finalBill       The final cost of the stay
	 */
	public static void outputResults(int patient, double householdIncome, char insurance, int numDays,
			double perDiemRate, double fee, double discountAmount, double finalBill) {
		// translate insurance plan
		String insuranceName = "";
		switch (insurance) {
		case 'B':
			insuranceName = "Blue Cross";
			break;
		case 'M':
			insuranceName = "Med-Health";
			break;
		case 'H':
			insuranceName = "Health Plan";
			break;
		case 'N':
			insuranceName = "No Insurance";
			break;
		default:
			insuranceName = "Error: Did not match";
		}

		System.out.println("\nPatient ID: " + patient);
		System.out.println("Household Income: " + moneyStyle.format(householdIncome));
		System.out.println("Insurance Plan: " + insuranceName);
		System.out.println("Number of Days Stayed: " + numDays);
		System.out.println("Admittance Fee: " + moneyStyle.format(ADMITTANCE_FEE));
		System.out.println("Per Diem Rate: " + moneyStyle.format(perDiemRate));
		System.out.println("Service Fee: " + moneyStyle.format(fee));
		System.out.println("Discount: " + moneyStyle.format(discountAmount));
		System.out.println("Your Bill: " + moneyStyle.format(finalBill));
	} // outputResults
	
} // HospitalDePace