package misc;

import java.util.concurrent.*;

public class LRUCache<K,V> {
	
	private int capacity;
	private ConcurrentHashMap<K,V> map;
	private ConcurrentLinkedQueue<K> queue;
	
	public LRUCache(int capacity){
		this.capacity = capacity;
		map = new ConcurrentHashMap<K,V>(capacity);
		queue = new ConcurrentLinkedQueue<K>();
	}
	
	public void set(K key, V value){
		if(!map.containsKey(key) && map.size() == capacity){
			map.remove(queue.poll());
		}
		if(!map.containsKey(key)){
			map.put(key, value);
			queue.add(key);
		}
		
	}

	public V get(K key){
		if(map.contains(key)){
			queue.remove(key);
			queue.add(key);
			return map.get(key);
		}else{
			return null;
		}
	}
	
	public static void main(String []args){
		LRUCache<Integer,Integer> cache = new LRUCache<Integer,Integer>(5);
		cache.set(1, 1);
		cache.set(2, 2);
		cache.set(3, 3);
		cache.set(4, 4);
		cache.set(5, 5);
		
		cache.get(1);
		cache.get(2);
		cache.get(2);
		cache.set(6, 6);
		for(int i =1;i<=6;i++){
			System.out.println(cache.get(i));
		}
	}
	
}
