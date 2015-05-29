package math;

/*
 * Find trailing zeros in 100!
 * After checking multiplications - 2's and 5's make more 0's
 * 100/
 * 
 */

public class TrailingZeros {
	
	public static void main(String[] args){
		int count = 0;
		for(int i=1;i<=100;i++){
			if(i%5 == 0){
				count++;
				if(i%25 == 0){
					count++;
				}
			}
		}
		System.out.println(count);
	}

}
