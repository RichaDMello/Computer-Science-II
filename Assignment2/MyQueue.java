import java.util.ArrayList;

/**
 * 
 * @author Richa D'Mello
 *
 * @param <T> Generic Data Structure
 */

public class MyQueue <T> implements QueueInterface<T>{

	private T [] queue;
	private int frontIndex;
	private int backIndex;
	private int maxSize;
	private final static int DEFAULT_SIZE = 50;
	private final static int MAX_SIZE = 1000;
	
	public MyQueue()
	{
		this(DEFAULT_SIZE);
	}
	
	public MyQueue(int size)
	{
		queue = (T[]) new Object[size];
		frontIndex = 0;
		backIndex = 0;
		maxSize = size;
	}
	
	/**
	 * Checks if the queue is empty.
	 */
	@Override
	public boolean isEmpty() {
		return (queue[frontIndex] == null);
	}

	/**
	 * Checks if the queue is full.
	 */
	@Override
	public boolean isFull() {
		for (int i = 0; i<maxSize; i++)
		{
			if (queue[i] == null)
			{
				return false;
			}
		}
		return true;
	}

	/**
	 * Removes an element from the front of the queue.
	 */
	@Override
	public T dequeue() throws QueueUnderflowException {
		T temp = null;
		if(isEmpty())
		{
			throw new QueueUnderflowException();
		}
		else
		{
			temp = queue[frontIndex];
			queue[frontIndex] = null;
			frontIndex = (frontIndex + 1) % queue.length;
			return temp;
		}
	}

	/**
	 * Finds the size of the queue.
	 */
	@Override
	public int size() {
		return (backIndex - frontIndex);
	}

	/**
	 * Adds an element to the end of the queue
	 */
	@Override
	public boolean enqueue(T e) throws QueueOverflowException {
		if (isFull())
		{
			throw new QueueOverflowException();
		}
		queue[backIndex] = (T) e;
		backIndex = (backIndex + 1) % queue.length;
		return true;
	}

	/**
	 * Converts the generic data type to string format
	 */
	@Override
	public String toString() {
		String result = "";
		for (int i = frontIndex; i < backIndex; i++)
		{
			if (i < queue.length)
			{
				result += queue[i];
			}
			else
			{
				i = (i+1) % queue.length;
			}
		}
		return result;
	}
	
	/**
	 * Converts the generic data structure to a string with a delimiter separating each element.
	 */
	@Override
	public String toString(String delimiter) {
		String result = "";
		for (int i = frontIndex; i < backIndex; i++)
		{
			if (i < queue.length)
			{
				result += queue[i];
				if (i < backIndex -1)
				{
					result += delimiter;
					System.out.println(result);
				}
				else
				{
					i = (i+1)%queue.length;
				}
			}
		}
		return result;
		
	}

	/**
	 * Fills an arraylist with values from the queue.
	 */
	@Override
	public void fill(ArrayList<T> list) {
		for (int i = 0; i < list.size(); i++)
		{
			enqueue(list.get(i));
		}
	}
	

}
