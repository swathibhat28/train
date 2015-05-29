package strings;

public class UniqueString {
	
	public static void main(String []args){
		//assume  alphabets a-z
		System.out.println(isUniqueString("aba"));
		System.out.println(isUniqueString("abc"));

	}

	private static boolean isUniqueString(String inputString) {
		
		/*
		 *for alphabets a 32 bit int can hold all the bits making it a better solution than using a hash map or a boolean value as key
		 *as it will take up (8 * 26) for this solution to hold all the keys. Instead you can do it in just 26 bits
		 */
		 
		int bitVector = 0;
		char[] inputArray = inputString.toCharArray();
	
		for(char c: inputArray){
			int curCharVal = 1 << (c-'a');
			if((bitVector & curCharVal) > 0){
				return false;
			}
			bitVector |= curCharVal;
		}
		return true;
	}

}
