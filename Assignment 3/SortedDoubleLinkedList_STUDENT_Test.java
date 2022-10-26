import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SortedDoubleLinkedList_STUDENT_Test {

	SortedDoubleLinkedList<Double> sortedLinkedDouble;

	DoubleComparator comparatorD;
	
	@Before
	public void setUp() throws Exception {
		
		comparatorD = new DoubleComparator();
		sortedLinkedDouble = new SortedDoubleLinkedList<Double>(comparatorD);
		sortedLinkedDouble.add(30.0);
		sortedLinkedDouble.add(40.0);
		sortedLinkedDouble.add(15.0);
		
	}

	@After
	public void tearDown() throws Exception {
		comparatorD = null;
		sortedLinkedDouble = null;
		}

	@Test
	public void testAddToEnd() {
		try {
			sortedLinkedDouble.addToEnd(20.0);
			assertTrue("Did not throw an UnsupportedOperationException", false);
		}
		catch (UnsupportedOperationException e)
		{
			assertTrue("Successfully threw an UnsupportedOperationException", true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the UnsupportedOperationException", false);
		}
	}

	@Test
	public void testAddToFront() {
		try {
			sortedLinkedDouble.addToFront(10.0);
			assertTrue("Did not throw an UnsupportedOperationException", false);
		}
		catch (UnsupportedOperationException e)
		{
			assertTrue("Successfully threw an UnsupportedOperationException", true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the UnsupportedOperationException", false);
		}
	}

	@Test
	public void testIteratorSuccessfulNext() {
		sortedLinkedDouble.add(20.0);
		ListIterator<Double> iterator = sortedLinkedDouble.iterator();
		assertEquals(true, iterator.hasNext());
		assertTrue(15.0 == iterator.next());
		assertTrue(20.0 == iterator.next());
		assertTrue(30.0 == iterator.next());
		assertEquals(true, iterator.hasNext());
	}

	@Test
	public void testIteratorSuccessfulDoublePrevious() {
		ListIterator<Double> iterator = sortedLinkedDouble.iterator();
		assertEquals(true, iterator.hasNext());
		assertTrue(15.0 == iterator.next());
		assertTrue(30.0 == iterator.next());
		assertTrue(40.0 == iterator.next());
		assertEquals(true, iterator.hasPrevious());
		assertTrue(40.0 == iterator.previous());
		assertTrue(30.0 == iterator.previous());
		assertTrue(15.0 == iterator.previous());
	}
	
	@Test
	public void testIteratorSuccessfulDoubleNext() {
		sortedLinkedDouble.add(new Double(20.0));
		ListIterator<Double> iterator = sortedLinkedDouble.iterator();
		assertEquals(true, iterator.hasNext());
		assertTrue(15.0 == iterator.next());
		assertTrue(20.0 == iterator.next());
		assertTrue(30.0 == iterator.next());
		assertEquals(true, iterator.hasNext());
	}
	
	
	@Test
	public void testIteratorNoSuchElementException() {
		ListIterator<Double> iterator = sortedLinkedDouble.iterator();
		assertEquals(true, iterator.hasNext());
		assertTrue(15.0 == iterator.next());
		assertTrue(30.0 == iterator.next());
		assertTrue(40.0 == iterator.next());
		
		try{
			//no more elements in list
			iterator.next();
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
	public void testIteratorUnsupportedOperationExceptionDouble() {
		ListIterator<Double> iterator = sortedLinkedDouble.iterator();
		assertEquals(true, iterator.hasNext());
		assertTrue(15.0 == iterator.next());
		assertTrue(30.0 == iterator.next());
		assertTrue(40.0 == iterator.next());
		try{
			//remove is not supported for the iterator
			iterator.remove();
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
	public void testAddDouble() {
		
		sortedLinkedDouble.add(20.0);
		assertTrue((double) sortedLinkedDouble.getFirst() == 15.0);
		assertTrue((double) sortedLinkedDouble.getLast() == 40.0);
		
	}

	@Test
	public void testRemoveFirstDouble() {
		
		sortedLinkedDouble.remove(15.0, comparatorD);
		assertTrue((double) sortedLinkedDouble.getFirst() == 30.0);
	}
	
	@Test
	public void testRemoveEndDouble() {
		sortedLinkedDouble.remove(40.0, comparatorD);
		assertTrue((double) sortedLinkedDouble.getLast() == 30.0);
	}

	@Test
	public void testRemoveMiddleDouble() {
		sortedLinkedDouble.remove(30.0, comparatorD);
		ListIterator<Double> iterator = sortedLinkedDouble.iterator();
		assertTrue(15.0 == iterator.next());
		assertTrue(40.0 == iterator.next());
		assertTrue(sortedLinkedDouble.getSize() == 2);
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
