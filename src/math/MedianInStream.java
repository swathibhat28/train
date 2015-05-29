package math;

import java.util.Scanner;

public class MedianInStream {
	
	public static void main(){
		int median = 0;
		Heap leftMaxHeap = new Heap();
		Heap rightMinHeap = new Heap();
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			System.out.println(getMedian(Integer.valueOf(sc.next()),median,leftMaxHeap,rightMinHeap));
		}
	}

	private static int getMedian(int next, int median, Heap leftMaxHeap, Heap rightMinHeap) {
		
		if((leftMaxHeap.size - rightMinHeap.size) == 0){
			if(next < median){
				leftMaxHeap.insertMax(next);
				median = leftMaxHeap.getMax();
			}else if(next > median){
				rightMinHeap.insertMin(next);
				median = rightMinHeap.getMin();
			}
			return median;
		}else if(leftMaxHeap.size > rightMinHeap.size){
			if(next < median){
				rightMinHeap.insertMin(leftMaxHeap.popMax());
				leftMaxHeap.insertMax(next);
				median = (leftMaxHeap.getMax()+ rightMinHeap.getMin())/2;
			}else if(next > median){
				rightMinHeap.insert(next);
				median = rightMinHeap.getMin();
			}
			return median;
		}else if(leftMaxHeap.size < rightMinHeap.size){
			if(next > median){
				leftMaxHeap.insertMax(rightMinHeap.popMin());
				rightMinHeap.insertMin(next);
				median = (leftMaxHeap.getMax()+ rightMinHeap.getMin())/2;
			}else if(next < median){
				leftMaxHeap.insertMax(next);
				median = leftMaxHeap.getMax();
			}
			return median;
		}
		
		return 0;
	}

}
