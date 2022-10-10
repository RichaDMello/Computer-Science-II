/**
 * @author Richa D'Mello
 */
import java.util.ArrayList;

public class MyStack<T> implements StackInterface<T>{
	
	private T[] stack;
	private boolean IntegrityOK = false;
	private int topIndex;
	private static final int DEFAULT_CAPACITY = 50;

	public MyStack()
	{
		this(DEFAULT_CAPACITY);
	}
	
	public MyStack(int initialCapacity) {
		
		IntegrityOK = false;
		T[] tempStack = (T[]) new Object[initialCapacity];
		stack = tempStack;
		topIndex = -1;
		IntegrityOK = true;
	}
	
	@Override
	public boolean isEmpty() {
		if (topIndex == -1)
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean isFull(){
		if (topIndex+1 == stack.length)
		{
			return true;
//			throw new StackOverflowException();
		}
		return false;
	}

	@Override
	public T pop() throws StackUnderflowException {
		if (!isEmpty())
		{
			T top = stack[topIndex];
			stack[topIndex] = null;
			topIndex--;
			return top;
		}
		else
			throw new StackUnderflowException();
	}

	@Override
	public T top() throws StackUnderflowException {
		if (isEmpty())
		{
			throw new StackUnderflowException();
		}
		else
		{
			return stack[topIndex];
		}
	}

	@Override
	public int size() {
		return topIndex + 1;
	}

	@Override
	public boolean push(T e) throws StackOverflowException{
		if (isFull())
		{
			throw new StackOverflowException();
		}
		else
		{
			stack[++topIndex] = e;
			return true;
		}
	}

	@Override
	public String toString(String delimiter) {
		String result = "";
		if (this.isEmpty())
		{
			return result;
		}
		else
		{
			for (int i = 0; i < topIndex; i++)
			{
				result += stack[i].toString() + delimiter;
//				System.out.println(result);
			}
			result += stack[topIndex];
			return result;
		}
		
	}
	
	@Override
	public String toString()
	{
		String result = "";
		if (this.isEmpty())
		{
			return result;
		}
		else
		{
			for (int i = 0; i < topIndex; i++)
			{
				result += stack[i].toString();
//				System.out.println(result);
			}
			result += stack[topIndex];
			return result;
		}
	}

	@Override
	public void fill(ArrayList<T> list) {
		for (int i = 0; i < list.size(); i++)
		{
			push(list.get(i));
		}
	}

}
