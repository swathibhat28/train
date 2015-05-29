package string.array.matrix;

/*
 * input string = "leetcode"
 * dict = {"leet","code"}
 * return true if input string can be segmented to words in dictionary
 * 
 * DP solution = use an array t[n]
 * t[0] = true because the string until then can be broken into words in dict
 * t[i] = true if words until then can be broken into words in dict 
 */

public class WordBreak1 {
	
	public static void main(String[]args){
		String input = "leetcode";
		String []dict = {"leet","code"};
		boolean []t = new boolean[input.length()+1];
		t[0] = true;
		
		for(int i=0;i<input.length();i++){
			if(!t[i]){
				continue;
			}
			
			for(String word:dict){
				int end = i+ word.length();
				if(end > input.length()){
					continue;
				}
				
                if(t[end]) continue;	
				
				if(input.substring(i, end).equals(word)){
					t[end]=true;
				}
				
				
			}
		}
		System.out.println(t[input.length()]);

	}

}
