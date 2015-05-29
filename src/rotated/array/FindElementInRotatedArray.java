package rotated.array;

public class FindElementInRotatedArray {
	
	public static void main(String []args){
		int []a = {1,2,3,5,6,7,8};
		int []b = {5,6,7,8,1,2,3};
		System.out.println(binarySearch(8,0,a.length,a));
	}

	private static int binarySearch(int num,int start,int end, int[]a) {
		
		if(end <= start){
			return -1;
		}
		int mid = start+(end-start)/2;
		
		if(num == a[mid]){
			return mid;
		}
		if(num < a[mid]){
			binarySearch(num,start,mid,a);
		}
		
		if(num > a[mid]){
			binarySearch(num,mid+1,end,a);
		}
		System.out.println(mid);
		
		return -1;
				
	}
	

}

	