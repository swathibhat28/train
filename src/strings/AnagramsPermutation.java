package strings;

public class AnagramsPermutation {
	public static void main(String []args){
		/*
		 * dog
		 * god
		 * 
		 * stop
		 * tops
		 */
		System.out.println(isAnagram("stop","post"));
	}

	private static boolean isAnagram(String string1, String string2) {
		int count[] = new int[256]; //for ascii, always verify
		
		if(string1.length()!=string2.length()){
			return false;
		}
		for(char c:string1.toCharArray()){
			count[c]++;
		}
		
		for(char c:string2.toCharArray()){
			if(--count[c] < 0){
				return false;
			}
		}
		return true;
	}
}
