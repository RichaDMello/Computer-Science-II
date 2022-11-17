
import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This is the test file for the CourseDBManager which is implemented from the
 * CourseDBManagerInterface
 * 
 */
public class CourseDBStructureTest_Student {
	CourseDBStructure cdStudent, testStructure;

	@Before
	public void setUp() throws Exception {
		cdStudent = new CourseDBStructure(30);
		testStructure = new CourseDBStructure("Testing", 35);
	}

	@After
	public void tearDown() throws Exception {
		cdStudent = testStructure = null;
	}

	/**
	 * Test the tableSize for CourseDBStructures constructed with both constructors
	 */
	@Test
	public void testGetTableSize() {
		assertEquals(23, cdStudent.getTableSize());
		assertEquals(35, testStructure.getTableSize());
	}

	@Test
	public void testHashTable() {

		//Create a course 
		CourseDBElement cde1 = new CourseDBElement("CMSC400", 34345, 4, "CS102", "Banana Man");
		
		cdStudent.add(cde1);  //add to data structure
		cdStudent.add(cde1);  // add it again. add method  should  ignore it
	 
		ArrayList<String> courseList = cdStudent.showAll(); 
		assertTrue(courseList.size()==1);  
		
 		try {
			assertEquals(34345, cdStudent.get(cde1.getCRN()).getCRN());  
		} catch (IOException e) {

			assertTrue("threw Exception successfuly for the course not found", true);
		}
		
 		courseList = cdStudent.showAll(); 
		assertTrue(courseList.size()==1);  
		
		
		testStructure.add(cde1); 
		courseList = testStructure.showAll(); 
		assertTrue(courseList.size()==1); 
	}
}
