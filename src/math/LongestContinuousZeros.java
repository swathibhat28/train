package math;

public class LongestContinuousZeros {
	
	public static void main(String[]args){
		System.out.println(longestSequenceOfZeros(133));
	
	}
	
	public static int longestSequenceOfZeros(int num){		
		//1
		int count = 0;
		int maxCount = 0;
		
		while(num > 0){
			if((num &1) == 0){
				count++;
			if(count > maxCount){
				maxCount = count;
			}
			}else{
				count = 0;
			}	
			num = num >> 1;
		}
		return maxCount;
	}

}
