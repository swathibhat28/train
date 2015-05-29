package asynchronous.event.driven;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	
	
	public static void runClient(String host, int port) throws IOException{
		Socket clientSocket = null;
		BufferedReader in = null;
		PrintWriter out = null;
		
		try {
			clientSocket = new Socket(host,port);
			in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			out = new PrintWriter(clientSocket.getOutputStream());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
		String input;
		
		while((input = stdIn.readLine()) != null){
			
			out.println(input);
			
			if(input.equalsIgnoreCase("bye"))break;	
			
			System.out.println("server says"+input);
			
		}
		out.close();
		in.close();
		clientSocket.close();
	}
	
	public static void main(String []args) throws IOException{
		Client client = new Client();
		client.runClient("127.0.0.1", 9900);	
	}
	

}
