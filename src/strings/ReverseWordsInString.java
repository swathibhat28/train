package strings;

import java.util.Iterator;

public class ReverseWordsInString {
	
	public static void main(String []args){
		StringBuffer inputString = new StringBuffer("cat on hot tin roof");
		//foor nit toh no tac

		int startPos = 0, endPos = inputString.length()-1;
		while(startPos < endPos){
			char temp = inputString.charAt(startPos);
			inputString.setCharAt(startPos, inputString.charAt(endPos));
			inputString.setCharAt(endPos,temp);
			startPos++;
			endPos--;
		}
		System.out.println(inputString);
		startPos = endPos = 0;
		for(int i=0;i<inputString.length();i++){
			if(inputString.charAt(i) == ' ' || i == inputString.length()-1){
				endPos = i < inputString.length()-1 ? i-1 : i;
				while(startPos < endPos){
					char temp = inputString.charAt(startPos);
					inputString.setCharAt(startPos, inputString.charAt(endPos));
					inputString.setCharAt(endPos,temp);
					startPos++;
					endPos--;
				}
				startPos = i+1;
			}
		}
		System.out.println(inputString);
	}

}
