
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * STUDENT tests for the methods of PasswordChecker
 * @author Richa D'Mello
 *
 */
public class PasswordCheckerTest_STUDENT {
	ArrayList<String> passwords;
	String password1, password2, password3, password4;

	@Before
	public void setUp() throws Exception {
		passwords = new ArrayList<String>();
		passwords.add("hifive5");
		passwords.add("Qwerty!");
		passwords.add("CMsccc204@");
		password1 = "Yellow8*";
		password2 = "Green3";
		password3 = "124822A";
		password4 = "Ab2#";
		
	}

	@After
	public void tearDown() throws Exception {
		passwords = null;
		password1 = null;
		password2 = null;
		password3 = null;
		password4 = null;
	
	}

	/**
	 * Test if the password is less than 6 characters long.
	 * This test should throw a LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort()
	{
		try
		{
			assertTrue(PasswordCheckerUtility.isValidPassword(password1));
			assertTrue(PasswordCheckerUtility.isValidPassword(password2));
		}
		catch (Exception e)
		{
			assertTrue(e.getMessage().equals("The password must contain at least one special character"));
		}
		
	}
	/**
	 * Test if the password has at least one uppercase alpha character
	 * This test should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha()
	{
//		fail("Not implemented by student yet");
		try
		{
			assertEquals(PasswordCheckerUtility.isValidPassword(passwords.get(0)),false);
		}
		catch (Exception e)
		{
			assertTrue(e.getMessage().equals("The password must contain at least one uppercase alphabetic character"));
		}
	}
	
	/**
	 * Test if the password has at least one lowercase alpha character
	 * This test should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha()
	{
//		fail("Not implemented by student yet");
		try {
			assertEquals(PasswordCheckerUtility.isValidPassword(password3),false);
		}
		catch (Exception e)
		{
			assertTrue(e.getMessage().equals("The password must contain at least one lowercase alphabetic character"));
		}
	}
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsWeakPassword()
	{
//		fail("Not implemented by student yet");
		try 
		{
			assertTrue(PasswordCheckerUtility.isWeakPassword(password4) == false);
		}
		catch (Exception e)
		{
			assertEquals(e.getMessage(), "The password is OK but weak - it contains fewer than 10 characters.");
		}
		
	}
	
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence()
	{
//		fail("Not implemented by student yet");
		try{
			assertEquals(true,PasswordCheckerUtility.isValidPassword(passwords.get(2)));
		 	assertTrue("Did not throw an InvalidSequenceException",false);
		}
		catch(Exception e)
		{
			assertEquals(e.getMessage(), "The password cannot contain more than two of the same character in sequence.");
		}
	}
	
	/**
	 * Test if the password has at least one digit
	 * One test should throw a NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit()
	{
//		fail("Not implemented by student yet");
		try
		{
			assertTrue(PasswordCheckerUtility.isValidPassword(passwords.get(1)) == false);
		}
		catch (Exception e)
		{
			assertEquals(e.getMessage(), "The password must contain at least one digit");
		}
	}
	
	/**
	 * Test correct passwords
	 * This test should not throw an exception
	 */
	@Test
	public void testIsValidPasswordSuccessful()
	{
//		fail("Not implemented by student yet");
		try
		{
			assertEquals(PasswordCheckerUtility.isValidPassword(password1), true);
			assertEquals(PasswordCheckerUtility.isValidPassword(passwords.get(2)), true);
		}
		catch (Exception e)
		{
			
		}
	}
	
	/**
	 * Test the invalidPasswords method
	 * Check the results of the ArrayList of Strings returned by the validPasswords method
	 */
	@Test
	public void testInvalidPasswords() {
//		fail("Not implemented by student yet");
		ArrayList<String> results;
		results = PasswordCheckerUtility.getInvalidPasswords(passwords);
		
		Scanner scan = new Scanner(results.get(0)); 
		assertEquals(scan.next(), "hifive5");
		String nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("uppercase"));
		 
		scan = new Scanner(results.get(1));
		assertEquals(scan.next(), "Qwerty!");
		nextResults = scan.nextLine().toLowerCase(); 
		assertTrue(nextResults.contains("digit"));
		
		scan = new Scanner(results.get(2));
		assertTrue(scan.next().equals("CMsccc204@"));
		nextResults = scan.nextLine().toLowerCase();
		assertEquals(nextResults.contains("sequence"), true);
		
	}
	
}
