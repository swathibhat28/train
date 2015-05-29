package binary.search.tree;

public class BST {
	private static Node root;
	
	public BST(Node root){
		this.root = root;
	}
	
	public static void main(String []args){
		Node curRoot = new Node(0);
		BST bst = new BST(curRoot);
		
		for(int i=1;i<10;i++){
			constructBST(i);
		}
		
		//inorder traversal
		printBST(root);
		
		searchBST(root,10);
	}
	
	private static void constructBST( int data){
		Node temp = new Node(data);
		Node cur = root;
		
		while(temp.data < cur.data && cur.left != null){
			cur = cur.left;
		}
		
		while(temp.data > cur.data && cur.right != null){
			cur = cur.right;
		}
		
		if(temp.data < cur.data){
			cur.left = temp;
		}else if(temp.data > cur.data){
			cur.right = temp;
		}
	}
	
	private static void printBST(Node root){
		
		if(root.left != null)printBST(root.left);
		System.out.println(root.data);
		if(root.right!=null)printBST(root.right);
	}
	
	private static void searchBST(Node root, int data){
		
		if(root == null){
			System.out.println(data+" does not exist");
			return;
		}
		
		if(data == root.data) System.out.println(data+" is present in the BST");
		
		if(data < root.data)searchBST(root.left,data);
		if(data > root.data)searchBST(root.right,data);

	}
	
}
