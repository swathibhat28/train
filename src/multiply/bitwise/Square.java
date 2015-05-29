package multiply.bitwise;

public class Square {
	
	public static void main(String[] args){
		bitwiseMultiply(5);
	}
	
	public static void bitwiseMultiply(int num) {
		int multiplier = 5, result =0;
		
		while(multiplier !=0){
			if((multiplier & 1)==1){
				result += num;
			}
			multiplier >>=1;
			num <<=1;
		}
		System.out.println(result);
	}

}
