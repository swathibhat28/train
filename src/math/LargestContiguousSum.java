package math;

public class LargestContiguousSum {
	public static void main(String[]args){
		//1,-3,5,-2,9,-8,-6,4
		int[] sequence = {-2,-3,4,-1,-2,1,5,-3};
		System.out.println(maxSum(sequence));
	}

	private static int maxSum(int[] sequence) {
		int maxSoFar = 0;
		int maxEndingHere = 0;
		
		for (int max = 0; max < sequence.length; max++) {
			maxEndingHere = maxEndingHere + sequence[max];
			
			if(maxEndingHere < 0){
				maxEndingHere = 0;
			}else if(maxSoFar < maxEndingHere){
				maxSoFar = maxEndingHere;
			}	
		}
		return maxSoFar;
	}

}
