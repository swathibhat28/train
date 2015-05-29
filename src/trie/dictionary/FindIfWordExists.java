package trie.dictionary;

import java.util.LinkedList;
import java.util.List;

public class FindIfWordExists {
	
	public static void main(String[] args){
		TrieNode tree = new TrieNode(false,new TrieNode[26],'\0');
		List<String> dictionary = getDictionary();
		
		for (String word : dictionary) {
			insertWord(tree,word);
		}
		String word = "test";
		findWord(word,tree);
		
	}

	private static void findWord(String word, TrieNode root) {
		TrieNode curNode = root;
		char[] letters = word.toCharArray();
		int offset = Integer.valueOf('a');
		int currentLength = 0;
		for (char c : letters) {
			if(curNode.links[Integer.valueOf(c) - offset] == null && (currentLength != letters.length-1)){
				System.out.println("Word doesnt exist");
				return;
			}
			currentLength++;
			curNode = curNode.links[Integer.valueOf(c) - offset];
		}
		System.out.println("exists");

	}

	private static void insertWord(TrieNode root, String word) {
		char[] letters = word.toCharArray();
		int offset = Integer.valueOf('a');
		int currentLength = 0;
		TrieNode curNode = root;
		for (char c : letters) {
			if(curNode.links[Integer.valueOf(c) - offset] == null){
				curNode.links[Integer.valueOf(c) - offset] = new TrieNode((currentLength == letters.length-1 ? true:false),new TrieNode[26],c);
			}
			curNode = curNode.links[Integer.valueOf(c) - offset] ;
			currentLength++;	
		}
		
	}

	private static List<String> getDictionary() {
		List<String> dictionary = new LinkedList<String>();
		dictionary.add("ant");
		dictionary.add("alloy");
		dictionary.add("all");
		dictionary.add("allot");
		dictionary.add("allotment");
		
		return dictionary;
	}

}

