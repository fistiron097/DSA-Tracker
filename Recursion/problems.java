public class problems{

    public static void printIncrease(int n){
        // base case 
        if(n == 1){
            System.out.println(n);
            return;
        }
        // recursion
        printIncrease(n-1);
        System.out.println(n);
    }

    public static void printDecrease(int n){
        if(n == 0){
          return ;
        }
        // base case
        // recursion
        System.out.println(n);
        printDecrease(n-1);
        
    }
    public static int printFactorial(int n){
        // base case
        if(n == 0){
            return 1;
        }
        // recursion
        int fnm1 = printFactorial(n-1);
        int fn = n*fnm1;
        return fn;
    }

    public static int sumNumber(int n){
        // base case
        if(n == 1){
            return 1;
        }
        // recursion
        int nm1 = sumNumber(n-1);
        int sum = n+nm1;
        return sum;
    }

    public static int fiboNumber(int n){
        // base case
        if(n == 0 || n == 1){
            return n;
        }
        // recursion
        int fnm1 = fiboNumber(n-1);
        int fnm2 = fiboNumber(n-2);
        int fn = fnm1+fnm2;
        return fn;

    }
    public static boolean arraySort(int [] arr, int i){
        // base case
        if(i == arr.length-1){
          return true;
        }
        // recursion
        if(arr[i] >arr[i+1]){
          return false;
        }
        return arraySort(arr, i+1);

    }

    public static int firstOcc(int [] arr , int i, int key){
        // base case
        if(i == arr.length){
            return -1;
        }
        // recursion
        if(arr[i] == key){
            return i;
        }
       return firstOcc(arr, i+1, key);
    }
    public static int lastOccur(int[] arr, int i, int key) {
        // base case
        if (i == arr.length) {
            return -1;
        }
        // recursion
        int isFound = lastOccur(arr, i + 1, key);
        
        // Agar aage kahin element mil gaya toh usko return karo
        if (isFound != -1) {
            return isFound;
        }
        // Agar aage nahi mila aur current element key ke barabar hai toh current index return karo
        else if (arr[i] == key) {
            return i;
        }
        // Agar dono conditions satisfy nahi hoti toh -1 return karo
        return -1;
    }
    public static int pow(int x , int n){
        // base case
        if(n == 0){
            return 1;
        }
        // recursion
        int pnm1 = pow(x,n-1);
        int px = x*pnm1;
        return px;
    }

    public static int optimizedPower(int a, int n){
        // base case
        if(n == 0){
            return 1;
        }
        // recursion
        int halfPowerSq = optimizedPower(a, n/2) * optimizedPower(a, n/2);
        // check if n is odd or even
        if(n % 2 != 0){
            halfPowerSq = a *halfPowerSq;
        }

        return halfPowerSq;
    }
    public static int coutTiles(int n){
        // base case
        if(n ==0 || n ==1){
            return 1;
        }
        // recursion
        int vertical = coutTiles(n-1);
        int horizontal = coutTiles(n-2);

        int totalWays = vertical+horizontal;

        return totalWays; 
    }

    public static void removeDuplicates(String str, int idx,StringBuilder newStr,boolean map[]){
        // base case
        if(idx == str.length()){
            System.out.println(newStr);
            return;
        }
        // recurison
        char currChar = str.charAt(idx);
        if(map[currChar-'a'] == true){
            removeDuplicates(str,idx+1, newStr, map);
        }
        else{
            map[currChar-'a'] = true;
            removeDuplicates(str,idx+1, newStr.append(currChar), map);
        }
    }

    public static int pairProblem(int n){
        // base case
        if(n == 1 || n ==2){
            return n;
        }
        return pairProblem(n-1) + pairProblem(n-1) * pairProblem(n-2);
    }
    public static void occurrOFindex(int []arr, int i, int key){
        // base case
        if(i == arr.length){
            return;
        }
        //kaam
        if(arr[i] == key){
            System.out.print(i+" ");
        }
        occurrOFindex(arr, i+1, key);

    }

        public static void convertNo(int n, StringBuilder str){
            // base case
            if(n == 0){
                return;
            }

            convertNo(n/10, str);

            //kaam
            int number = n %10;

            if(number == 0){
                str.append("zero"+" ");            
            }

            if(number == 1){
                str.append("one"+" ");   
            }
            if(number == 2){
                str.append("two"+" ");   
            }
            if(number == 3){
                str.append("three"+" ");   
            }
            if(number == 4){
                str.append("four"+" ");   
            }
            if(number == 5){
                str.append("five"+" ");   
            }
            if(number == 6){    
                str.append("six"+" ");   
            }
            if(number == 7){
                str.append("seven"+" ");   
            }
            if(number == 8){
                str.append("eight"+" ");   
            }
            if(number == 9){
                str.append("nine"+" ");   
            }
            
        }

        public static int length(String str) {
            // Base case: If the string is empty, return 0
            if (str.length() == 0) {
                return 0;
            }
            // Recursive case: Call the function with the substring from index 1 and add 1
            return length(str.substring(1)) + 1;
        }

        public static int countSubstr(String str, int i, int j,int n){
            // base case
            if(n ==1){
                return 1;
            }
            if(n<=0){
                return 0;
            }
            int res = countSubstr(str, i+1, j, n-1) + countSubstr(str, i, j-1, n-1)- countSubstr(str, i+1, j-1, n-2);
            if(str.charAt(i) == str.charAt(j)){
                res++;
            }
            return res;

        }

        public static void towerOfHanoi(int n, String src, String helper, String dest){
            if(n == 1){
                System.out.println("transfer disk "+ n + "from" + src + "to"+ dest);
                return;
            }
            towerOfHanoi(n-1, src, dest, helper);
            System.out.println("transfer disk "+ n + "from" + src + "to"+ dest);
            towerOfHanoi(n-1, helper, src, dest);

        }

    public static void main(String[]args){
        //String str = "appnnacollege";
        //removeDuplicates(str, 0, new StringBuilder(""), new boolean[26]);

        // int[] arr = {3,2,4,5,6,2,7,2,2};
        // occurrOFindex(arr, 0,2);

        // int n = 2019;
        // StringBuilder str = new StringBuilder("");
        // convertNo(n, str);
        // System.out.println(str.toString());

        //String str = "ApnaCollege";
        //String str = "aba";
        //System.out.println(countSubstr(str,0, str.length()-1, str.length()));

        
    }
}