package trees;

public class InOrder {
	
	void inOrder (Node root)
	{
	 
	  if(root == null) return;
	  
	  inOrder( root.left );
	  
	  System.out.println(root.data);
	  
	  inOrder( root.right ); 
	  
	}


}
