package math;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class Fibonacci {
	
	public static void main(String[] args){
		int n = 5;
		System.out.println(dynamicMemoFibo(n));
		System.out.println(dynamicBottomUpFibo(n));
		
	}

	private static int dynamicBottomUpFibo(int n) {
		/*
		 * Can be made better by using constant space and storing only previous 2 numbers
		 */
		int fibo[] = new int[n];
		
		for(int i = 0; i< n; i++){
			if ( i == 0 ){
				fibo[i] = 0;
			}else if(i == 1){
				fibo[i] = 1;
			}else{
				fibo[i] = fibo[i-1] + fibo[i-2];
			}
		}
		return fibo[n-1];
	}

	private static int dynamicMemoFibo(int n) {
		
	Hashtable<Integer,Integer> memo = new Hashtable<Integer,Integer>();

		if(memo.contains(n)){
			return memo.get(n);	
		}else if(n == 1){
			memo.put(n, 0);
			return 0;
		}else if(n == 2){
			memo.put(n, 1);
			return 1;
		}else{
			int fibo = (dynamicMemoFibo(n-1) + dynamicMemoFibo(n-2));
			memo.put(n, fibo);
			return fibo;
		}
	}

}
