/**
 * This class is the implementation of a KeyedList <br>
 * A KeyedList is an array that is always sorted by a key
 * 
 * @author Kyle DePace
 *
 */
public class KeyedListDePace {
	
	/**
	 * The array storing the items
	 */
	private ItemDePace[] myList;
	
	/**
	 * The size of the array
	 */
	private int mySize;

	/**
	 * The constructor for a KeyedList
	 */
	public KeyedListDePace() {
		mySize = 0;
		myList = new ItemDePace[10];
		for (int i = 0; i < myList.length; i++)
			myList[i] = new ItemDePace();
	} // KeyedListDePace

	/**
	 * The size of the list
	 * @return The size of the list
	 */
	public int getSize() {
		return mySize;
	} // getSize

	/**
	 * Clears the list
	 */
	public void clear() {
		mySize = 0;
	} // clear

	/**
	 * Find the location of the item in the list
	 * @param keyValue The key of the item to search for
	 * @return The index of the item, -1 if not found
	 */
	private int findIndex(String keyValue) {
		int loc = 0;
		while (loc < mySize && keyValue.compareToIgnoreCase(myList[loc].getKey()) > 0)
			loc++;
		if (!myList[loc].getKey().equalsIgnoreCase(keyValue))
			loc = -1;
		return loc;
	} // findIndex

	/**
	 * Adds an item to the list
	 * @param product The item to add
	 * @return Whether or not the item could be added
	 */
	public boolean add(ItemDePace product) {
		boolean success = false;
		int i = 0;
		if (findIndex(product.getKey()) == -1 && !isFull()) {
			// find the spot
			while (i < mySize && product.getKey().compareToIgnoreCase(myList[i].getKey()) > 0)
				i++;
			// now i is the location of where to add
			for (int j = mySize - 1; j >= i; j--)
				myList[j + 1] = myList[j];
			myList[i] = product;
			mySize++;
			success = true;
		} // if
		return success;
	} // add

	/**
	 * Removes an item from the list
	 * @param keyValue The key of the item to remove
	 * @return Whether or not the item could be removed
	 */
	public boolean remove(String keyValue) {
		boolean success = false;
		int index = findIndex(keyValue);
		if (index != -1) {
			// begin the scootch
			for (int i = index; i < mySize - 1; i++)
				myList[i] = myList[i + 1];
			mySize--;
			success = true;
		} // if
		return success;
	} // remove

	/**
	 * Retrieves an item by it's key 
	 * @param keyValue The key to retrieve
	 * @return The retrieved item, null if not found
	 */
	public ItemDePace retrieve(String keyValue) {
		ItemDePace ans = null;
		int index = findIndex(keyValue);
		if (index != -1)
			ans = myList[index];
		return ans;
	} // retrieve

	/**
	 * Determines if the list is empty
	 * @return True if the list is empty
	 */
	public boolean isEmpty() {
		return mySize == 0;
	} // isEmpty

	/**
	 * Determines if the list is full
	 * @return True if the list is full
	 */
	public boolean isFull() {
		return mySize == myList.length;
	} // isFull

	/**
	 * Prints the list
	 */
	public void print() {
		for (int i = 0; i < mySize; i++)
			System.out.println(myList[i].toString());
	} // print

	/**
	 * Gets the total number of items
	 * @return The total number of items
	 */
	public int getCount() {
		int count = 0;
		for (int i = 0; i < mySize; i++)
			count += myList[i].getQuantity();
		return count;
	} // getCount

	/**
	 * Calculates the total cost of the list
	 * @return The total cost of the list
	 */
	public double calcTotal() {
		double total = 0;
		for (int i = 0; i < mySize; i++)
			total += myList[i].getQuantity() * myList[i].getPrice();
		return total;
	} // calcTotal

} // KeyedListDePace
