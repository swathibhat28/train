package trie.dictionary;

public class TrieNode {
	boolean isFullWord;
	TrieNode[] links;
	char letter;
	
	public TrieNode(boolean isFullWord, TrieNode[] links, char letter) {
		this.isFullWord = isFullWord;
		this.links = links;
		this.letter = letter;
	}
}
