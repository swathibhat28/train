package binary.search.tree;

import java.util.Iterator;
import java.util.Stack;

public class BinarySearchTree implements Iterator<Integer> {
	Node root;
	public static Stack<Integer> stack = new Stack<Integer>();

	public static void constructBinarySearchTree(Node root, int item){
			Node nextNode = new Node(item);
			if(item < root.data && root.left!=null){
				constructBinarySearchTree(root.left,item);
			}else if(item < root.data && root.left == null){
				root.left = nextNode;
			}else if(item > root.data && root.right != null){
				constructBinarySearchTree(root.right,item);
			}else if(item > root.data && root.right==null){
				root.right = nextNode;
			}
		
	}
	
	public static void main(String[] args){
		int []a = {2,3,5,4,7,9,1};
		BinarySearchTree bt = new BinarySearchTree();
		bt.root = new Node(a[0]);
		for(int i=1;i<a.length;i++){	
			constructBinarySearchTree(bt.root,a[i]);
		}
		iterate(bt.root);
		
		while(bt.hasNext()){
			System.out.println(bt.next());
		}
	}

	private static void iterate(Node root) {
		if(root == null) return;
		
		iterate(root.left);
		stack.push(root.data);
		iterate(root.right);
	}

	@Override
	public boolean hasNext() {
		return !stack.isEmpty();
	}

	@Override
	public Integer next() {
		if(!hasNext()){
			return null;
		}
		return stack.pop();
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}
	

}
