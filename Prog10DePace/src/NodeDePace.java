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
	private PokemonCardDePace myData;

	/**
	 * Constructs a Node
	 */
	public NodeDePace() {
		myNext = null;
		myData = null;
	} // NodeDePace default

	/**
	 * Constructs a Node with a Card
	 * 
	 * @param newCard The Card
	 */
	public NodeDePace(PokemonCardDePace newCard) {
		myNext = null;
		myData = newCard;
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
	 * Getter for the Card
	 * 
	 * @return The Card
	 */
	public PokemonCardDePace getData() {
		return myData;
	} // getData

	/**
	 * Setter for the Card
	 * 
	 * @param newCard The new Card
	 */
	public void setData(PokemonCardDePace newCard) {
		myData = newCard;
	} // setData
	

} // NodeDePace
