/**
 * This class is the implementation of a KeyedList <br>
 * Using the LinkedList data-structure <br>
 * A KeyedList is an array that is always sorted by a key
 * 
 * @author Kyle DePace
 *
 */
public class KeyedListDePace {

	/**
	 * The head reference
	 */
	private NodeDePace myHead;

	/**
	 * The constructor for a KeyedList
	 */
	public KeyedListDePace() {
		myHead = null;
	} // KeyedListDePace

	/**
	 * Clears the list
	 */
	public void clear() {
		myHead = null;
	} // clear

	/**
	 * Find the location of the item in the list
	 * 
	 * @param keyValue The key of the item to search for
	 * @return The index of the item, -1 if not found
	 */
	private int findIndex(String keyValue) {
		NodeDePace curr = myHead;
		int loc = 0;
		while (curr != null && !curr.getData().getKey().equalsIgnoreCase(keyValue)) {
			loc++;
			curr = curr.getNext();
		} // while
		if (curr == null) // if we made it through the whole list without finding matching key make it -1
			loc = -1;
		return loc;
	} // findIndex

	/**
	 * Adds an item to the list
	 * 
	 * @param product The item to add
	 * @return Whether or not the item could be added
	 */
	public boolean add(ItemDePace product) {
		boolean success = false;
		NodeDePace curr = myHead;
		NodeDePace prev = null;
		NodeDePace newNode = new NodeDePace(product);

		if (findIndex(product.getKey()) == -1) { // only run if the item is not in the list
			while (curr != null && curr.getData().getKey().compareToIgnoreCase(product.getKey()) < 0) {
				prev = curr;
				curr = curr.getNext();
			} // while
			newNode.setNext(curr);
			if (prev != null) // if previous is null we want to make the head the new node
				prev.setNext(newNode);
			else
				myHead = newNode;
			success = true;
		} // if
		return success;
	} // add

	/**
	 * Removes an item from the list
	 * 
	 * @param keyValue The key of the item to remove
	 * @return Whether or not the item could be removed
	 */
	public boolean remove(String keyValue) {
		boolean success = false;
		NodeDePace curr = myHead;
		NodeDePace prev = null;

		if (findIndex(keyValue) != -1) { // only run if the item is in the list
			while (curr != null && curr.getData().getKey().compareToIgnoreCase(keyValue) != 0) {
				prev = curr;
				curr = curr.getNext();
			} // while
			if (curr == null) // end of list
				prev.setNext(null);
			else if (prev == null) // start of list
				myHead = curr.getNext();
			else // middle list
				prev.setNext(curr.getNext());
			success = true;
		} // if
		return success;
	} // remove

	/**
	 * Retrieves an item by it's key
	 * 
	 * @param keyValue The key to retrieve
	 * @return The retrieved item, null if not found
	 */
	public ItemDePace retrieve(String keyValue) {
		int index = findIndex(keyValue);
		NodeDePace curr = myHead;
		ItemDePace ans = null;

		for (int i = 0; i < index; i++)
			curr = curr.getNext();

		if (index != -1) // if found change ans
			ans = curr.getData();

		return ans;
	} // retrieve

	/**
	 * Determines if the list is empty
	 * 
	 * @return True if the list is empty
	 */
	public boolean isEmpty() {
		return myHead == null;
	} // isEmpty

	/**
	 * Determines if the list is full
	 * 
	 * @return True if the list is full
	 */
	public boolean isFull() {
		return false;
	} // isFull

	/**
	 * Prints the list
	 */
	public void print() {
		NodeDePace curr = myHead;
		while (curr != null) {
			System.out.println(curr.getData().toString());
			curr = curr.getNext();
		} // while
	} // print

	/**
	 * Gets the total number of items
	 * 
	 * @return The total number of items
	 */
	public int getCount() {
		int count = 0;
		NodeDePace curr = myHead;
		while (curr != null) {
			count += curr.getData().getQuantity();
			curr = curr.getNext();
		} // while
		return count;
	} // getCount

	/**
	 * Calculates the total cost of the list
	 * 
	 * @return The total cost of the list
	 */
	public double calcTotal() {
		double total = 0;
		NodeDePace curr = myHead;
		while (curr != null) {
			total += curr.getData().getQuantity() * curr.getData().getPrice();
			curr = curr.getNext();
		} // while
		return total;
	} // calcTotal

} // KeyedListDePace
