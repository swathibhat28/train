package trie.dictionary.find.pattern;

import java.io.IOException;

public class PatternMatch {

	public static void main(String []args) throws IOException{
	

		Trie t = new Trie();
		
		
		String[] words = {"tea","ted","cut","cat"};
		for(String word:words){
			System.out.println("Reading word:"+word);
			t.constructDictionary(word);
		}
		
		searchWord("sent",t.root);
		String prefix = "";
		searchPattern("c.t",t.root,prefix);
	
	}

	private static void searchPattern(String word, Node root, String prefix) {
		Node curNode = root;

			for (int i=0; i < (word.length() -1);i++) {
				if(curNode.validWord == true){
					return;
				}
				if(curNode.getNode(word.charAt(i)) == null && word.charAt(i) != '.' && (i == (word.length()-1))){
					return;
				}else if(curNode.getNode(word.charAt(i)) != null && word.charAt(i) != '.' ){
					curNode = curNode.getNode(word.charAt(i));
					prefix = prefix+curNode.data;

				}else{ //(curNode.getNode(word.charAt(i), curNode) == null && word.charAt(i) == '.')

					for(Node n:curNode.children){
						System.out.print(prefix+n.data);
						searchPattern(word.substring(i,word.length()),n,"");	
						System.out.println();
					}
					 
				}			
			}
	}
	
	private static void searchWord(String word, Node root){
		char[] letters = word.toCharArray();
		Node curNode = root;
		int curLength = 1;
		
		for (char letter : letters) {
			if(curNode.getNode(letter) != null){
				curNode = curNode.getNode(letter);
				System.out.println(curNode.data);
			}else if(curNode.getNode(letter) == null && (letters.length > curLength)){
				System.out.println("word not found");
				return;
			}
		}
	}
	
	

}
