package advanced.java;

public class GenericList<T> {
	
	private T[] datastore;
	private int size;
	private int pos;
	
	private GenericList(int numElements){
		this.size = numElements;
		this.pos = 0;
		datastore = (T[]) new Object[size];		
	}
	
	private void add(T element){
		datastore[pos] = element;
		++pos;
	}
	
	public String toString(){
		String elements = "";
		for(int i = 0; i < size ; i++){
			elements+=datastore[i];
		}
		return elements;
	}
	
	public static void main(String []args){
		GenericList<String> glist = new GenericList<String>(10);
		glist.add("milk");
		glist.add("eggs");
		System.out.println(glist.toString());
		
		GenericList<Integer> glist2 = new GenericList<Integer>(10);
		glist2.add(1);
		glist2.add(3);
		System.out.println(glist2.toString());
	}

}
