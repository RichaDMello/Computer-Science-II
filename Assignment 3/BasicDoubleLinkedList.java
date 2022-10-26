import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * 
 * @author richadmello
 *
 * @param <T>
 */
public class BasicDoubleLinkedList<T> implements Iterable<T>{

	protected Node <T> head;
	protected Node <T> tail;
	protected int size;

	/**
	 * The Constructor of the BasicDoubleLinkedList class
	 */
	public BasicDoubleLinkedList()
	{
		this.head = null;
		this.tail = null;
		this.size = 0;
	}
	
	/**
	 * Method to find the size of the list
	 * @return The size of the list
	 */
	public int getSize()
	{
		return this.size;
	}
	
	/**
	 * The method adds an element to the end of the list
	 * @param data Data to be added to the list
	 */
	public void addToEnd(T data)
	{
		Node newNode = new Node(data);
		if (isEmpty())
		{
			head = newNode;
		}
		else
		{
			tail.next = newNode;
			newNode.prev = tail;
		}
		tail = newNode;
//		tail.next = null;
		size++;
	}

	/**
	 * Checks if the list is empty
	 * @return true if the list is empty
	 */
	public boolean isEmpty()
	{
		return size == 0 && head == null;
	}

	/**
	 * Adds to an element to the front of the list
	 * @param data the data to be added to the list
	 */
	public void addToFront(T data)
	{
		Node newNode = new Node(data); //creating a node for the data
		if (isEmpty())
		{
			head = newNode;
			tail = newNode;
		}
		else
		{
			head.prev = newNode;
			newNode.next = head;
		}
		head = newNode;
		head.prev = null;
		size++;
	}

	/**
	 * Inner class Node
	 * @author Richa D'Mello
	 *
	 * @param <T>
	 */
	protected class Node<T>
	{
		protected T data = null;
		protected Node prev = null;
		protected Node next = null;

		/**
		 * Constructor of the Node class
		 * @param dataNode the data to be added to the node
		 */
		Node(T dataNode)
		{
			this.data = dataNode;
			prev = null;
			next = null;
		}
	}

	/**
	 * Inner Class DoubleLinkedListIterator
	 * @author Richa D'Mello
	 *
	 * @param <T>
	 */
	protected class DoubleLinkedListIterator<T> implements ListIterator
	{
		
		protected Node cursor;
		protected Node back;
		protected int count;

		/**
		 * Constructor that creates an instace of the the DoubleLinkedListIterator class
		 */
		public DoubleLinkedListIterator()
		{
			cursor = head;
			back = null;
			count = 0;
		}

		/**
		 * Method to check if the list has another element after the cursor
		 */
		@Override
		public boolean hasNext() {
			if (cursor.next.data != null)
			{
				return true;
			}
			return false;
		}

		/**
		 * Method to return the next element in the list
		 */
		@Override
		public T next() throws NoSuchElementException {
			if (count == size)
			{
				throw new NoSuchElementException();
			}
			else if (count == 0)
			{
				count++;
				return (T) cursor.data;
			}
			else
			{
				back = cursor;
				cursor = back.next;
				count++;
				return (T) cursor.data;
			}
		}

		/**
		 * Method to check if the list has an element before the cursor
		 */
		@Override
		public boolean hasPrevious() {
			if (cursor.prev.data != null)
			{
				return true;
			}
			return false;
		}

		/**
		 * Method to return the previous element in the list
		 */
		@Override
		public T previous() throws NoSuchElementException{
			if (count == 0)
			{
				throw new NoSuchElementException();
			}
			else
			{
				back = cursor;
				cursor = cursor.prev;
				count--;
				return (T) back.data;
			}
		}

		/**
		 * 
		 */
		@Override
		public int nextIndex() throws UnsupportedOperationException{
throw new UnsupportedOperationException();
 	    }


		/**
		 * 
		 */
		@Override
		public int previousIndex() throws UnsupportedOperationException{
throw new UnsupportedOperationException();
 	    }


		/**
		 * 
		 */
		@Override
		public void remove() throws UnsupportedOperationException{
throw new UnsupportedOperationException();
 	    }


		/**
		 * 
		 */
		@Override
		public void set(Object e) throws UnsupportedOperationException{
throw new UnsupportedOperationException();
 	    }


		/**
		 * 
		 */
		@Override
		public void add(Object e) throws UnsupportedOperationException{
throw new UnsupportedOperationException();
 	    }

		
	}

	/**
	 * Method to get the first element in the list
	 * @return Returns the first element in the list if there is one.
	 */
	public T getFirst()
	{
		if (isEmpty())
		{
			return null;
		}
		return (T) head.data;
	}

	/**
	 * Method to get the last element in the list
	 * @return Returns the last element in the list if it exists.
	 */
	public T getLast()
	{
		if (isEmpty())
		{
			return null;
		}
		return (T) tail.data;
	}

	/**
	 * Method to return an arryalist of all the data in the list
	 * @return An arrayList of the data in each node of the list
	 */
	public ArrayList<T> toArrayList()
	{
		ArrayList <T> newList = new ArrayList<T>();
		Node temp = head;
		while (temp!=null)
		{
			newList.add((T) temp.data);
			temp = temp.next;
		}
		return newList;
	}

	/**
	 * Method that creates an iterator object that can traverse a list.
	 */
	@Override
	public ListIterator<T> iterator() {
		return new DoubleLinkedListIterator<T>();
	}

	/**
	 * Method to get the last element in the list and delete it from the list
	 * @return Returns the last element in the list and deletes it at the same time.
	 */
	public T retrieveLastElement()
	{
		if (isEmpty())
		{
			return null;
		}
		T temp = tail.data;
		tail = tail.prev;
		tail.next = null;
		size--;
		return temp;
	}

	/**
	 * Method to get the first element in the list and delete it from the list
	 * @return Returns the first element in the list and deletes it from the list
	 */
	public T retrieveFirstElement()
	{
		if (isEmpty())
		{
			return null;
		}
		T temp = head.data;
		head = head.next;
		size--;
		head.prev = null;
		return temp;
	}

	/**
	 * Method to remove the node containing a specific target data from the list
	 * @param targetData Data to be removed to the node
	 * @param comparator Comparator object that compares the data in the list
	 * @return Returns the node containing the specified data in the list
	 */
	public Node <T> remove(T targetData, Comparator <T> comparator)
	{
		Node <T> temp = head;
		while(temp!=null)
		{
			if (comparator.compare(targetData, temp.data)==0)
			{
				if (temp == head)
				{
					head = head.next;
				}
				else if (temp == tail)
				{
					tail = tail.prev;
					
				}
				else
				{
					temp.prev.next = temp.next;
					temp.next.prev = temp.prev;
				}
				size--;
				return temp;
			}
			temp = temp.next;
		}
		return null;
	}

}
