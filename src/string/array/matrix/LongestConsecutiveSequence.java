package string.array.matrix;

import java.util.HashSet;
import java.util.Set;

/*
 * Given an unsorted array of integers, find the length of the longest consecutive elements 
 * sequence.For example, given [100, 4, 200, 1, 3, 2], where the longest consecutive elements 
 * sequence is [1, 2, 3, 4], return its length: 4.
 * Your algorithm should run in O(n) complexity.
 * 
 * Solution:
 * Sorting is out of question because it will require atlease nlogn
 * Counting sort works but the size of the array might be huge based on the biggest value
 * HashSet - Best solution - Store all numbers in a HashSet. Why HashSet? We want to make sure we 
 * don't have any duplicates. 
 * 1.  Store all numbers in a HashSet
 * 2. Iterate through all the numbers in the list
 * 3. For each element check if num is present in the hashset remove from hashset
 *  and find consecutive - both +1 and -1
 */
public class LongestConsecutiveSequence {
	
	public static void main(String []args){
		int []nums = {100, 4, 200, 1, 3, 2};
		
		Set<Integer> set = new HashSet<Integer>();
		
		for(int num:nums){
			set.add(num);
		}
		int maxLength = 0;
		for(int num: nums){
			
			if(set.contains(num)){
				set.remove(num);
				int len = 1+ findConsecutive(set,num-1,-1);
				len += findConsecutive(set,num+1,1);
				maxLength = Math.max(len, maxLength);
			}
			
		}
		
		System.out.println(maxLength);
	}

	private static int findConsecutive(Set<Integer> set, int num, int step) {
		int len = 0;
		while(set.contains(num)){
			set.remove(num);
			num += step;
			len++;
		}
		return len;
	}

}
