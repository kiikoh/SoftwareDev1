import java.text.DecimalFormat;

/**
 * This class is representative of a song
 * 
 * @author Kyle DePace
 *
 */
public class Song {
	/**
	 * The name of the Song
	 */
	private String myName;
	/**
	 * The artist of the Song
	 */
	private String myArtist;
	/**
	 * The number of minutes in the Song
	 */
	private int myMinutes;
	/**
	 * The number of seconds in the Song
	 */
	private int mySeconds;
	/**
	 * The price of the Song
	 */
	private double myPrice;

	/**
	 * Used to format money
	 */
	private static DecimalFormat money = new DecimalFormat("$0.00");
	/**
	 * Used to format seconds to 2 places (i.e. 2 to 02)
	 */
	private static DecimalFormat seconds = new DecimalFormat("00");

	/**
	 * Creates an empty Song object
	 */
	public Song() {
		myName = "Unknown";
		myArtist = "Unknown";
		myMinutes = 0;
		mySeconds = 0;
		myPrice = 0.00;
	} // Song default

	/**
	 * Creates a song object
	 * 
	 * @param newName    The name of the song
	 * @param newArtist  The name of the artist
	 * @param newMinutes The number of minutes in the song
	 * @param newSeconds The number of seconds in the song
	 * @param newPrice   The price of the song
	 */
	public Song(String newName, String newArtist, int newMinutes, int newSeconds, double newPrice) {
		myName = newName;
		myArtist = newArtist;
		myMinutes = newMinutes;
		mySeconds = newSeconds;
		myPrice = newPrice;
	} // Song full

	/**
	 * Getter for the name
	 * 
	 * @return The song name
	 */
	public String getName() {
		return myName;
	} // getName

	/**
	 * Setter for the song name
	 * 
	 * @param newName The new name of the song
	 */
	public void setName(String newName) {
		myName = newName;
	} // setName

	/**
	 * Getter for the artist
	 * 
	 * @return The artist of the song
	 */
	public String getArtist() {
		return myArtist;
	} // getArtist

	/**
	 * Setter for the artist
	 * 
	 * @param newArtist The new artist of the song
	 */
	public void setArtist(String newArtist) {
		myArtist = newArtist;
	} // setArtist

	/**
	 * Getter for the number of minutes
	 * 
	 * @return The number of minutes in the song
	 */
	public int getMinutes() {
		return myMinutes;
	} // getMinutes

	/**
	 * Setter for the number of minutes in the song
	 * 
	 * @param newMinutes The new number of minutes
	 */
	public void setMinutes(int newMinutes) {
		myMinutes = newMinutes;
	} // setMinutes

	/**
	 * Getter for the number of seconds
	 * 
	 * @return The number of seconds in the song
	 */
	public int getSeconds() {
		return mySeconds;
	} // getSeconds

	/**
	 * Setter for the number of seconds in the song
	 * 
	 * @param newSeconds The new number of seconds
	 */
	public void setSeconds(int newSeconds) {
		mySeconds = newSeconds;
	} // setSeconds

	/**
	 * Getter for the price of the song
	 * 
	 * @return The price of the song
	 */
	public double getPrice() {
		return myPrice;
	} // getPrice

	/**
	 * Setter for the price of the song
	 * 
	 * @param newPrice The new price of the song
	 */
	public void setPrice(double newPrice) {
		myPrice = newPrice;
	} // setPrice

	/**
	 * A String representation of the Song
	 */
	public String toString() {
		String result = "Song: " + myName + " by " + myArtist;
		result += "\nLength: " + myMinutes + ":" + seconds.format(mySeconds);
		result += "\nCost: " + money.format(myPrice);
		return result;
	} // toString

} // Song
