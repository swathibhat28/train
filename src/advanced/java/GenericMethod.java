package advanced.java;

public class GenericMethod<T> {
	
	public static <T1,T2> void testGenericMethod(T1 value1,T2 value2){
		System.out.println(value1);
		System.out.println(value2);
	}
	
	public static void main(String []args){
		testGenericMethod(1,"swathi");
	}

}
