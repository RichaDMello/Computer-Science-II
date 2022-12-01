/**
 * @author Richa D'Mello
 */
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MorseCodeTreeTest_Student {
	MorseCodeTree tree = new MorseCodeTree();
	ArrayList<String> treeList = new ArrayList<>();

	@Test
	public void testinsert() {	
		MorseCodeConverter.tree.insert("..--", "?");
		MorseCodeConverter.tree.insert(".-.-", "!");
		String converter1 = MorseCodeConverter.convertToEnglish(".-.. --- .-.. / .-- .... .- - ..-- .-.-");
		assertEquals("lol what?!", converter1);
	}
	
	@Test
	public void testGetRoot() {	
		assertEquals("",MorseCodeConverter.tree.getRoot().getData());
	}
	
	@Test
	public void testSetRoot() {	
		TreeNode<String> root = new TreeNode<String>("yes");
		MorseCodeConverter.tree.setRoot(root);
		assertEquals("yes", MorseCodeConverter.tree.getRoot().getData());
	}
	
	@Test
	public void testFetch() {	
		String str = tree.fetch(".-..");
		assertEquals("l",str);
	}

	@Test
	public void testTree() {	
		String result = "";
		treeList = tree.toArrayList();
		for(int i = 0;i<tree.toArrayList().size();i++) {
			if(i != tree.toArrayList().size()-1)
				result += tree.toArrayList().get(i) + " ";
			else
				result += tree.toArrayList().get(i);
		}
		assertEquals("h s v i f u e l r a p w j  b d x n c k y t z g q m o", result);

	}
	
}
