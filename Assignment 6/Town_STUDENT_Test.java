/**
 * @author Richa D'Mello
 */
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Town_STUDENT_Test {
	Town isa,goa;

	@Before
	public void setUp() throws Exception {
		isa = new Town("IsaTown");
		goa = new Town("India");
	}

	@After
	public void tearDown() throws Exception {
		isa = null;
		goa = null;
	}


	@Test
	public void testCompareTo() {
		assertTrue(0==isa.compareTo(isa));
		assertTrue(0<isa.compareTo(goa));
	}

	@Test
	public void testEqualsTown() {
		assertTrue(!isa.equals(goa));
		assertTrue(isa.equals(new Town("IsaTown")));
	}

	@Test
	public void testGetName() {
		assertEquals("IsaTown",isa.getName());
		assertEquals("India",goa.getName());
	}

	@Test
	public void testToString() {
		assertEquals("IsaTown",isa.toString());
		assertEquals("India",goa.toString());
	}

}