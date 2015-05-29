package numbers.with.sum;
/*
 *1, 2, 4, 7, 11, 15
 */
public class NumbersWithASum {
	
	public static void main(String[] args){
		int[]a = {1, 2, 4, 7, 11, 15};
		int i = 0;
		int j = a.length-1;
		int number = 15;
		while(i<j){
			if((a[i]+a[j]) > number){
				j--;
			}else if((a[i]+a[j]) < number){
				i++;
			}else if((a[i]+a[j]) == number){
				System.out.println(a[i]+" "+a[j]);
				break;
			}

		}
	}

}
