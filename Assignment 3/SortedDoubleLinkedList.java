import java.util.Comparator;
import java.util.ListIterator;
import java.lang.UnsupportedOperationException;

/**
 * 
 * @author Richa D'Mello
 *
 * @param <T>
 */
public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList{
	
	Comparator compare;

	/**
	 * Constructor that creates the SortedDoubleLinkedList
	 * @param comparator The Comparator object that can compare the generic data types that can be added to the list
	 */
	public SortedDoubleLinkedList(Comparator comparator)
	{
		compare = comparator;
	}

	/**
	 * Method to get an iterator object to traverse the sorted linked list
	 * @param compare Comparator object that can compare generic data types
	 * @return Returns an iterator object that can traverse the list
	 */
	public ListIterator<T> iterator(Comparator <T> compare)
	{
		return super.iterator();
	}

	/**
	 * Adds an element in the correct position in the sorted list
	 * @param data Data to be added to the sorted list 
	 */
	public void add(T data)
	{
		Node thisNode = head;
		Node newNode = new Node(data);
		if (head == null)
		{
			head = tail = newNode;
		}
		else if (compare.compare( head.data, newNode.data) >= 0)
		{
			head.prev = newNode;
			newNode.next = head;
			newNode.prev = null;
			head = newNode;
		}
		else if (compare.compare(tail.data, newNode.data) < 0)
		{
			tail.next = newNode;
			newNode.prev = tail;
			newNode.next = null;
			tail = newNode;
		}
		else
		{
			while (compare.compare(newNode.data, thisNode.data) >= 0)
			{
				thisNode = thisNode.next;
			}
			thisNode.prev.next = newNode;
			newNode.prev = thisNode.prev;
			newNode.next = thisNode;
			thisNode.prev = newNode;
		}
		size++;
	}
	

	/**
	 * Method to remove a node containing the specific data entered into the parameter
	 * @param targetData data to be found and removed from the list
	 * @param comparator Comparator object that can compare generic data types
	 * @return Returns the node containing the data to be removed
	 */
	public Node remove(T targetData, Comparator <T> comparator)
	{
		return super.remove(targetData, comparator);
	}
	

	/**
	 * Method is unsupported in the sorted list since it will not ensure that the list remains sorted
	 * @param data 
	 * @throws UnsupportedOperationException
	 */
	public void addToFront(T data) throws UnsupportedOperationException
	{
		throw new UnsupportedOperationException();
	}
	

	/**
	 * Method is unsupported in the sorted list since it will not ensure that the list remains sorted
	 * @param data
	 * @throws UnsupportedOperationException
	 */
	public void addToEnd(T data) throws UnsupportedOperationException
	{
		throw new UnsupportedOperationException();
	}
	
	

}
