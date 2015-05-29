package trees;

public class TreeNode {
	TreeNode right;
	TreeNode left;
	int data;
	
	public TreeNode(){
		this.setRight(null);
		this.left = null;
	}

	public TreeNode getRight() {
		return right;
	}

	public void setRight(TreeNode right) {
		this.right = right;
	}
}
