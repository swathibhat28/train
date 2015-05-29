package sorting;

public class HeapSort {
	
	public static int heapSize;
	
	public static void main(String[] args){
		int a[] = {2,1,5,4,3,7,9};
		heapSize = a.length;
		buildMaxHeap(a);
		
		for(int i = a.length-1;i>=0;i--){
			swap(a,0,i);
			heapSize = heapSize-1;
			heapify(a,0);
		}
		
		for(int item:a){
			System.out.println(item);
		}
	}

	private static void buildMaxHeap(int[] a) {
		
		for(int i = (a.length/2);i >=0; i--){
			heapify(a,i);
		}
		
	}

	private static void heapify(int[] a, int i) {
		int leftChild = 2*i+1;
		int rightChild = 2*i+2;
		
		if(leftChild < heapSize && a[leftChild] > a[i]){
			swap(a,i,leftChild);
			heapify(a,leftChild);
		}
		
		if(rightChild < heapSize && a[rightChild] > a[i]){
			swap(a,i,rightChild);
			heapify(a,rightChild);
		}
		
	}

	private static void swap(int[] a, int i, int leftChild) {
		int temp = 0;
		temp = a[i];
		a[i] = a[leftChild];
		a[leftChild] = temp;
		
	}

}
