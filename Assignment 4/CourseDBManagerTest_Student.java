/**
 * @author Richa D'Mello
 */

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This is the test file for the CourseDBManager
 * which is implemented from the CourseDBManagerInterface
 * done by student
 */
public class CourseDBManagerTest_Student {
	private CourseDBManagerInterface Manager = new CourseDBManager();

	/**
	 * Create an instance of CourseDBManager
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		Manager = new CourseDBManager();
	}

	/**
	 * Set dataMgr reference to null
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		Manager = null;
	}

	/**
	 * Test for the add method
	 */
	@Test
	public void testAddToDB() {
		try {
			Manager.add("CMSC203",34567,4,"SC301","Banana Man");
		}
		catch(Exception e) {
			fail("This should not have caused an Exception");
		}
	}
	
	/**
	 * Test for the showAll method
	 */
	@Test
	public void testShowAll() {
		Manager.add("CMSC203",34567,4,"SC301","Banana Man");
		
		ArrayList<String> list = Manager.showAll();
		
		assertEquals(list.get(0),"Course:CMSC203 CRN:34567 Credits:4 Instructor:Banana Man Room:SC301");
	}
	
	/**
	 * Test for the read method
	 */
	@Test
	public void testRead() {
		try {
			File inputFile = new File("StudentTest.txt");
			PrintWriter file = new PrintWriter(inputFile);
			file.println("CMSC203 34567 4 SC301 Banana Man");
			
			file.close();
			Manager.readFile(inputFile);
			assertEquals("CMSC203",Manager.get(34567).getID());
			assertEquals("SC301",Manager.get(34567).getRoomNum());
		} catch (Exception e) {
			fail("Should not have thrown an exception");
		}
	}
}
