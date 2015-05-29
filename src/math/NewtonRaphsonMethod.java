package math;

public class NewtonRaphsonMethod {
	
	public static void main(String[] args){
		System.out.println(squareRoot(36));
	}

	private static double squareRoot(float num) {
		float guess = num/2;
		double errorMargin = 0.0000000000000001;
		while(((guess*guess)-num) > errorMargin ){
			float functionGuess = (guess*guess) -2;
			float derivativeGuess = 2*guess;
			guess = (guess- functionGuess/derivativeGuess);
		}
		return guess;		
	}

}
