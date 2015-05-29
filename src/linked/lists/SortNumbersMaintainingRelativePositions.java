package linked.lists;


public class SortNumbersMaintainingRelativePositions {
	
	public static void main(String[] args){
		
		int []inputArray = {-1, 1, 3, -2, 2};
		LinkedList list = new LinkedList();
		for (int j = 0; j < inputArray.length; j++) {
			Node node = new Node(inputArray[j]);
			list.insert(node);
		}
//		list.print();
		int lastNegativePosition = 0;
		for (int j = 0; j < inputArray.length; j++) {
			if(inputArray[j] < 0){
				Node node = new Node(inputArray[j]);
				list.deleteNodeAtPosition(j);
				list.insertAtPostion(lastNegativePosition,node);
				lastNegativePosition++;
			}
		}
		list.print();
	}

}
