package edit.distance.recursive;

public class EditDistance {
	
	public static void main(String[] args){
		System.out.println(editDistance("cars","casts"));
	}

	private static int editDistance(String word1, String word2) {
		if(word1.isEmpty()){
			return word2.length();
		}
		if(word2.isEmpty()){
			return word1.length();
		}
		
		if(word1.isEmpty() && word2.isEmpty()){
			return 0;
		}
	
		int replaceLength = editDistance(word1.substring(1),word2.substring(1)) + (word1.charAt(0) == word2.charAt(0)? 0:1);
		int insertLength = editDistance(word1,word2.substring(1)) + 1;
		int deleteLength = editDistance(word1.substring(1),word2) + 1;
		return Math.min(deleteLength, Math.min(replaceLength, insertLength));
		
	}

}
