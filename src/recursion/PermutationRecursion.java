package recursion;

public class PermutationRecursion {
	
	public static void main(String[]args){
		findPermutation("","abc");
	}

	private static void findPermutation(String input, String output) {
		if(output.length() == 0){
			System.out.println(input);
			return;
		}
		
		for(int i=0;i<output.length();i++){
			findPermutation(input+output.charAt(i),output.substring(0,i)+output.substring(i+1,output.length()));
		}
	}

}
