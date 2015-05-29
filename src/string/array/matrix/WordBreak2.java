package string.array.matrix;

import java.util.ArrayList;
import java.util.List;

import javax.swing.text.StyledEditorKit.ForegroundAction;

/*
 * s = "catsanddog"
 * dict =  ["cat", "cats", "and", "sand", "dog"]
 * 
 * Solution = ["cat sand dog","cats and dog"]
 * 
 * DP soln - n2
 * Create an array of ArrayList<String> List <String> t = new ArrayList<String>[s.length()+1]
 * 1. Iterate over every character in string
 * 2. Iterate over every word in dict 
 * 
 */
public class WordBreak2 {
	public static void main(String[] args){
		String s = "catsanddog";
		String []dict ={"cat", "cats", "and", "sand", "dog"};
		
		ArrayList<ArrayList<String>> listOLists = new ArrayList<ArrayList<String>>();
		ArrayList<String> list = new ArrayList<String>();
		listOLists.add(0,list);
		  
		for(int i =0; i< s.length();i++){
			if( listOLists.get(0)== null){
				continue;
			}
			
			for(String word: dict){
				int end = word.length();
				
				if(s.length() < word.length()){
					continue;
				}
				
				if(s.substring(i,end) == word){
					if(listOLists.get(end) == null){
						ArrayList<String> temp = new ArrayList<String>();	
						listOLists.add(end,temp);
					}
					ArrayList<String> temp = listOLists.get(end);
					temp.add(word);
				}
				
			}
			
		}
	}
}
