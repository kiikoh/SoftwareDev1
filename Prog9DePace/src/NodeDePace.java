/**
 * This class is the implementation of a Node<br>
 * to be used by a LinkedList
 * 
 * @author Kyle DePace
 *
 */
public class NodeDePace {

	/**
	 * The reference to the next object in the list
	 */
	private NodeDePace myNext;

	/**
	 * The data this node contains
	 */
	private ItemDePace myData;

	/**
	 * Constructs a Node
	 */
	public NodeDePace() {
		myNext = null;
		myData = null;
	} // NodeDePace default

	/**
	 * Contructs a Node with an Item
	 * 
	 * @param newItem The item
	 */
	public NodeDePace(ItemDePace newItem) {
		myNext = null;
		myData = newItem;
	} // NodeDePace partial

	/**
	 * Getter for the next
	 * 
	 * @return The next Node
	 */
	public NodeDePace getNext() {
		return myNext;
	} // getNext

	/**
	 * Setter for the next Node
	 * 
	 * @param newNext The new Node
	 */
	public void setNext(NodeDePace newNext) {
		myNext = newNext;
	} // setNext

	/**
	 * Getter for the Item
	 * 
	 * @return The Item
	 */
	public ItemDePace getData() {
		return myData;
	} // getData

	/**
	 * Setter for the Item
	 * 
	 * @param newNext The new Item
	 */
	public void setData(ItemDePace newItem) {
		myData = newItem;
	} // setData

} // NodeDePace
