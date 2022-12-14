/**
 * @author Richa D'Mello
 */
import static org.junit.Assert.assertEquals;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

 class Road_STUDENT_Test {
	Road road;
	Town T1;
	Town T2;
	
	@Before
	public void setUp() throws Exception {
		T1 = new Town("Town_1");
		T2 = new Town("Town_2");
		road = new Road(T1, T2, 400, "North Freeway");
	}

	@After
	public void tearDown() throws Exception {
		T1 = null;
		T2 = null;
		road = null;
	}	
	
	@Test
	public void testContains() {
		assertEquals(true, road.contains(T1));
	}
	
	@Test
	public void testGetName() {
		assertEquals("North Freeway", road.getName());
	}
	
	@Test
	public void testGetDestination() {
		assertEquals(T2, road.getDestination());
	}
	
	@Test
	public void testGetSource() {
		assertEquals(T1, road.getSource());
	}
	
	@Test
	public void testGetWeight() {
		assertEquals(400, road.getWeight());
	}
	
	@Test
	public void testToString() {
		assertEquals("Town_1 to Town_2 via North Freeway", road.toString());
	}

}