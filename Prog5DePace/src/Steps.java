public class Steps {

	private int myStepWidth, myNumSteps;
	private char myFillChar;

	/**
	 * Creates a steps object with width 2, number of steps 5, and fill character *
	 */
	public Steps() {
		myStepWidth = 2;
		myNumSteps = 5;
		myFillChar = '*';
	} // Steps default

	/**
	 * Create a steps object
	 * 
	 * @param newStepWidth The width of the steps
	 * @param newNumSteps  The number of steps
	 * @param newFillChar  The fill character
	 */
	public Steps(int newStepWidth, int newNumSteps, char newFillChar) {
		myStepWidth = newStepWidth;
		myNumSteps = newNumSteps;
		myFillChar = newFillChar;
	} // Steps full

	/**
	 * Gets the step width
	 * 
	 * @return the Step Width
	 */
	public int getStepWidth() {
		return myStepWidth;
	} // getStepWidth

	/**
	 * Sets the step width
	 * 
	 * @param newStepWidth The new step width
	 */
	public void setStepWidth(int newStepWidth) {
		myStepWidth = newStepWidth;
	} // setStepWidth

	/**
	 * Gets the number of steps
	 * 
	 * @return The number of steps
	 */
	public int getNumSteps() {
		return myNumSteps;
	} // getNumSteps

	/**
	 * Sets the number of steps
	 * 
	 * @param mewNumSteps The new number of steps
	 */
	public void setNumSteps(int newNumSteps) {
		myNumSteps = newNumSteps;
	} // setNumSteps

	/**
	 * Gets the fill character
	 * 
	 * @return The Character to fill
	 */
	public char getFillChar() {
		return myFillChar;
	} // getFillChar

	/**
	 * Sets the fill character
	 * 
	 * @param newFillChar The new fill character
	 */
	public void setFillChar(char newFillChar) {
		myFillChar = newFillChar;
	} // setFillChar

	/**
	 * Draws the steps
	 */
	public void drawSteps() {
		for (int step = 1; step <= myNumSteps; step++) {
			for (int i = 0; i < myStepWidth * step; i++) {
				System.out.print(myFillChar);
			} // for i
			System.out.println();
		} // for step
	} // drawSteps

	public void drawThickSteps() {
		for (int step = 1; step <= myNumSteps; step++) {
			for (int thick = 0; thick < myStepWidth; thick++) {
				for (int i = 0; i < myStepWidth * step; i++) {
					System.out.print(myFillChar);
				} // for i
				System.out.println();
			} // for thick
		} // for step
	}

	/**
	 * Calculates the area of the steps
	 * 
	 * @return The area of the steps
	 */
	public int calculateArea() {
		int result = 0;
		for (int step = 1; step <= myNumSteps; step++) {
			for (int i = 0; i < myStepWidth * step; i++) {
				result++;
			} // for i
		} // for step
		return result;
	} // calculateArea

	/**
	 * A text representation of the steps
	 */
	public String toString() {
		String result = "Width of steps: " + myStepWidth;
		result += "\nNumber of Steps: " + myNumSteps;
		result += "\nFill Character: " + myFillChar;
		result += "\nArea of Steps: " + calculateArea();
		return result;
	} // toString

} // Steps
