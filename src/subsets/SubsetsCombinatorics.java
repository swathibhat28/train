package subsets;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class SubsetsCombinatorics {
	
	public static void main(String[] args){
		ArrayList<Integer> set = new ArrayList<Integer>();
		set.add(1);
		set.add(3);
		printSubSets(set);
	}

	private static void printSubSets(ArrayList<Integer> set) {
		int max = 1 << set.size();
		ArrayList<ArrayList<Integer>> allSubSets = new ArrayList<ArrayList<Integer>>();
		for(int i =0;i<max;i++){
			ArrayList<Integer> subSet =  convertIntToSubSet(i,set);
			allSubSets.add(subSet);
		}
	}

	private static ArrayList<Integer> convertIntToSubSet(int i, ArrayList<Integer> set) {
		ArrayList<Integer> subSet = new ArrayList<Integer>();
		int index=0;
		for(int j=i;j>0;j>>=1){
			if((j&1) ==1){
				subSet.add(set.get(index++));
			}
		}
		return subSet;
	}

}
