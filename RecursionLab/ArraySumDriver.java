public class ArraySumDriver {
	private final static int ARRAY_SIZE = 6;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int index = 0;

		Integer[] myArray = new Integer[ARRAY_SIZE];
		ArraySum arraySum = new ArraySum();
		
		myArray[index++] = 3; //index = 0
		myArray[index++] = 5; //index = 1
		myArray[index++] = 2; //index = 2
		myArray[index++] = 6; //index = 3
		
		int sum = arraySum.sumOfArray(myArray, 3);
		System.out.println(sum);
		
		myArray[index++] = 7; //index = 4
		myArray[index++] = 1; //index = 5
		
		sum = arraySum.sumOfArray(myArray, 5);
		System.out.println(sum);
	}

}