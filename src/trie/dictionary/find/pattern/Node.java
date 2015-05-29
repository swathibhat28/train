package trie.dictionary.find.pattern;

import java.util.List;

public class Node {
	
	char data;
	boolean validWord;
	List<Node> children;
	
	public Node(char data, boolean validWord, List<Node> children) {
		super();
		this.data = data;
		this.validWord = validWord;
		this.children = children;
	}
	
	public Node getNode(char c ){
		if(children!=null){
			for(Node n:children){
				if(n.data == c){
					return n;
				}
			}
		}
		return null;
	}

}
