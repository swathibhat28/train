package lcs.dynamic.programming;

public class LongestCommonSubsequence {
	
	public static void main(String[] args){
		String word1 = "AXYT";
		String word2 = "ATY";
		
		System.out.println(lcs(word1,word2));
	}

	private static int lcs(String word1, String word2) {
		int[][] L = new int[word1.length()+1][word2.length()+1];
		
		for (int i = 0; i <= word1.length(); i++) {
			for (int j = 0; j <= word2.length(); j++) {
				if(i==0 || j==0){
					L[i][j] = 0;
				}else if(word1.charAt(i-1) == word2.charAt(j-1)){
					L[i][j] = 1 + L[i-1][j-1];
				}else{
					L[i][j] = Math.max(L[i-1][j], L[i][j-1]);
				}
			}
		}
		return L[word1.length()][word2.length()];
	}
}
