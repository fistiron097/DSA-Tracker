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
