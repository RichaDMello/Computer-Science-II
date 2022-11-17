import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class CourseDBStructure implements CourseDBStructureInterface{
	
	private int tableSize ;
	private int size;
	LinkedList<CourseDBElement> [] hashTable; //= new LinkedList[tableSize];
	ArrayList<String> courseList;

	public static int fourKPlus3(int n, double loadfactor)
	{  boolean fkp3 = false;
	   boolean aPrime = false;
	   int prime, highDivisor, d;
	  

	   prime = (int)(n/loadfactor);
	   if(prime % 2 == 0) // if even make odd
	      prime = prime +1;

	   while(fkp3 == false) // not a 4k+3 prime
	   {  while(aPrime == false) // not a prime
	      {  highDivisor = (int)(Math.sqrt(prime) + 0.5);
	         for(d = highDivisor; d > 1; d--)
	         {  if(prime % d == 0)
	               break; // not a prime
	         }
	         if(d != 1) // prime not found
	            prime = prime + 2;
	         else
	            aPrime = true;
	      } // end of the prime search loop
	      if((prime - 3) % 4 == 0)
	         fkp3 = true;
	      else
	      {  prime = prime + 2;
	         aPrime = false;
	      }
	   } // end of 4k+3 prime search loop
	   return prime;
	}
	
	public CourseDBStructure(int n) {
		double loadFactor = 1.5;
		this.tableSize = fourKPlus3(n, loadFactor);
//		CourseDBElement [] hashTable= new CourseDBElement[i];

		this.courseList = new ArrayList<String>();
		this.hashTable = new LinkedList[tableSize];
		size = 0;
	}

	public CourseDBStructure(String string, int i) {
		this.tableSize = i;
		this.hashTable = new LinkedList[tableSize];
		this.courseList = new ArrayList<String>();
		size = 0;
	}


	public ArrayList<String> showAll() 
	{
		ArrayList<String> result = new ArrayList<String>();
		for (int i = 0; i < hashTable.length; i++)
		{
			if (hashTable[i] != null)
			{
				for (int k = 0; k < hashTable[i].size(); k++)
				{
					result.add(hashTable[i].get(k).toString());
				}
			}
		}
		return result;
	}

	@Override
	public void add(CourseDBElement cde1) {
		boolean thereIs = false;
		String crnTemp = "" + cde1.getCRN();
		int index = crnTemp.hashCode() % tableSize;
		
		if (hashTable[index] == null)
		{
			this.hashTable[index] = new LinkedList<CourseDBElement>();
			this.courseList.add(cde1.toString());
		}
		else
		{
			for (int i = 0; i < hashTable[index].size(); i++)
			{
				if (cde1.compareTo(hashTable[index].get(i)) == 0)
				{
					hashTable[index].set(i, cde1);
					thereIs = true;
					
				}
			}
		}
		if (!(thereIs))
		{
			hashTable[index].add(cde1);
			size++;
		}
	}

	
	@Override
	public CourseDBElement get(int crn) throws IOException {
		String CRN =  "" + crn;
		int index = CRN.hashCode() % tableSize;
		
		if (hashTable[index] != null)
		{
			for (int i = 0; i < hashTable[index].size(); i++) {
				if (hashTable[index].get(i).getCRN() == crn)
				{
					return hashTable[index].get(i);
				}
			}
		}
		throw new IOException();
	}

	@Override
	public int getTableSize() {
		return this.tableSize;
	}

}
