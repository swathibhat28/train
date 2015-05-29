package math;


public class Exponent {
	
	public static void main(String []args){
		System.out.println(pow(2,3));
	}

	private static int pow(int x, int y) {
		if(y==0){
			return 1;
		}
		int temp =  pow(x,y/2);
		System.out.println("temp="+temp);
		System.out.println("y"+y);
		if(y%2 == 0){
			return temp*temp;
		}else{
			if(y>0){
			return x*temp*temp;
			}else{
			return temp*temp/x;
			}
		}
	}

}
