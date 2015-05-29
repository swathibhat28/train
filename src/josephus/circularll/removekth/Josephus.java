package josephus.circularll.removekth;
/*
 * There are n nodes in a circle and you will start removing every kth node from it until there is only one node left.
Design a datastructure which will allow above in O(n) time
 */
public class Josephus {
	
	public static void main(String[]args){
		System.out.println(josephus(5,2));
	}

	private static int josephus(int n, int k) {
		if(n == 1){
			return 1;
		}else{
			return((josephus(n-1,k)+k-1)%n)+1;
		}
	}

}
