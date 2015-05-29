package asynchronous.event.driven;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Set;
import java.util.Iterator;

public class Reactor implements Runnable{
	
	private ServerSocketChannel serverSocketChannel;
	private Selector selector;
	private boolean isWithThreadPool;
	
	Reactor(int port, boolean isWithThreadPool) throws IOException{
		serverSocketChannel = ServerSocketChannel.open();
		serverSocketChannel.socket().bind(new InetSocketAddress(port));
		selector = Selector.open();
		SelectionKey selectionKey0 = serverSocketChannel.register(selector,SelectionKey.OP_ACCEPT);
		selectionKey0.attach(new Acceptor());
	}
	public void run(){
		try {
			selector.select();
			Set selectionKeys = selector.selectedKeys();
			Iterator it = selectionKeys.iterator();
			while(it.hasNext()){
				dispatch((SelectionKey)it.next());
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void dispatch(SelectionKey key) {	
		Runnable r	= (Runnable)key.attachment();
		if(r != null){
			r.run();
		}		
	}

	class Acceptor implements Runnable {
		
		public void run(){
			try {
				SocketChannel socketChannel = serverSocketChannel.accept();
				if(socketChannel != null){
					new Handler(selector,socketChannel);
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

}
