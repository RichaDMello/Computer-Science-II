/**
 * @author Richa D'Mello
 */

import java.util.ArrayList;

public class MorseCodeTree implements LinkedConverterTreeInterface<String>  {

	private TreeNode<String> root;
	
	/**
	 * Constructor creates a new TreeNode
	 */
	public MorseCodeTree() {
		root = new TreeNode<String>("");
		buildTree();
	}
	
	/**
	 * Compares the code and adds it to the tree 
	 * 
	 * @param code
	 * @param result
	 */
	@Override
	public void insert(String code, String result) {
		addNode(root, code, result);
	}
	
	/**
	 * Returns a reference to the root
	 */
	public TreeNode <String> getRoot(){
		return root;
	}
	
	/**
	 * sets the root of the tree
	 */
	public void setRoot(TreeNode<String> newNode) {
		this.root = newNode;
	}
	
	

	/**
	 * This method is called by insert and it adds code to the tree by comparing it by letter
	 */
	public void addNode(TreeNode<String> root, String code, String letter) {
		
		TreeNode<String> root1 = root;
		if (code.length() == 1)
		{
			if (code.equals("."))
			{
				root1.left = new TreeNode<String>(letter);
			}
			else if (code.equals("-"))
			{
				root1.right = new TreeNode<String>(letter);
			}
		}
		
		else
		{
			if (code.charAt(0) == '.')
			{
				root1 = root.left;
			}
			if (code.charAt(0) == '-')
			{
				root1 = root.right;
			}
			
			addNode(root1, code.substring(1), letter);
		}
	}
		
	
	/**
	 * Gets the data from the tree. It calls the fetchNode method.
	 */
	@Override
	public String fetch(String code) {
		return fetchNode(getRoot(), code); 

	}


	/**
	 * This function fetches letters from the tree by traversing it. the dots go to the left and the dashes go to the right
	 * 
	 */
	public String fetchNode(TreeNode<String> root, String code) {
		TreeNode<String> node = root;
		String letter = "";
		
		if (code.length()==1) {
			if (code.equals(".")){
				letter = node.left.getData();
			}
			 if(code.equals("-")) {
				 letter = node.right.getData();
				}
			return letter;
		}
		else {
			if (code.charAt(0) == '.') 
			{
				node = node.left;
			}
			else if (code.charAt(0) == '-') 
			{
				node = node.right;
				
			}
		}
		return fetchNode(node, code.substring(1));
	}
	
	/**
	 * Method to build the tree.
	 */
	@Override
	public void buildTree() {
			insert(".", "e");
	        insert("-", "t");
	        insert("..", "i");
	        insert(".-", "a");
	        insert("-.", "n");
	        insert("--", "m");
	        insert("...", "s");
	        insert("..-", "u");
	        insert(".-.", "r");
	        insert(".--", "w");
	        insert("-..", "d");
	        insert("-.-", "k");
	        insert("--.", "g");
	        insert("---", "o");
	        insert("....", "h");
	        insert("...-", "v");
	        insert("..-.", "f");
	        insert(".-..", "l");
	        insert(".--.", "p");
	        insert(".---", "j");
	        insert("-...", "b");
	        insert("-..-", "x");
	        insert("-.-.", "c");
	        insert("-.--", "y");
	        insert("--..", "z");
	        insert("--.-", "q");
	}

	
	/**
	 * Returns an ArrayList of the items in the linked Tree in LNR (Inorder) Traversal order Used for testing to make sure tree is built correctly
	 */
	@Override
	public ArrayList<String> toArrayList() {

		ArrayList<String> morseList = new ArrayList<>(); 
		
		LNRoutputTraversal(getRoot(), morseList); 
		
		return morseList; 
	}
	

	/**
	 * The recursive method to put the contents of the tree in an ArrayList in LNR (Inorder)
	 * @param root
	 * @param list
	 */
	@Override
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
	
		if (root.left != null)
		{
			LNRoutputTraversal(root.left, list);
		}
		
		list.add(root.getData());
		
		if (root.right != null)
		{
			LNRoutputTraversal(root.right, list);
		}
		
	}
	
	
	/**
	 * This operation is not supported in the MorseCodeTree
	 */
	public MorseCodeTree delete(String data) throws UnsupportedOperationException{
		
		throw new UnsupportedOperationException();
	}
	
	
	/**
	 * This operation is not supported in the MorseCodeTree
	 */
	@Override
	public MorseCodeTree update() throws UnsupportedOperationException {
		throw new UnsupportedOperationException();	
		}

}