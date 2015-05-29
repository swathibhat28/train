package recursion;

public class InsertParenthesis {
	public static void main(String []args){
		generateParenthesis(2);
	}

	private static void generateParenthesis(int count) {
		char [] str = new char[count*2];
		insertParenthesis(count,count,str,0);
	}

	private static void insertParenthesis(int leftCount, int rightCount, char[] str,
			int count) {
		if(leftCount < 0 || rightCount < leftCount){
			System.out.println("Invalid state");
		}
		
		if(leftCount==rightCount){
			System.out.println(String.copyValueOf(str));
		}
		
		if(leftCount > 0){
			str[count] = '(';
			insertParenthesis(leftCount-1,rightCount,str, count+1);
		}
		
		if(rightCount > leftCount){
			str[count] = ')';
			insertParenthesis(leftCount,rightCount-1,str,count+1);
		}
	}

}
