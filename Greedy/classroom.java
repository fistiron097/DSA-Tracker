//                                Sorted on the basis of end time
/* 
import java.util.*;
public class classroom{
    public static void main(String[]args){
        int start[] = {1,3,0,5,8,5};
        int end[] = {2,4,6,7,9,9};

        // sorting in 2d array
        int [][] activities = new int[start.length][3];
        for(int i=0;i<activities.length;i++){
          activities[i][0] = i;
          activities[i][1] = start[i];
          activities[i][2] = end[i];
        }

        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));

        // end time basis sorted 
        int maxAct = 0; // Initial kiya bus expanation ke liye
        ArrayList<Integer> ans = new ArrayList<>();

        // 1st activity 
        maxAct = 1;
        ans.add(acitivites[0][0]);
        int lastEnd = activities[0][2];
        for(int i=0; i< end.length;i++){
            if(activites[i][1] >= lastEnd){
                // activity select 
                maxAct++;
                ans.add(activites[i][0]);
                lastEnd = activities[i][2];
            }
        }
        System.out.println("max activities = "+maxAct); // Miss kiya 
        // List print krwa diya Activites ka 
        for(int i=0; i < ans.size();i++){
            System.out.println("A"+ans.get(i)+" ");
        }
        System.out.println();
    }
}
*/

//                          Sorting 2D array on the basis of 2nd column
/* 
import java.util.*;
public class classroom{
    public static void main(String[]args){
        int start[] = {1,3,0,5,8,5};
        int end[] = {2,4,6,7,9,9};
        // end time basis sorted 

        int [][] activities = new int[start.length][2];
        for(int i=0; i< start.length;i++){
            activities[i][0] = i;
            activities[i][1] = start[i];
        }
        // Sort the array // lambda function
        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));

        int maxAct = 0; // Initial kiya bus expanation ke liye
        ArrayList<Integer> ans = new ArrayList<>();

        // 1st activity 
        maxAct = 1;
        ans.add(activities[0][0]);
        int lastEnd = activities[0][2];
        for(int i=0; i< end.length;i++){
            if(activities[i][1] >= lastEnd){
                // activity select 
                maxAct++;
                ans.add(i);
                lastEnd = activities[i][2];
            }
        }
        System.out.println("max activities = "+maxAct); // Miss kiya 
        // List print krwa diya Activites ka 
        for(int i=0; i < ans.size();i++){
            System.out.println("A"+ans.get(i)+" ");
        }
        System.out.println();
    }
}
*/

//                     Fractional Knapsack
/* 
import java.util.*;
public class classroom{
    // Here greedy approach is We pick item with max value and less weight
    public static void main(String[]args){
        int val[] = {60,100,120}; // Each item value 
        int weight[] = {10,20,30}; // Each item associated with weight 
        int w = 50; // capacity of bag 

        double ratio[][] = new double[val.length][2];
        //3 row 2 columns in which is 1st column -> Original index and 2nd columns is Ratio of (Value/Weight)
       // Create 2D array
       for(int i=0; i < val.length;i++){
        ratio[i][0] = i; // current index storing 
        ratio[i][1] = val[i]/ (double)weight[i];
       }
       // Sort kr rha hu 2D arrays on basis of ratio in ascending order 
       Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));
       // Working real
       int capacity = w;
       int finalVal = 0;
       |idx,val|
       |idx,val|
       |idx,val|
       for(int i = ratio.length-1; i>=0; i--){
         int idx = (int)ratio[i][0];
         if(capacity >= weight[idx]){
            finalVal += val[idx];
            capacity -= weight[idx];
         } else{
            // include fractional part
            finalVal += (ratio[i][1] * capacity);
            capacity = 0;
            break;
         }
       }
       System.out.println("final value = "+finalVal);

    }
}
    */
//                             Minimum Absolute difference 
/* 
import java.util.*;
public class classroom{
    public static void main(String[]args){
        int A[] = {4,1,8,7};
        int B[] = {2,3,6,5};

        Arrays.sort(A);
        Arrays.sort(B);

        int minDiff = 0;
        for(int i = 0; i< A.length;i++){
            minDiff += Math.abs(A[i] - B[i]);
        }
        System.out.println("Min Abs diff of pairs = "+ minDiff);
    }
}
*/
//                      Maximum Length chain(Activity Selection Problem)
/* 
import java.util.*;
public class classroom{
    public static void main(String[]args){
        // Initialize 2D array
        int pairs[][] ={
            {5,24},
            {39,60},
            {5,28},
            {27,40},
            {50,90}
        };
        // Sort the given array
        Arrays.sort(pairs, Comparator.comparingDouble(o ->o[1]));
        int chainLen = 1;
        int chainEnd = pairs[0][1];
        for(int i =1 ;i < pairs.length;i++){
            if(pairs[i][0] > chainEnd){
                chainLen++;
                chainEnd = pairs[i][1];
            }
        }
        System.out.println("Max Length of chain ="+chainLen);

    }
} 
*/
//                                      Indian Coins 
/* 
import java.util.*;
public class classroom{
    public static void main(String[]args){
        Integer coins[] = {1,2,5,10,20,50,100,500,2000};
        // Sort karna hai array in descending order 
        Arrays.sort(coins, Comparator.reverseOrder());
        
        int countCoins = 0;
        int amount = 590;
        //Arraylist Creation 
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i= 0; i < coins.length;i++){
            if(amount < coins[i]){
                while(amount < coins[i]){
                    countCoins++;
                    amount = amount - coins[i];
                }
            }
        }
        System.out.println("Total Coins used = "+ countCoins);
        for(int i = 0; i< ans.size();i++){
            System.out.println(ans.get(i)+"");
        }
        System.out.println();
    }
}
*/

//                                    Job sequencing Problem(Most Important Question)
//                      In this we learned about how to sort Objects 
/* 
import java.util.*;
public class classroom{
    static class Job{
        int deadline;
        int profit;
        int id;

        public Job(int i, int d, int p){
            id = i;
            deadline = d;
            profit = p;
        }
    }
    public static void main(String[]args){
        int jobsInfo[][] = {
            {4,20},
            {1,10},
            {1,40},
            {1,30}
        };
        // Now we will create Array of objects
        ArrayList<Job> jobs= new ArrayList<>();
        for(int i=0; i< jobsInfo.length;i++){
            jobs.add(new Job(i,jobsInfo[i][0], jobsInfo[i][1]));
        }
        // Sort 
        Collections.sort(jobs, (obj1,obj2) -> obj2.profit-obj1.profit);// descending order mei profits mei ayega
       // Create an ArrayList for storing the current id 
       ArrayList<Integer> seq = new ArrayList<>();
       int time = 0;
       for(int i=0; i< jobs.size();i++){
          Job curr = jobs.get(i);
          if(curr.deadline > time){
            seq.add(curr.id);
            time++;
          }
       }
       // print seq
       System.out.println("max jobs = "+ seq.size());
       for(int i=0; i < seq.size();i++){
         System.out.println(seq.get(i)+" ");
       }

    }
}
   */
//                                        Chocola Problem 
//                     Most Important Question- Hard level Problem (Comes in Microsoft,Amazon,Google)
/* 
import java.util.*;
public class classroom{
    public static void main(String[]args){
    int n = 4;
    int m = 6;
    Integer costVer[] = {2,1,3,1,4}; // m-1
    Integer costHor[] = {4,1,2};// n-1

    Arrays.sort(costVer, Collections.reverseOrder());
    Arrays.sort(costHor,Collections.reverseOrder());

    int h = 0, v = 0;// pointer porinting to array
    int hp = 1, vp = 1;
    int cost = 0;

    while(h < costHor.length && v < costVer.length){
        if(costVer[v] <= costHor[h]){ // Horizontal Cut
            cost += (costHor[h] *vp);
            hp++;
            h++;
        }
        else{ // Vertical Cut
            cost+=(costVer[v] *hp);
            vp++;
            v++;

        }
    }
    while(h < costHor.length){
      cost += (costHor[h] * vp);
      hp++;
      h++;
    }
    while(v < costVer.length){
        cost += (costVer[v] * hp);
        vp++;
        v++;
    }

    System.out.println("Minimum cost of cuts "+ cost);

}
}
*/

//                                           Assignemnt Question 

// import java.util.*;
// public class classroom{
//     // Q1
//     public static int balancedStringSplit(String s) {
//         // edge case 
//         if(s.length() == 0 || s == null){
//             return 0;
//         }
//         int left = 0, right = 0, count = 0;
//         for(int i = 0 ; i < s.length(); i++){
//             char ch = s.charAt(i);
//             if(ch =='L'){
//                 left++;
//             }
//             else{
//                 right++;
//             }

//             if(left == right){
//                 count++;
//             }
//         }
//         return count;
//     }
//     // Q2
//     public static int findKthLargestOdd(int L, int R, int K){
//         ArrayList<Integer> oddNumbers = new ArrayList<>();
//         for(int i = L; i <= R;i++){
//             if(i %2 != 0){
//                 oddNumbers.add(i);
//             }
//         }
//         // Check validity
//         if(K > oddNumbers.size()){
//             return -1;
//         }

//         Collections.sort(oddNumbers, Collections.reverseOrder());
//         return oddNumbers.get(K-1);
//     }
//     // Q3
//     public String getSmallestString(int n, int k) {
//         char res[] = new char[n];// size of n
//         Arrays.fill(res,'a');
//         k = k-n;
//         while(k > 0){
//             res[n-1] += Math.min(25,k);
//             k -= Math.min(25,k);
//             n--;
//         }
//         return String.valueOf(res);
//     }



//     public static void main(String[]args){
//       String s = "RLRRLLRLRL";
//       System.out.println(balancedStringSplit(s));
//     }
// }

public class classroom{
    public static void main(String[]args){
        
    }
}