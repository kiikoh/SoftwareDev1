/**
 * This class is representative of a Playlist
 * 
 * @author Kyle DePace
 *
 */
public class PlaylistDePace {

	/**
	 * The list of songs
	 */
	private SongDePace[] mySongs;
	/**
	 * The amount of songs in the list
	 */
	private int mySize;

	/**
	 * Creates a Playlist holding up to 10 songs
	 */
	public PlaylistDePace() {
		mySongs = new SongDePace[10];
		mySize = 0;
		for(int i = 0;i<mySongs.length;i++) {
			mySongs[i] = new SongDePace();
		}
	} // Playlist default

	/**
	 * Getter for the number of songs in the Playlist
	 * 
	 * @return The number of songs in the Playlist
	 */
	public int getSize() {
		return mySize;
	} // getSize

	/**
	 * Adds a song to the playlist
	 * 
	 * @param newSong The song to add
	 * @return The status of adding the song
	 */
	public boolean addToPlaylist(SongDePace newSong) {
		boolean hasRoom = false;
		if (mySize < mySongs.length) {
			hasRoom = true;
			mySongs[mySize] = newSong;
			mySize++;
		} // if
		return hasRoom;
	}// addToPlaylist

	/**
	 * Finds the longest song
	 * 
	 * @return The longest Song
	 */
	public SongDePace findLongest() {
		SongDePace longest = null;
		int songSeconds = 0;
		int longestSeconds = -1;
		for (int i = 0; i < mySize; i++) {
			songSeconds = mySongs[i].getMinutes() * 60 + mySongs[i].getSeconds();
			if (longestSeconds < songSeconds) {
				longestSeconds = songSeconds;
				longest = mySongs[i];
			} // if
		} // for i
		return longest;
	} // findLongest

	/**
	 * Finds the shortest song
	 * 
	 * @return The shortest Song
	 */
	public SongDePace findShortest() {
		SongDePace shortest = null;
		int songSeconds = 0;
		int shortestSeconds = Integer.MAX_VALUE;
		for (int i = 0; i < mySize; i++) {
			songSeconds = mySongs[i].getMinutes() * 60 + mySongs[i].getSeconds();
			if (shortestSeconds > songSeconds) {
				shortestSeconds = songSeconds;
				shortest = mySongs[i];
			} // if
		} // for i
		return shortest;
	} // findShortest

	/**
	 * Calculate the total cost of the playlist
	 * 
	 * @return The cost of the playlist
	 */
	public double calcTotal() {
		double totalCost = 0;
		for (int i = 0; i < mySize; i++) {
			totalCost += mySongs[i].getPrice();
		} // for i
		return totalCost;
	} // calcTotal

	/**
	 * Prints the entire playlist
	 */
	public void printFullPlaylist() {
		if (mySize == 0)
			System.out.println("The playlist is empty.");
		for (int i = 0; i < mySize; i++) {
			System.out.println("Song #" + (i + 1));
			System.out.println(mySongs[i].toString());
			System.out.println();
		} // for i
	} // printFullPlaylist

	/**
	 * Removes the longest song from the playlist
	 * 
	 * @return The status of deleting the longest song
	 */
	public boolean deleteLongest() {
		int songSeconds = 0;
		int longestSeconds = -1;
		int longLoc = 0;
		boolean status = false;
		if (mySize > 0) {
			for (int i = 0; i < mySize; i++) {
				songSeconds = mySongs[i].getMinutes() * 60 + mySongs[i].getSeconds();
				if (longestSeconds < songSeconds) {
					longestSeconds = songSeconds;
					longLoc = i;
				} // if
			} // for i
				// Now longLoc is the index of the longest song
				// Remove it by swapping the last element to it
			mySongs[longLoc] = mySongs[mySize - 1];
			mySize--;
			status = true;
		} // if
		return status;
	} // deleteLongest
} // Playlist
