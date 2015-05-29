package recursion;

public class MagicIndex {
	
	public static void main(String[]args){
		int []a = {5,6,7,7,7,7,7,7,8};
		
		System.out.println(magicIndex(a,0,a.length-1));
	}

	private static int magicIndex(int[] a,int start,int end) {
		if(start < 0 || end < start || end > a.length-1){
			return -1;
		}
		int mid = (start+end)/2;
		if(a[mid] == mid){
			return mid;
		}
		
		int leftMid = Math.min(mid, a[mid]);
		int left = magicIndex(a,start,leftMid);
		
		if(left >= 0){
			return left;
		}
		
		int rightIndex = Math.max(mid, a[mid]);
		int right = magicIndex(a,rightIndex,end);
		return right;

	}

}
