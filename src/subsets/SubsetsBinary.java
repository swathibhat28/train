package subsets;

import java.util.ArrayList;

public class SubsetsBinary {
	
	public static void main(String[] args){
		ArrayList<Integer> set = new ArrayList<Integer>(); 
		set.add(1);
		set.add(2);
		
		printSubsets(set);
	}

	private static void printSubsets(ArrayList<Integer> set) {
		
		System.out.println("{}");
		for(int i=1;i<Math.pow(2, set.size());i++){
			char []bitChar = Integer.toBinaryString(i).toCharArray();
			int count =0;
			for (int j = bitChar.length-1; j>=0;j--) {
				if(bitChar[count++] == '1'){
					System.out.print(set.get(j));
				}
			}
			System.out.println();
		}
		
	}

}
