public class ArraySum {
	
	public int sumOfArray (Integer[] a,int index)
	{
		//base case = when index = 0
		//original problem = a[index--]
		//reduced problem = sumOfArray(a, index)
		
		if (index < a.length && index > -1)
		{
			return a[index] + sumOfArray(a, --index);
		}
		else
		{
			return 0;
		}
	}
}

