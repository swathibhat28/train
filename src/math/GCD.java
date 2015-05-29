package math;
/*
 * Optimization over the naive recursive algorithm to find GCD of two numbers
 */
public class GCD {
	
	
	
	public static void main(String [] args){
		System.out.println(gcd(2,11));
	}

	private static int gcd(int x, int y) {
		if(x==0){
			return y;
		}
		else if(y==0){
			return x;
		}
		else if(x==y){
			return x;
		}
		//if x and y are even
		else if(((x & 1)==x+1) && ((y&1) == y+1)){
			return  (gcd(x>>1,y>>1)) << 1;
		}
		
		else if(((x & 1) != x+1) && ((y&1) == y+1)){
			return  (gcd(x,y>>1)) ;
		}
		
		else if(((x & 1)==x+1) && ((y&1) != y+1)){
			return  (gcd(x>>1,y));
		}
		
		else if(x > y){
			return (gcd(x-y,y));
		}
			return (gcd(x,y-x));
		
		
		
	}

}
