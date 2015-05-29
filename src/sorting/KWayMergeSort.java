package sorting;




//Input:
//k = 3, n =  4
//arr[][] = { {1, 3, 5, 7},
//            {2, 4, 6, 8},
//            {0, 9, 10, 11}} ;
//
//Output: 0 1 2 3 4 5 6 7 8 9 10 11 


//00 10 20 - 20
//00 10 21 - 00
//01 10 21 - 10
//01 11 21 - 01
//02 11 21 - 11
//02 12 21 - 02
//03 12 21 - 12
//03 13 11 - 03 // end of n for 0
//- 13 11 - 13 // end of n for 1 

public class KWayMergeSort {
	
	public static void main(String[] args){
		int k=3,n=4;
		int arr[][] = { 
					  {1, 3, 5, 7},
	            	  {2, 4, 6, 8},
	            	  {0, 9, 10, 11}
	            	  } ;
		
		MinHeap hp = new MinHeap(arr, k); 
		int output[] = new int[k*n];
		int count = 0;
		while(count < k*n){	
			output[count] = hp.getMin();
			int index = hp.getMinIndex();
			if(index < n-1){
				index++;
				hp.addElement(arr[index]);
			}
			count++;
		}
	
	}

	private static void minHeap(int[] heap, int k) {
		// TODO Auto-generated method stub
		
	}

	private static void heapify(int[] heap) {
		// TODO Auto-generated method stub
		
	}

}
