package math;
import java.util.LinkedList;
import java.util.List;

/*
 * [2,5,4,1,3]
 * unordered pairs = {2,1},{5,4},{5,1},{5,3},{4,1},{4,3}
 * Algorithm
 * 1. Sort the array (nlogn)
 * 2. Find diff in position of each element in sorted array with original array and maintain a sum
 * 3. Delete the element from both 
 * 4. Continue 2 and 3 until end of sorted array
 */
public class UnorderedPairs {
	
	public static void main(String[]args){
		int []a = {2,5,4,1,3};
	
		List<Integer> input = new LinkedList<Integer>();
		for (int i = 0; i < a.length; i++) {
			input.add(a[i]);
		}

		int []sortedInput = heapSort(a);
		
		System.out.println(numberOfUnorderedPairs(input,sortedInput));
		
	}
	
	private static int numberOfUnorderedPairs(List<Integer> input,
			int[] sortedInput) {
		int unorderedPairs = 0;
		for (int i = 0; i < sortedInput.length; i++) {
			int diff =  (input.indexOf(sortedInput[i]));
			unorderedPairs +=diff;
			input.remove(diff);
		}
		return unorderedPairs;
	}

	public static int[] heapSort(int[]a){
		int []sortedInput = {1,2,3,4,5};
		return sortedInput;
	}
	
	
	

}
