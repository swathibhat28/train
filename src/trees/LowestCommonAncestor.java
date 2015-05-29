package trees;


/*
 * Find the length of the path between two nodes in a binary tree
 * 
 */

public class LowestCommonAncestor {
	
	public static void main(String []args){
		BinaryTree bt = new BinaryTree();
		bt.constructTree();
		int d1[] = {-1};
		int d2[] = {-1};
		int dist[] = {-1};
		Node lca = findDistance(bt.root,3,8,d1,d2,1,dist);
		
		if(d1[0] != -1 && d2[0] != -1){
			System.out.println(dist);
		}
		
		if(d1[0] != -1){
			System.out.println(findlevel(lca,3,0));
		}
		
		if(d2[0] != -1){
			System.out.println(findlevel(lca,8,0));
		}
	}

	private static int findlevel(Node root, int i, int level) {
		  if (root == null)
		        return -1;
		 
		    // If key is present at root, or in left subtree or right subtree,
		    // return true;
		    if (root.data == i)
		        return level;
		 
		    int l = findlevel(root.left, i, level+1);
		    return (l != -1)? l : findlevel(root.right, i, level+1);
	}

	private static Node findDistance(Node root, int n1, int n2, int[] d1, int[] d2, int level,int[] dist) {
		if(root == null) return null;
		
		if(root.data == n1){
			d1[0] = level;
			return root;
		}
		if(root.data == n2){
			d2[0] = level;
			return root;
		}
		
		Node left_lcs = findDistance(root.left,n1,n2,d1,d2,level+1,dist);
		Node right_lcs = findDistance(root.right,n1,n2,d1,d2,level+1,dist);
		
		if(left_lcs != null && right_lcs != null){
			dist[0] = d1[0] + d2[0] - 2*level;
			return root;
		}
		
		return (left_lcs != null) ? left_lcs: right_lcs;
	}

}
