package max.depth.recursive;

public class BinaryTree {
	
	Node root;

	public BinaryTree() {
		root = new Node(false);
	}

	public void constructTree() {
		Node leftChild = new Node(false);
		Node rightChild = new Node(false);
		root.left = leftChild;
		root.right = rightChild;
		
		Node leftChild1 = new Node(false);
		Node rightChild1 = new Node(false);
		leftChild.left = leftChild1;
		leftChild.right = rightChild1;
		
	}
	
	

}
