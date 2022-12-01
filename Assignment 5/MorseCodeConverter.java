import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MorseCodeConverter {
	
	static MorseCodeTree tree = new MorseCodeTree();
	public MorseCodeConverter() {
		
	}
	/**
	 * returns all the letters in the tree following in-order traversal 
	 * @return string that contains the letters with a space between each letter
	 */
	public static String  printTree() {
		ArrayList<String> treeArray = tree.toArrayList();
		String result = "";
		
		for(String letter: treeArray)
		{
			result +=  (letter + " ");
		}
		
		return result.trim();
	}
	
	public static String convertToEnglish(String code) {
		String[] newCode= code.split(" / ");
		String result= "";
		String[] letterList;

		for (String letter: newCode) {
			letterList= letter.split(" ");

			for (String eachLetter: letterList)
				result += tree.fetch(eachLetter);

			result += " ";
		}
		return result.trim();
	}
	
	public  static String convertToEnglish(File codeFile) throws FileNotFoundException {
		Scanner input = new Scanner(codeFile);
		String result = "";
		
		while(input.hasNextLine()) 
			result += input.nextLine()+ "\n";
		
		input.close();
		result = result.trim();
		return convertToEnglish(result);
		
	}

}