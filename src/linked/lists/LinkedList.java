package linked.lists;

public class LinkedList {
	
	Node head;
	
	public LinkedList(){
		head = null;
	}
	
	public void insert(Node node){
		Node currNode = head;
		if(currNode == null){
			currNode = node;
			head = currNode;
			currNode.next = null;
		}else{
			while(currNode.next != null){
				currNode = currNode.next;
			}
			currNode.next = node;
			currNode = currNode.next;
			currNode.next = null;
		}
	}
	
	public void print(){
		Node currNode = head;
		while(currNode != null){
			System.out.println(currNode.value);
			currNode = currNode.next;
		}
	}

	public void insertAtPostion(int lastNegativePosition,Node node) {
		Node prevNode = head;
		if(lastNegativePosition == 0){
			prevNode = node;
			prevNode.next = head;
			head = prevNode;
			return;
		}
		int i=0;
		while(i <= (lastNegativePosition-1) && prevNode.next!=null){
			prevNode = prevNode.next;
			i++;
		}
		Node nextNode = prevNode.next;
		Node currNode = node;
		prevNode.next = currNode;
		currNode.next = nextNode;
		
	}

	public void deleteNodeAtPosition(int j) {
		Node prevNode = head;
		if(head == null){
			return;
		}
		Node nextNode;
		if(j == 0){
			nextNode = head.next;
			head.next = null;
			head = nextNode;
			return;
		}
		
		int i = 0;
		while(i<j && prevNode.next != null ){
			prevNode = prevNode.next;
			i++;
		}
		Node currNode = prevNode.next;
		if(currNode == null){
			prevNode.next = null;
			return;
		}
		if(currNode.next != null){
			nextNode = currNode.next;
			currNode.next = null;
			prevNode.next = nextNode;
			return;
		}		
	}

}
