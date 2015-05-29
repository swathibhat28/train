package trie.dictionary.find.pattern;

import java.util.LinkedList;

public class Trie {
	Node root;
	
	public Trie(){
		root = new Node(' ',false,new LinkedList<Node>());
	}

  public void constructDictionary(String word) {
		
		char[] letters = word.toCharArray();
		Node curNode = root;
		int curLength = 1;
		for (char letter : letters) {
			if(curNode.getNode(letter) != null){
				curNode = curNode.getNode(letter);
			}else {
				curNode.children.add(new Node(letter,false,new LinkedList<Node>()));
				curNode = curNode.getNode(letter);
			}
			curLength++;
		}	
		if(curLength == letters.length){
			curNode.validWord = true;
		}
	}

}
