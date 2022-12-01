 
import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.Test;


public class MorseCodeConverterTest_Student {
	
	@Test
	public void testConvertToEnglishString() {	
		String str = MorseCodeConverter.convertToEnglish(".-.. --- ...- . / .-.. --- --- -.- ... / -. --- - / .-- .. - .... / - .... . / . -.-- . ... / -... ..- - / .-- .. - .... / - .... . / -- .. -. -..");
		assertEquals("love looks not with the eyes but with the mind",str);
	}
	
	/**
	 * Testing for correct implementation of tree and traversal
	 */
	
	@Test
	public void testPrintTree() {	
		
		assertEquals("h s v i f u e l r a p w j  b d x n c k y t z g q m o", MorseCodeConverter.printTree());
	}
	
	/**
	 * Testing for correct conversion of all characters using key phrase to hit all letters
	 */
	
	@Test
	public void testConvertMorseStringToEnglishString() {	
		
		String str1 = MorseCodeConverter.convertToEnglish("- .... . / --.- ..- .. -.-. -.- / -... .-. --- .-- -. / ..-. --- -..- ");
		String str2 = MorseCodeConverter.convertToEnglish("/ .--- ..- -- .--. ... / --- ...- . .-. / - .... . / .-.. .- --.. -.-- / -.. --- --.");
		assertEquals("the quick brown fox", str1);
		assertEquals("jumps over the lazy dog", str2);

	}
	@Test
	public void testConvertMorseFileToEnglishString() {	
		
		File file = new File("src/daisy.txt"); 
		try {
			assertEquals("give me your answer do", MorseCodeConverter.convertToEnglish(file));
		} catch (FileNotFoundException e) {
			assertTrue("An unwanted exception was caught", false);
		}
	}
	

}
