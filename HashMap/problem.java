import java.util.*;
public class problem{
    public static String getStart( HashMap<String,String> tickets){
        HashMap<String,String> revMap = new HashMap<>();

        // loop on tickets to store (val,key) in our revMap
        for(String key: tickets.keySet()){
            revMap.put(tickets.get(key),key);
        }
        // i am sure that isne val->key pair bana diya hoga 
        // ab humei start point nikalna 
        for(String key: tickets.keySet()){
            if(!revMap.containsKey(key)){
                return key;
            }
        }
        return null;
    }

    public static void main(String[]args){
    HashMap<String,String> tickets = new HashMap<>();
    tickets.put("Chennai","Mumbai");
    tickets.put("Mumbai","Delhi");
    tickets.put("Goa","Chennai");
    tickets.put("Delhi","Banglore");

    String start = getStart(tickets);
    // mumbai
   System.out.print(start);
    for(String key: tickets.keySet()){
        System.out.print("->" + tickets.get(start));
        start = tickets.get(start);
    }
    System.out.println();
  }

}