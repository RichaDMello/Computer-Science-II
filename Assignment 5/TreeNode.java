/**
 * @author Richa D'Mello
 */

public class TreeNode<T> {

	private T data;
	protected TreeNode<T> left, right;

	/**
	 * Create a new TreeNode with left and right child set to null and data set to the dataNode
	 * @param dataNode
	 */
	public TreeNode(T dataNode){
		this.left = null;
		this.right = null;
		this.data = dataNode;
	}
	

	/**
	 * used for making deep copies
	 * @param node
	 */
	public TreeNode(TreeNode<T> node){
		
		this.left = node.left;
		this.right = node.right;
		this.data = node.getData();
	}
	
	/**
	 * Return the data within this TreeNode
	 * @return
	 */
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	public TreeNode<T> getLeftChild() {
		return left;
	}


	public void setLeftChild(TreeNode<T> leftChild) {
		this.left = leftChild;
	}


	public TreeNode<T> getRightChild() {
		return right;
	}


	public void setRightChild(TreeNode<T> rightChild) {
		this.right = rightChild;
	}

}