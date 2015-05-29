package recursion;

import java.util.ArrayList;
import java.util.Iterator;

public class Permutations {
	
	public static void main(String []args){
		String input = "abc";
		ArrayList<String> permuatations = findPermutations(input);
		Iterator<String> it = permuatations.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}

	private static ArrayList<String> findPermutations(String input) {
		ArrayList<String> permutations = new ArrayList<String>();
		if(input.length()==0){
			permutations.add("");
			return permutations;
		}
		
		char c = input.charAt(0);
		String remainder = input.substring(1);
		ArrayList<String> words = findPermutations(remainder);
		for(String word:words){
			for(int i=0;i<word.length();i++){
				permutations.add(insertCharAt(word,i,c));
			}
		}
		return permutations;
		
	}

	private static String insertCharAt(String word, int i,char c) {
		String start = word.substring(0,i);
		String endString = word.substring(i);
		return start+c+endString;
	}

}
