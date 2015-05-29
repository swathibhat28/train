package trees;

public class BinaryTree {
	
	Node root;

	public BinaryTree() {
		root = new Node(1);
	}

	public void constructTree() {
		Node leftChild = new Node(2);
		Node rightChild = new Node(3);
		root.left = leftChild;
		root.right = rightChild;
		
		Node leftChild1 = new Node(4);
		Node rightChild1 = new Node(5);
		leftChild.left = leftChild1;
		leftChild.right = rightChild1;
		
		Node leftChild2 = new Node(6);
		Node rightChild2 = new Node(7);
		leftChild1.left = leftChild2;
		leftChild1.right = rightChild2;
		
		Node leftChild3 = new Node(8);
		Node rightChild3 = new Node(9);
		leftChild2.left = leftChild3;
		leftChild2.right = rightChild3;
		
		Node leftChild4 = new Node(10);
		Node rightChild4 = new Node(11);
		leftChild3.left = leftChild4;
		leftChild3.right = rightChild4;
	}
	
	

}
