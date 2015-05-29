package dynamic.programming;
/*
 * A child is running up (n) stairs and can hop - {1,2,3} steps. Count the number of ways he can climb the steps
 */
public class CountWaysDP {
	public static void main(String []args){
		int []map = new int[11];
		System.out.println(countWays(10,map));
	}

	private static int countWays(int n,int[]map) {
		if(n < 0){
			return 0;
		}else if(n==0){
			return 1;
		}else if(map[n] > 0){
			return map[n];
		}else{
			map[n] = (countWays(n-1,map)+countWays(n-2,map)+countWays(n-3,map));
			return map[n];
		}
	}

}
