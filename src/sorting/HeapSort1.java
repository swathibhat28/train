package sorting;

/**
 * Created by swathi on 9/28/14.
 */
public class HeapSort1 {
    private static int heapSize = 0;

    public static void main(String[]args){
        int a[] = {3,2,5,1,4};

        heapSort(a);
    }

    public static void heapSort(int []a){

     heapSize = a.length-1;
     heapify(a);

     for(int i = heapSize;i>0;i--){
         swap(a,0,i);
         heapSize=heapSize-1;
         maxHeap(a,0);
     }

    }

    private static void heapify(int []a){

        for(int i = heapSize/2; i>= 0; i--){
            maxHeap(a,i);
        }
    }

    private static void maxHeap(int []a,int i){

        int left = 2*i;
        int right = 2*i+1;
        int max = i;

        if(left <= heapSize && a[left] > a[max] ){
            max = left;
        }

        if(right <= heapSize && a[right] > a[max]){
            max= right;
        }

        if(max != i){
            swap(a,max,i);
            maxHeap(a,max);
        }
    }

    private static void swap(int []a,int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}