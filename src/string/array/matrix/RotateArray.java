package string.array.matrix;

/*
 * Rotate an array of n elements to the right by k steps. 
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 * 
 * soln: a[(i+K)%n] = a[i]
 */

public class RotateArray {

	public static void main(String[] args){
		int []a= {1,2,3,4,5,6,7};
		int k =3;
		rotateArray(a,k);
	}

	private static void rotateArray(int[] a, int k) {
		int previousIndex = 0;
		int i = (previousIndex+k)%(a.length);
		int temp = a[i];
		a[i] = a[previousIndex];
		a[previousIndex] = temp;
		while(i != 0){
			i = (i+k)%(a.length);
			temp = a[i];
			a[i] = a[previousIndex];
			a[previousIndex]= temp;
			
		}
		for (int j = 0; j < a.length; j++) {
			System.out.println(a[j]);
		}
	}
}
