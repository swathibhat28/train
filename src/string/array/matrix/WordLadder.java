package string.array.matrix;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

/*
 * Famous Lewis Carol algorithm 
 * Given:
 * start word = "hit"
 * end word = "cog"
 * dict = ["hot","dot","dog","lot","log"]
 * Find shortest transformation from "hit" -> "cog"
 * precondition - you can transform only one character at a time
 * Solution:
 * Use stacks and a queue
 * Start with start word. Look into the dict to find all words one character different from end word
 * Push start word and each word that is one char different into a stack. Push start word first then new word.
 * Enqueue each of these stacks into a queue
 * Dequeue queue and compare new word with end, if the same you are done. If not find all words in dict that are one char different and repeat process until done
 */
public class WordLadder {
	public static void main(String[] args){
		String start = "hit",end = "cog";
		Set<String> dict = new HashSet<String>();
		dict.add("hot");
		dict.add("dot");
		dict.add("dog");
		dict.add("lot");
		dict.add("log");
		
		wordLadder(start,end,dict);
										
	}

	private static void wordLadder(String start, String end, Set<String> dict) {
		
		if(start == end){
			System.out.println("zero transformations");
			return;
		}
		
		if(start.length() != end.length()){
			System.out.println("transformations not possible");
		}
		
		Queue<Stack<String>> queue = new LinkedList<Stack<String>>();
		queueLadderWords(start, dict, queue);
		start = queue.remove().pop();
		System.out.println(start);
		dict.remove(start);
		while(start != end){
			if(dict.isEmpty()){
				int count = 0;
 				for(int i=0;i<start.length();i++){
					if(end.charAt(i) != start.charAt(i)){
						count++;
					}
 				}
				if(count == 1){
					System.out.println("done");
					return;
				}else{
					System.out.println("transformation not possible");
					return;
				}
			}
			queueLadderWords(start, dict, queue);
			dict.remove(start);
			start = queue.remove().pop();
			System.out.println(start);
			dict.remove(start);

		}
		
	}

	private static void queueLadderWords(String start, Set<String> dict,
			Queue<Stack<String>> queue) {
		for(String word:dict){
			int count = 0;
			for(int i=0;i<word.length();i++){
				if(word.charAt(i) != start.charAt(i)){
					count++;
				}
			}
			if(count == 1){
				Stack<String> s = new Stack<String>();
				s.add(start);
				s.add(word);
				queue.add(s);
			}
			}

		}
 

}
