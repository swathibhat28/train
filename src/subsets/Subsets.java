package subsets;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
	
	public static void main(String[] args){
		int []a = {1,2};
		List<String> result = new ArrayList<String>();
		result = subsets(a,a.length,result);
		System.out.println(result);
		
	}

	private static List<String> subsets(int[] a, int length, List<String> result) {
		if(length < 0){
			return null;
		}
		
		if(length == 0){
			result.add("{}");
			return result;
		}
		
		result = subsets(a,length-1,result);
		List<String> temp = new ArrayList<String>();
		for(String subset:result){
			if(subset == "{}"){
				temp.add(a[length-1]+"");
			}else{
				temp.add(subset+""+a[length-1]);
			}
		}
		result.addAll(temp);
		return result;
	}

}
