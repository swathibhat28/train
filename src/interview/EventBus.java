package interview;

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
//   public static void main(String[] args) {
//     ArrayList<String> strings = new ArrayList<String>();
//     strings.add("Hello, World!");
//     strings.add("Welcome to CoderPad.");
//     strings.add("This pad is running Java 8.");

//     for (String string : strings) {
//       System.out.println(string);
//     }
//   }
  
  public final class EventBus {
    
    private final Map<String,ArrayList<Listener>> eventTable = new HashMap<String,ArrayList<Listener>>();

    public void register(String eventName, Listener listener) {
      if(!eventTable.containsKey(eventName)){
        ArrayList<Listener> listeners = new ArrayList<Listener>();
        listeners.add(listener);
        eventTable.put(eventName,listeners);
      }else{
        ArrayList<Listener> listeners = eventTable.get(eventName);
        listeners.add(listener);
        eventTable.put(eventName,listeners);
      }
    }

    public void unregister(String eventName, Listener listener) {
      if(eventTable.containsKey(eventName)){
         ArrayList<Listener> listeners = eventTable.get(eventName);
         listeners.remove(listener);
      }
    }

    public void postEvent(String eventName, Object data) {
      if(eventTable.containsKey(eventName)){
         ArrayList<Listener> listeners = eventTable.get(eventName);
         Iterator it = listeners.iterator();
         while(it.hasNext()){
           Listener listener = (Listener)it.next();
           listener.onEvent(data);
         }
      }
    }


}
}


