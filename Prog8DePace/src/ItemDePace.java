import java.text.*;

/**
 * This class is a representation of a shopping item
 * 
 * @author Kyle DePace
 *
 */
public class ItemDePace {
	/**
	 * The key of the item
	 */
	private String myKey;
	
	/**
	 * The quantity of the item
	 */
	private int myQuantity;
	
	/**
	 * The price of the item
	 */
	private double myPrice;
	
	/**
	 * The money formatter
	 */
	private static DecimalFormat money = new DecimalFormat("$0.00");

	/**
	 * Default constructor for the Item 
	 */
	public ItemDePace() {
		myKey = "";
		myQuantity = 0;
		myPrice = 0.00;
	} // ItemDePace default

	/**
	 * The full constructor for the item
	 * @param newKey The key for the item
	 * @param newQuantity The quantity of the item
	 * @param newPrice The price of the item
	 */
	public ItemDePace(String newKey, int newQuantity, double newPrice) {
		myKey = newKey;
		myQuantity = newQuantity;
		myPrice = newPrice;
	} // ItemDePace full

	/**
	 * The getter for the key
	 * @return the key of the item
	 */
	public String getKey() {
		return myKey;
	} // getKey

	/**
	 * The setter for the key
	 * @param newKey The new key for the item
	 */
	public void setKey(String newKey) {
		myKey = newKey;
	} // setKey

	/**
	 * The getter for the quantity
	 * @return the quantity of the item
	 */
	public int getQuantity() {
		return myQuantity;
	} // getQuantity

	/**
	 * The setter for the quantity
	 * @param newKey The new quantity for the item
	 */
	public void setQuantity(int newQuantity) {
		myQuantity = newQuantity;
	} // setQuantity

	/**
	 * The getter for the price
	 * @return the price of the item
	 */
	public double getPrice() {
		return myPrice;
	} // getPrice

	/**
	 * The setter for the price
	 * @param newKey The new price for the item
	 */
	public void setPrice(double newPrice) {
		myPrice = newPrice;
	} // setPrice

	/**
	 * A string representation of the Item
	 */
	public String toString() {
		return myKey + ": " + myQuantity + "x" + money.format(myPrice);
	} // toString

} // ItemDePace
