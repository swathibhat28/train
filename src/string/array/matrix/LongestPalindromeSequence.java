package string.array.matrix;

/*
 * geeksskeeg - reverse should read the same
 * Find longest in a string
 * typical solution n3
 * using a matrix can be brought down to n2
 * t[n][n] where n is length of string
 * t[i][j] is 1 if str[i..j] is a palindrome
 * 
 * Soln:
 * t[i][i] - single characters are always palindromes - so populate that
 * t[i][i+1] if str[i]=str[i+1] -- two characters both are same so palindrome
 * t[i][j] - anything greater than 2 , use dp and check t[i+1][j-1] as in "eeksskee" for "geeksskeeg" and then
 * check if str[i] "g" == str(j) "g"
 * dynamic programming 
 */

public class LongestPalindromeSequence {
	public static void main(String []args){
		String input = "geeksskeeg";
		int n = input.length();
		boolean[][] t = new boolean[n][n];
		int maxLength = 0;
		
		//string of length 1 is always a palindrome
		for(int i=0;i<n;i++){
			t[i][i] = true;
			maxLength = 1;
		}
		
		//find palindromes in strings of length 2
		for(int i =0; i<n-1;i++){
			if(input.charAt(i) == input.charAt(i+1)){
				t[i][i+1] = true;
				maxLength =2;
			}
		}
		
		//find length for substrings greater than 2
		for(int k=3;k<=n;k++){
			for(int i=0;i<n-k+1;i++){
				int j = i+k-1;
				if(t[i+1][j-1] == true && input.charAt(i) == input.charAt(j)){
					t[i][j] = true;
					if(k > maxLength){
						maxLength = k;
					}
				}
			
			}
			
		}
		
		System.out.println(maxLength);
	}

}
