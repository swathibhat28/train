package math;

import java.util.Arrays;
import java.util.List;

import sorting.MergeSort;

/*
 * given an integer x and an unsorted array determine whether two numbers 
 * add upto the sum
 * 
 *  10,2,4,5,76,8,9 - 10
 *  2,4,5,6,8,9,10,24
 *  Two pointer solution - have two pointers - start frm beginning and end
 *  1. Find sum. If sum > x decrement second ppinter. If sum < x increment first pointer
 *  2. Repeat 1 until you find a match. If not the two numers that do not exist
 */

public class TargetSum {
	
	public static void main(String []args){
		List<Integer> array = MergeSort.mergeSort(Arrays.asList(10,2,4,5,6,8,9));
		
		int first = 0, last = array.size()-1;
		int targetSum =6;
		while(first < last){
			if(array.get(first) + array.get(last) > targetSum ){
				last--;
			}else if(array.get(first) + array.get(last) < targetSum){
				first++;
			}else{
				System.out.println("The two items are 1."+first+" 2."+last);
			}
		}
	}

}
