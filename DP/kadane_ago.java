package DP;

public class kadane_ago {
    class Solution {
    int maxSubstring(String S) {
        int [] arr = new int[S.length()];
        for(int i=0; i<arr.length;i++){
            if(S.charAt(i) == '0'){
                arr[i] = 1;
            } else {
                arr[i] = -1;
            }
        }

        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;  // handle negative case properly

        for(int i=0; i<arr.length;i++){
            currSum += arr[i];
            if(maxSum < currSum){
                maxSum = currSum;
            }
            if(currSum < 0){
                currSum = 0;
            }
        }

        return (maxSum == 0) ? -1 : maxSum;
    }
}

}
