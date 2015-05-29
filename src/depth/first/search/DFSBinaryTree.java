package depth.first.search;

import java.util.Stack;

public class DFSBinaryTree {

	public static void main(String[] args){
		BinaryTree bt = new BinaryTree();
		bt.constructTree();
		maxDepth(bt);
		
	}

	private static void maxDepth(BinaryTree bt) {
		Stack<BinaryNode> s = new Stack<BinaryNode>();
		s.push(bt.root);
		int leftHeight = 0;
		int rightHeight = 0;
		/*
		 * BT DFS does not need visited , but for graph check for visited to prevent cycles, also having a data field in node you can search
		 */
		while(s.empty()!=true){
			BinaryNode curNode = s.pop();
			
			if(curNode.right!=null){
				rightHeight++;
				s.push(curNode.right);
			}
			
			if(curNode.left!=null){
				leftHeight++;
				s.push(curNode.left);
			}
		}
		System.out.println(Math.max(leftHeight, rightHeight));
	}
	


}
