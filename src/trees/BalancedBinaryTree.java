package trees;

public class BalancedBinaryTree {
	TreeNode root;
	
	public BalancedBinaryTree(){
		root = new TreeNode();
	}
	
	public static void main(String[]args){
		BalancedBinaryTree bt = new BalancedBinaryTree();
		System.out.println(isBalanced(bt.root));
		
	}
	private static int isBalanced(TreeNode root) {
		
		if(root == null){
			return -1;
		}
		
		int leftHeight = isBalanced(root.left);
		if(leftHeight == -1){
			return -1;
		}
		int rightHeight = isBalanced(root.right);
		if(rightHeight == -1){
			return -1;
		}
		
		if(Math.abs(leftHeight-rightHeight) > 1){
			return -1;
		}else{
			return (Math.max(leftHeight, rightHeight)+1);
		}
	}
}
