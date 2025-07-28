import java.util.*;
public class Classroom{
    public static void main(String[]args){
        HashMap<String,Integer> hm = new HashMap<>();
        hm.put("Isagi Yoichi", 20);
        hm.put("Saket Gokhale", 40);
        hm.put("x", 30);
        hm.put("IG", 50);

        // Iterate on hashmap
        //  Set<String> keys= hm.keySet(); // Store krta hai collections of key
        //  for (String k : keys) {
        // System.out.println("Key value "+ k +",value "+ hm.get(k));
        //  }

        // for (Map.Entry<String,Integer> entry: hm.entrySet()) {
        //     String key = entry.getKey();
        //     Integer value = entry.getValue();
        //     System.out.println("Key: " + key + ", Value: " + value);
        // }
        /*

        System.out.println("Our First HashMap- ");
        System.out.println(hm);

        // use function- size
        System.out.println("Size is "+ hm.size());

        // get
        //int anime = hm.get("IG");
        //System.out.println(hm.get("IG"));

        // remove function
        hm.remove("x");
        System.out.println(hm);
        System.out.println(hm.containsKey("x"));


        */
    }
}
class Classroom2 {
    public static String getStart(HashMap<String, String> tickets) {
        HashMap<String, String> revMap = new HashMap<>();

        for (String key : tickets.keySet()) {
            revMap.put(tickets.get(key), key);
        }

        for (String key : tickets.keySet()) {
            if (!revMap.containsKey(key)) {
                return key;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        HashMap<String, String> tickets = new HashMap<>();
        // Corrected test case without a cycle
        tickets.put("Chennai", "Mumbai");
        tickets.put("Mumbai", "Delhi");
        tickets.put("Goa", "Chennai");
        tickets.put("Delhi", "Bangalore"); // Now, Goa is the start

        String start = getStart(tickets);
        if (start == null) {
            System.out.println("No valid starting point (cycle detected)");
            return;
        }

        System.out.print(start);
        while (tickets.containsKey(start)) {
            String next = tickets.get(start);
            System.out.print("->" + next);
            start = next;
        }
        System.out.println();
    }
}