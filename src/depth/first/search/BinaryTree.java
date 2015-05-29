package depth.first.search;

public class BinaryTree {
	
	BinaryNode root;

	public BinaryTree() {
		root = new BinaryNode();
	}

	public void constructTree() {
		BinaryNode leftChild = new BinaryNode();
		BinaryNode rightChild = new BinaryNode();
		root.left = leftChild;
		root.right = rightChild;
		
		BinaryNode leftChild1 = new BinaryNode();
		BinaryNode rightChild1 = new BinaryNode();
		leftChild.left = leftChild1;
		leftChild.right = rightChild1;
		
	}
	
	

}
