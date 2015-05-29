package advanced.java;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;

public class SerializeDeserializeExample {
	
	public static void main(String []args) throws IOException, ClassNotFoundException{
		
		SerializableEmployeeClass c1 = new SerializableEmployeeClass("swathi","advertising",3349343,3434L);
		
		FileOutputStream fileOut = new FileOutputStream("testSerialization.ser");
		ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
		objOut.writeObject(c1);
		fileOut.close();
		objOut.close();
		
		FileInputStream fileIn = new FileInputStream("testSerialization.ser");
		ObjectInputStream objIn  = new ObjectInputStream(fileIn);
		SerializableEmployeeClass c2 = (SerializableEmployeeClass) objIn.readObject();
		System.out.println(c2.getName());
	
	}
	
	

}
