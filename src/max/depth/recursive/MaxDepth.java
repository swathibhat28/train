package max.depth.recursive;

public class MaxDepth {
	
	public static void main(String[] args){
		BinaryTree bt = new BinaryTree();
		bt.constructTree();
		System.out.println(maxDepth(bt.root));
	}

	private static int maxDepth(Node root) {
		Node curNode = root;
		int h1 = 0;
		int h2 = 0;
		
		if(curNode != null){
			if(curNode.left != null){
				h1 = 1 + maxDepth(curNode.left);
			}
			if(curNode.right != null){
				h2 = 1 + maxDepth(curNode.right);
			}
		}
		
		return Math.max(h1, h2);
		
	}

}
