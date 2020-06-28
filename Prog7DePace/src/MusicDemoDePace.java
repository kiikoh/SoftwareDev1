import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Kyle DePace <br>
 * Prog 6 <br>
 * Due Date and Time: 03/12/2020 before 9:00 a.m. <br>
 * 
 * Purpose: To model a playlist where a user can add and remove songs <br>
 *
 * Input: Users can input a song to add or a command which will run an <br>
 * operation on the playlist <br>
 * Output: The playlist can be printed with P or you can get the length <br>
 * of the playlist <br>
 *
 * Certificate of Authenticity: I certify that this lab is entirely of my own
 * work. <br>
 * 
 * @author Kyle DePace <br>
 */
public class MusicDemoDePace {

	static Scanner kb = new Scanner(System.in);
	static DecimalFormat money = new DecimalFormat("$0.00");

	public static void main(String[] args) {
		char choice = 'X';
		String songName = "";
		String artistName = "";
		int minutes = 0;
		int seconds = 0;
		double cost = 0.0;
		PlaylistDePace playlist = new PlaylistDePace();

		String fileName = "";
		int numSongs = 0;

		System.out.println("Welcome to the playlist program!\n");

		// add the songs from input file
		System.out.print("Enter the file to use for input: ");
		fileName = kb.next();
		kb.nextLine();
		try {
			Scanner fileReader = new Scanner(new File(fileName));
			numSongs = fileReader.nextInt();
			fileReader.nextLine();
			// read in data for every song
			for (int i = 0; i < numSongs; i++) {
				songName = fileReader.nextLine();
				artistName = fileReader.nextLine();
				minutes = fileReader.nextInt();
				fileReader.nextLine();
				seconds = fileReader.nextInt();
				fileReader.nextLine();
				cost = fileReader.nextDouble();
				fileReader.nextLine();
				if (!playlist.addToPlaylist(new SongDePace(songName, artistName, minutes, seconds, cost))) {
					System.out.println("Song could not be added...");
				} // if
			} // for
			System.out.println("Songs loaded!");
			fileReader.close();
		} // try
		catch (FileNotFoundException ex) {
			System.out.println("Failed to find file: " + fileName);
		} // catch
		catch (InputMismatchException ex) {
			System.out.println("Type mismatch for the number I just tried to read.");
			System.out.println(ex.getMessage());
		} // catch
		catch (NumberFormatException ex) {
			System.out.println("Failed to convert String text into an integer value.");
			System.out.println(ex.getMessage());
		} // catch
		catch (NullPointerException ex) {
			System.out.println("Null pointer exception.");
			System.out.println(ex.getMessage());
		} // catch
		catch (Exception ex) {
			System.out.println("Something went wrong");
			ex.printStackTrace();
		} // catch
		System.out.println();

		do {
			printMenu();
			choice = kb.next().toUpperCase().charAt(0);
			kb.nextLine();
			System.out.println();
			switch (choice) {
			case 'A':
				System.out.print("Enter the song's name: ");
				// get input for the song
				songName = kb.nextLine(); // use nextline b/c "Livin on a prayer" won't work
				System.out.print("Enter the artist's name: ");
				artistName = kb.nextLine(); // same reason "bon jovi"
				do {
					System.out.print("Enter the number of minutes (postive): ");
					minutes = kb.nextInt();
					kb.nextLine(); // grab the \n from when the user presses enter
				} // do
				while (minutes < 0);
				do {
					System.out.print("Enter the number of seconds (between 0 and 59): ");
					seconds = kb.nextInt();
					kb.nextLine(); // grab the \n from when the user presses enter
				} // do
				while (seconds < 0 || seconds > 59);
				do {
					System.out.print("Enter the price of the song (postive): ");
					cost = kb.nextDouble();
					kb.nextLine(); // grab the \n from when the user presses enter
				} // do
				while (cost < 0);
				if (playlist.addToPlaylist(new SongDePace(songName, artistName, minutes, seconds, cost))) {
					System.out.println("\nSong was successfully added to the playlist");
				} // if
				else {
					System.out.println("\nSong could not be added to the playlist");
				} // else
				break;
			case 'L':
				if (playlist.getSize() > 0)
					System.out.println(playlist.findLongest().toString());
				else
					System.out.println("There are no songs yet.");
				break;
			case 'S':
				if (playlist.getSize() > 0)
					System.out.println(playlist.findShortest().toString());
				else
					System.out.println("There are no songs yet.");
				break;
			case 'N':
				System.out.println("There are " + playlist.getSize() + " songs in the playlist.");
				break;
			case 'T':
				System.out.println("The Total Cost of the playlist is " + money.format(playlist.calcTotal()));
				break;
			case 'P':
				System.out.println("Here is the playlist: ");
				playlist.printFullPlaylist();
				break;
			case 'D':
				if (playlist.deleteLongest())
					System.out.println("The longest song has been removed.");
				else
					System.out.println("There are no songs to remove.");
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
		System.out.println("A - Add a Song to the Playlist");
		System.out.println("L - Find the Longest Song in the Playlist");
		System.out.println("S - Find the Shortest Song in the Playlist");
		System.out.println("N - Find the Number of Songs in the Playlist");
		System.out.println("T - Find the Total Cost of all Songs in the Playlist");
		System.out.println("P - Print out Details about all Songs in the Playlist");
		System.out.println("D - Delete the Longest song from the Playlist");
		System.out.println("Q - Quit");
		System.out.println();
		System.out.print(">>> ");
	} // printMenu

} // MusicDemoDePace
