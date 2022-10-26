import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BasicDoubleLinkedList_STUDENT_Test {
	BasicDoubleLinkedList<Double> linkedDouble;
	DoubleComparator comparatorD;
	public ArrayList<Double> fill = new ArrayList<Double>();
	

	@Before
	public void setUp() throws Exception {
		
		
		linkedDouble = new BasicDoubleLinkedList<Double>();
		linkedDouble.addToEnd(15.0);
		linkedDouble.addToEnd(100.0);
		comparatorD = new DoubleComparator();
		
	}

	@After
	public void tearDown() throws Exception {
		linkedDouble = null;
		comparatorD = null;
	}

	@Test
	public void testGetSize() {
		assertEquals(2,linkedDouble.getSize());
	}
	
	@Test
	public void testAddToEnd() {
		linkedDouble.addToEnd(2.0);
		assertTrue(2.0 == linkedDouble.getLast());
	}
	
	@Test
	public void testAddToFront() {
		linkedDouble.addToFront(1.0);
		assertTrue(1.0 == linkedDouble.getFirst());
	}
	
	@Test
	public void testGetFirst() {
		assertTrue(15.0 == linkedDouble.getFirst());
	}

	@Test
	public void testGetLast() {
		
		linkedDouble.addToEnd(20.0);
		assertTrue(linkedDouble.getLast() == 20.0);
	}
	
	@Test
	public void testToArrayList()
	{
		ArrayList<Double> list;
		linkedDouble.addToFront(20.0);
		linkedDouble.addToEnd(30.0);
		list = linkedDouble.toArrayList();
		assertTrue(20.0 == linkedDouble.getFirst());
		assertTrue(30.0 == linkedDouble.getLast());
	}
	
	@Test
	public void testIteratorSuccessfulNext() {
		
		linkedDouble.addToFront(10.0);
		linkedDouble.addToEnd(35.0);
		ListIterator<Double> iterator = linkedDouble.iterator();
		assertTrue(10.0 == iterator.next());
		assertTrue(true == iterator.hasNext());
		assertTrue(15.0 == iterator.next());
		
	}
	
	@Test
	public void testIteratorSuccessfulPrevious() {

		linkedDouble.addToFront(10.0);
		linkedDouble.addToEnd(35.0);
		ListIterator<Double> iteratorCar = linkedDouble.iterator();
		assertTrue(10.0 == iteratorCar.next());
		assertTrue(15.0 == iteratorCar.next());
		assertTrue(100.0 == iteratorCar.next());
		assertTrue(35.0 == iteratorCar.next());
		assertTrue(true == iteratorCar.hasPrevious());
		assertTrue(35.0 == iteratorCar.previous());
		assertTrue(100.0 == iteratorCar.previous());
		assertTrue(15.0 == iteratorCar.previous());
	}
	
	@Test
	public void testIteratorNoSuchElementExceptionNext() {
		ListIterator<Double> iteratorCar = linkedDouble.iterator();
		assertEquals(true, iteratorCar.hasNext());
		assertTrue(15.0 == iteratorCar.next());
		assertTrue(100.0 == iteratorCar.next());
		
		try{
			//no more elements in list
			iteratorCar.next();
			assertTrue("Did not throw a NoSuchElementException",false);
		}
		catch (NoSuchElementException e)
		{
			assertTrue("Successfully threw a NoSuchElementException",true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the NoSuchElementException", false);
		}
		
	}
	
	@Test
	public void testIteratorNoSuchElementExceptionPrevious() {
		ListIterator<Double> iteratorCar = linkedDouble.iterator();
		assertEquals(true, iteratorCar.hasNext());
		assertTrue(15.0 == iteratorCar.next());
		assertTrue(100.0 == iteratorCar.next());
		assertTrue(100.0 == iteratorCar.previous());
		assertTrue(15.0 == iteratorCar.previous());
		
		try{
			//no more elements in list
			iteratorCar.previous();
			assertTrue("Did not throw a NoSuchElementException",false);
		}
		catch (NoSuchElementException e)
		{
			assertTrue("Successfully threw a NoSuchElementException",true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the NoSuchElementException", false);
		}
		
	}
	
	@Test
	public void testIteratorUnsupportedOperationException() {
		ListIterator<Double> iteratorCar = linkedDouble.iterator();
		
		try{
			//remove is not supported for the iterator
			iteratorCar.remove();
			assertTrue("Did not throw a UnsupportedOperationException",false);
		}
		catch (UnsupportedOperationException e)
		{
			assertTrue("Successfully threw a UnsupportedOperationException",true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the UnsupportedOperationException", false);
		}
		
	}
	
	@Test
	public void testRemove() {
		// remove the first
		
		linkedDouble.remove(15.0, comparatorD);
		assertTrue(100.0 == linkedDouble.getLast());
		
	}

	@Test
	public void testRetrieveFirstElement() {
		assertTrue(15.0 == linkedDouble.retrieveFirstElement());
	}

	@Test
	public void testRetrieveLastElement() {
		assertTrue(100.0 == linkedDouble.retrieveLastElement());
	}

	private class StringComparator implements Comparator<String>
	{

		@Override
		public int compare(String arg0, String arg1) {
			// TODO Auto-generated method stub
			return arg0.compareTo(arg1);
		}
		
	}
	
	private class DoubleComparator implements Comparator<Double>
	{

		@Override
		public int compare(Double arg0, Double arg1) {
			// TODO Auto-generated method stub
			return arg0.compareTo(arg1);
		}
		
	}
	
}