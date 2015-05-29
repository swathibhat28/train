package sorting;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MergeSort {
	
	public static void main(String []args){
		System.out.println(mergeSort(Arrays.asList(10,2,4,5,76,8,9)));
	}

	public static List<Integer> mergeSort(List<Integer> a) {
		if(a.size() <= 1){
			return a;
		}
		int mid = a.size()/2;
		
		 List<Integer> left = new LinkedList<Integer>();
		 for(int i = 0; i < mid;i++){
			 left.add(a.get(i));
		 }
		 List<Integer> right = new LinkedList<Integer>();
			 for(int i = mid; i < a.size();i++){
				 right.add(a.get(i));
			 } 
		 
		 left = mergeSort(left);
		 right = mergeSort(right);
		 
		 List<Integer> result = new LinkedList<Integer>();
		 merge(left,right,result);
		 
		return result;
		
	}

	private static void merge(List<Integer> left, List<Integer> right, List<Integer> result) {
		int i = 0;
		while( i < left.size() || i < right.size()){
			if(i >= left.size()){
				result.add(right.get(i));
			} 
			
			if(i >= right.size()){
				result.add(left.get(i));
			}
			
			if(i < left.size() && i < right.size()){
				int item = (left.get(i) < right.get(i)) ? left.get(i) : right.get(i);
				System.out.println(item);
				result.add(item);
			}
			i++;
		}
	}

	
}
