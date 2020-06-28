/**
 * This class is a representation of a Pokemon card
 * 
 * @author Kyle DePace
 *
 */
public class PokemonCardDePace {
	/**
	 * The name of the Pokemon
	 */
	private String myName;
	
	/**
	 * The power of the Pokemon
	 */
	private int myPower;
	
	/**
	 * Default constructor for the Pokemon 
	 */
	public PokemonCardDePace() {
		myName = "";
		myPower = 0;
	} // PokemonCardDePace default

	/**
	 * The full constructor for the Pokemon 
	 * @param newName The name for the Pokemon 
	 * @param newPower The power of the Pokemon 
	 */
	public PokemonCardDePace(String newName, int newPower) {
		myName = newName;
		myPower = newPower;
	} // PokemonCardDePace full

	/**
	 * Getter for the Name
	 * @return The name of the Pokemon
	 */
	public String getName() {
		return myName;
	} // getName

	/**
	 * Setter for the Name
	 * @param newName The new name of the Pokemon
	 */
	public void setName(String newName) {
		myName = newName;
	} // setName 
	
	/**
	 * Getter for the Power
	 * @return The power of the Pokemon
	 */
	public int getPower() {
		return myPower;
	} // getPower

	/**
	 * Setter for the Power
	 * @param newPower The new power of the Pokemon
	 */
	public void setPower(int newPower) {
		myPower = newPower;
	} // setPower

	/**
	 * A string representation of the Pokemon for debugging purposes
	 */
	public String toString() {
		return myName + " " + myPower;
	} // toString

} // PokemonCardDePace