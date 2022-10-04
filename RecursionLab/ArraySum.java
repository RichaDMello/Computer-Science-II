
public class ArraySum {
	
	public int sumOfArray (Integer[] a,int index)
	{
		//base case = when index = end of array or end of entries
		//original problem = a[index++]
		//reduced problem = sumOfArray(a, index)
		
		int Sum;
		
		if (index < a.length)
		{
			if (a[index] != null)
			{
				Sum = a[index++];
				return Sum + sumOfArray(a, index);
			}
			else
			{
				return 0;
			}
		}
		else
		{
			return 0;
		}
	}
}
