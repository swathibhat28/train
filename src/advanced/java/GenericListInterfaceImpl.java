package advanced.java;

/*
 * Generic  methods/classes only work with Object types
 * so you need Integer and not int
 */
public class GenericListInterfaceImpl<T> implements GenericListInterface<T> {
	private int size;
	private T[] datastore;
	private int pos;
	
	private GenericListInterfaceImpl(int size){
		 datastore = (T[]) new Object[size];
		 pos = 0;
		 this.size = size;
	}
	
	public void add(T element){
		datastore[pos] = element;
		pos++;
	}
	
	public T get(int pos){
		return datastore[pos];
	}
}
